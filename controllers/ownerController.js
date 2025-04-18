const { registerUser, loginUser } = require('../services/auth.service');

exports.register = async (req, res) => {
    try {
        const { name, username, email, phone, password } = req.body;

        if (!name || !username || !email || !phone || !password) {
            return res.status(400).json({ error: 'All fields are required' });
        }

        const { token, user } = await registerUser({ name, username, email, phone, password }, 'owner');
        res.status(201).json({ message: 'Owner registered successfully', token });
    } catch (error) {
        const statusCode = error.statusCode || 500;
        const message = error.statusCode ? error.message : 'Internal server error';
        res.status(statusCode).json({ error: message });
    }
};

exports.login = async (req, res) => {
    try {
        const { username, password } = req.body;

        if (!username || !password) {
            return res.status(400).json({ error: 'Username and password are required' });
        }

        const { token, user } = await loginUser(username, password, 'owner');
        res.status(200).json({ message: 'Login successful', token });
    } catch (error) {
        const statusCode = error.statusCode || 500;
        const message = error.statusCode ? error.message : 'Internal server error';
        res.status(statusCode).json({ error: message });
    }
};