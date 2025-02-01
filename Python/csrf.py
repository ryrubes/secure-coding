from flask import Flask, request

app = Flask(__name__)

@app.route('/change-password', methods=['POST'])
def change_password():
    new_password = request.form['new_password']
    
    # Vulnerable to CSRF: No CSRF token protection
    # Password change action could be forged by an attacker.
    # This endpoint would trigger password change without verifying origin.
    return f"Password changed to {new_password}"

if __name__ == '__main__':
    app.run(debug=True)
