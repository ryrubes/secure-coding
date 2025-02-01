# Remediate: Use parameterized queries (prepared statements)

from flask import Flask, request
import sqlite3

app = Flask(__name__)

@app.route('/login', methods=['POST', 'GET'])
def login():
    username = request.form['username']
    password = request.form['password']
    
    # Use parameterized query to prevent SQL injection
    conn = sqlite3.connect('users.db')
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM users WHERE username=? AND password=?", (username, password))
    user = cursor.fetchone()
    conn.close()
    
    if user:
        return "Login successful"
    else:
        return "Login failed"