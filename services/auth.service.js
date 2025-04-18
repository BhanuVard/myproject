const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");
const User = require("../models/User");
const Owner = require("../models/Owner");


class AuthError extends Error {
    constructor(message, statusCode = 500) {
        super(message);
        this.statusCode = statusCode;
        this.name = 'AuthError';
    }
}

const generateToken = (user) => {
    return jwt.sign({ id: user._id, role: user.role }, process.env.JWT_SECRET, { expiresIn: "7d" });
};

const registerUser = async (data, role) => {
    try {
        if (!data.password) {
            throw new AuthError('Password is required', 400);
        }

        const hashedPassword = await bcrypt.hash(data.password, 10);
        data.password = hashedPassword;

        let Model;
        switch(role) {
            case 'user': Model = User; break;
            case 'owner': Model = Owner; break;
            default: throw new AuthError('Invalid role specified', 400);
        }

        const existingUser = await Model.findOne({ email: data.email });
        if (existingUser) {
            throw new AuthError('User already exists', 400);
        }

        const user = new Model(data);
        await user.save();
        return { token: generateToken(user), user };
    } catch (error) {
        if (error instanceof AuthError) throw error;
        throw new AuthError('Error creating user: ' + error.message);
    }
};

const loginUser = async (email, password, role) => {
    try {
        if (!email || !password) {
            throw new AuthError('Email and password are required', 400);
        }

        let Model;
        switch(role) {
            case 'user': Model = User; break;
            case 'owner': Model = Owner; break;
            default: throw new AuthError('Invalid role specified', 400);
        }

        const user = await Model.findOne({ email });
        if (!user) {
            throw new AuthError('Invalid credentials', 401);
        }

        const isValidPassword = await bcrypt.compare(password, user.password);
        if (!isValidPassword) {
            throw new AuthError('Invalid credentials', 401);
        }

        return { token: generateToken(user), user };
    } catch (error) {
        if (error instanceof AuthError) throw error;
        throw new AuthError('Error during login: ' + error.message);
    }
};

module.exports = { registerUser, loginUser };
