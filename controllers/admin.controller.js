const { registerUser, loginUser } = require('../services/auth.service');

const registerAdmin = async (req, res) => {
    try {
        const { username, email, password } = req.body;

        if (!username || !email || !password) {
            return res.status(400).json({ error: 'All fields are required' });
        }

        const { token, user } = await registerUser({ username, email, password }, 'admin');
        res.status(201).json({ message: 'Admin registered successfully', token });
    } catch (error) {
        const statusCode = error.statusCode || 500;
        const message = error.statusCode ? error.message : 'Internal server error';
        res.status(statusCode).json({ error: message });
    }
};

const loginAdmin = async (req, res) => {
    try {
        const { username, password } = req.body;

        if (!username || !password) {
            return res.status(400).json({ error: 'All fields are required' });
        }

        const { token, user } = await loginUser(username, password, 'admin');
        res.status(200).json({ message: 'Admin login successful', token });
    } catch (error) {
        const statusCode = error.statusCode || 500;
        const message = error.statusCode ? error.message : 'Internal server error';
        res.status(statusCode).json({ error: message });
    }
};

module.exports = { registerAdmin, loginAdmin };
