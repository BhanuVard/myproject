const mongoose = require('mongoose');

const connectDB = async () => {
    try {
        await mongoose.connect('mongodb://localhost:27017/harvest_haven', {
            useNewUrlParser: true,
            useUnifiedTopology: true
        });
        console.log('MongoDB connected: harvest_haven');
    } catch (err) {
        console.error('MongoDB connection error:', err.message);
        process.exit(1);
    }
};

module.exports = connectDB;
