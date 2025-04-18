const mongoose = require("mongoose");
const express = require("express");
const app = express();
const cors = require("cors");
require("dotenv").config();

// Create geospatial index for location coordinates
const Land = require("./models/landModel");
Land.collection.createIndex({ 'location.coordinates': '2dsphere' });
const userRoutes = require('./routes/userRoutes');
const ownerRoutes = require('./routes/ownerRoutes');
const otpRoutes = require('./routes/otpRoutes');
const landRoutes = require('./routes/land.router');
const profileRoutes = require('./routes/profile.router');
const PORT = process.env.PORT || 5000;
const HOST = '192.168.31.42';

// Middleware
app.use(cors());
app.use(express.json());

// Error handling middleware
app.use((err, req, res, next) => {
    console.error('Error:', err.stack);
    res.status(500).json({
        success: false,
        message: 'Internal server error',
        error: process.env.NODE_ENV === 'development' ? err.message : undefined
    });
});

// Routes
app.use("/api/users", userRoutes);
app.use("/api/owners", ownerRoutes);
app.use("/api/land", landRoutes);
app.use("/api/otp", otpRoutes);
app.use("/api/profile", profileRoutes);
app.use("/api/search", require("./routes/search.router"));

// Root route
app.get('/', (req, res) => {
    res.send('Welcome to the Harvest Haven API');
});

// MongoDB Connection with retry logic
const connectDB = async () => {
    try {
        await mongoose.connect(process.env.MONGO_URI, {
            useNewUrlParser: true,
            useUnifiedTopology: true
        });
        console.log('✅ Connected to MongoDB');
        
        // Start server only after successful DB connection
        app.listen(PORT, HOST, () => {
            console.log(`🚀 Server running at http://${HOST}:${PORT}`);
        });
    } catch (error) {
        console.error('❌ MongoDB connection error:', error.message);
        // Retry connection after 5 seconds
        console.log('Retrying connection in 5 seconds...');
        setTimeout(connectDB, 5000);
    }
};

// Initialize connection
connectDB();

// Handle unhandled promise rejections
process.on('unhandledRejection', (err) => {
    console.error('Unhandled Promise Rejection:', err);
    process.exit(1);
});