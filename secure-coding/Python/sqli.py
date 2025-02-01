# SQLI vulnerability in Flask web application

from flask import Flask, request
import sqlite3

app = Flask(__name__)

@app.route('/login', methods=['POST'])
def login():
    username = request.form['username']
    password = request.form['password']
    
    # Vulnerable query, directly concatenating user input into the SQL query
    conn = sqlite3.connect('users.db')
    cursor = conn.cursor()
    cursor.execute(f"SELECT * FROM users WHERE username='{username}' AND password='{password}'")
    user = cursor.fetchone()
    conn.close()
    
    if user:
        return "Login successful"
    else:
        return "Login failed"

if __name__ == '__main__':
    app.run(debug=True)
