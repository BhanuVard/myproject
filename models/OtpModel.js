const mongoose = require('mongoose');

const otpSchema = new mongoose.Schema({
    mobile: {
        type: String,
        required: false
    },
    email: {
        type: String,
        required: false
    },
    otp: {
        code: String,
        expiry: Date
    },
    isVerified: {
        type: Boolean,
        default: false
    }
}, { timestamps: true });

const OtpModel = mongoose.model('OtpModel', otpSchema);
module.exports = OtpModel;