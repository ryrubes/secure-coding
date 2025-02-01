from flask import Flask, request
from flask_wtf.csrf import CSRFProtect



app = Flask(__name__)
csrf = CSRFProtect(app)  # Enable CSRF protection globally

# Remediate: Add CSRF protection to the form
@app.route('/change-password', methods=['POST'])
def change_password():
    new_password = request.form['new_password']
    return f"Password changed to {new_password}"
