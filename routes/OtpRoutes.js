const express = require('express');
const router = express.Router();
const OtpController = require('../controllers/OtpController');

// Route to send OTP
router.post('/send', OtpController.sendOTP);

// Route to verify OTP
router.post('/verify', OtpController.verifyOTP);

module.exports = router;