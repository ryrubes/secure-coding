from flask import Flask, render_template_string, request

app = Flask(__name__)

# Remediate: Use auto-escaping in templates to prevent XSS
@app.route('/comment', methods=['POST'])
def comment():
    comment = request.form['comment']
    
    # Flask will auto-escape the comment to prevent XSS
    return render_template_string("<h1>Your comment:</h1><p>{{ comment }}</p>", comment=comment)
