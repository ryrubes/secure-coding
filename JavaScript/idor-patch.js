const express = require('express');
const app = express();
const port = 3000;

// Simulated users and their data
const users = {
    1: { name: 'Alice', email: 'alice@example.com' },
    2: { name: 'Bob', email: 'bob@example.com' },
    3: { name: 'Charlie', email: 'charlie@example.com' }
};

// Simulate a logged-in user (you'd normally get this from a session or token)
const loggedInUserId = 1; // Let's assume Alice is logged in for this example

app.get('/user/:id', (req, res) => {
    const userId = req.params.id;
    
    // Remediate: Check if the logged-in user is trying to access their own data
    if (parseInt(userId) !== loggedInUserId) {
        return res.status(403).send('Forbidden: You can only access your own data');
    }
    
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



// Implements a simple access control check, ensuring that only the logged-in user can access their own data.