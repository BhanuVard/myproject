const OtpService = require('../services/OtpService'); // Ensure this is imported only once

class OtpController {
    static async sendOTP(req, res) {
        try {
            const { email } = req.body;

            if (!email || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
                return res.status(400).json({
                    success: false,
                    message: 'Please provide a valid email address'
                });
            }

            const otp = await OtpService.sendOTP(email);

            res.status(200).json({
                success: true,
                message: 'OTP sent successfully',
                otp // Remove in production
            });
        } catch (error) {
            res.status(500).json({
                success: false,
                message: 'Failed to send OTP',
                error: error.message
            });
        }
    }

    static async verifyOTP(req, res) {
        try {
            const { email, otp } = req.body;

            const isValid = await OtpService.verifyOTP(email, otp);
            if (!isValid) {
                return res.status(400).json({
                    success: false,
                    message: 'Invalid or expired OTP'
                });
            }

            res.status(200).json({
                success: true,
                message: 'Email verified successfully'
            });
        } catch (error) {
            res.status(500).json({
                success: false,
                message: 'Verification failed',
                error: error.message
            });
        }
    }
}

module.exports = OtpController;