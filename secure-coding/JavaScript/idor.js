// make sure you have nodejs installed, initialize a new project, and install express

const express = require('express');
const app = express();
const port = 3000;

const users = {
    1: { name: 'Alice', email: 'alice@example.com' },
    2: { name: 'Bob', email: 'bob@example.com' },
    3: { name: 'Charlie', email: 'charlie@example.com' }
};

app.get('/user/:id', (req, res) => {
    const userId = req.params.id;
    
    // Vulnerable: The ID is used directly from the URL without checking if the requesting user is authorized
    const user = users[userId];
    
    if (user) {
        res.json(user);
    } else {
        res.status(404).send('User not found');
    }
});

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});



// Allows an attacker to change the userId parameter in the URL to access other users' data.