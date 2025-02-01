from flask import Flask, render_template_string, request

app = Flask(__name__)

@app.route('/comment', methods=['POST'])
def comment():
    comment = request.form['comment']
    
    # Vulnerable: directly rendering user input (could include malicious scripts)
    return render_template_string(f"<h1>Your comment:</h1><p>{comment}</p>")

if __name__ == '__main__':
    app.run(debug=True)
