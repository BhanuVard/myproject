const crypto = require('crypto');
const OtpModel = require('../models/OtpModel');
const emailService = require('../utils/emailService');
// Removed Twilio dependency for a simpler development solution

class OtpService {
    static generateOTP() {
        return crypto.randomInt(1000, 9999).toString();
    }

    static async sendOTP(email) {
        const otp = {
            code: this.generateOTP(),
            expiry: new Date(Date.now() + 5 * 60 * 1000) // 5 minutes expiry
        };

        let otpRecord = await OtpModel.findOne({ email });
        if (!otpRecord) {
            otpRecord = new OtpModel({ email });
        }

        otpRecord.otp = otp;
        otpRecord.isVerified = false;
        await otpRecord.save();

        // Send OTP via Email
        const emailResult = await emailService.sendOTPEmail(email, otp.code);

        if (!emailResult.success) {
            console.error('Failed to send OTP via Email:', emailResult.error);
            throw new Error('Failed to send OTP via Email');
        }

        // For development purposes only - remove in production
        console.log(`Development mode - OTP for ${email}: ${otp.code}`);


        return otp.code;
    }

    static async verifyOTP(email, otpCode) {
        const otpRecord = await OtpModel.findOne({ email });

        if (!otpRecord || !otpRecord.otp || !otpRecord.otp.code) {
            return false;
        }

        if (Date.now() > new Date(otpRecord.otp.expiry).getTime()) {
            return false;
        }

        if (otpRecord.otp.code === otpCode) {
            otpRecord.isVerified = true;
            otpRecord.otp = undefined;
            await otpRecord.save();
            return true;
        }

        return false;
    }
}

module.exports = OtpService;