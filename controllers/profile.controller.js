const User = require('../models/User');
const Owner = require('../models/Owner');

// Get user profile
exports.getUserProfile = async (req, res) => {
    try {
        const userId = req.params.userId;
        const user = await User.findById(userId).select('name email ');
        
        if (!user) {
            return res.status(404).json({ message: 'User not found' });
        }

        res.json(user);
    } catch (error) {
        res.status(500).json({ message: 'Error fetching user profile', error: error.message });
    }
};

// Update user profile
exports.updateUserProfile = async (req, res) => {
    try {
        const userId = req.params.userId;
        const { name, email } = req.body;

        const user = await User.findById(userId);
        if (!user) {
            return res.status(404).json({ message: 'User not found' });
        }

        // Update user fields
        user.name = name;
        user.email = email;
       

        await user.save();

        res.json({ message: 'Profile updated successfully', user });
    } catch (error) {
        res.status(500).json({ message: 'Error updating user profile', error: error.message });
    }
};

// Get owner profile
exports.getOwnerProfile = async (req, res) => {
    try {
        const ownerId = req.params.ownerId;
        const owner = await Owner.findById(ownerId).select('name email ');
        
        if (!owner) {
            return res.status(404).json({ message: 'Owner not found' });
        }

        res.json(owner);
    } catch (error) {
        res.status(500).json({ message: 'Error fetching owner profile', error: error.message });
    }
};

// Update owner profile
exports.updateOwnerProfile = async (req, res) => {
    try {
        const ownerId = req.params.ownerId;
        const { name, email } = req.body;

        const owner = await Owner.findById(ownerId);
        if (!owner) {
            return res.status(404).json({ message: 'Owner not found' });
        }

        // Update owner fields
        owner.name = name;
        owner.email = email;
       

        await owner.save();

        res.json({ message: 'Profile updated successfully', owner });
    } catch (error) {
        res.status(500).json({ message: 'Error updating owner profile', error: error.message });
    }
};