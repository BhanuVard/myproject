const nodemailer = require('nodemailer');

class EmailService {
    constructor() {
        this.transporter = nodemailer.createTransport({
            service: 'gmail',
            auth: {
                user: process.env.EMAIL_USER,
                pass: process.env.EMAIL_APP_PASSWORD
            }
        });
    }

    async sendEmail(to, subject, message) {
        try {
            const mailOptions = {
                from: process.env.EMAIL_USER,
                to: to,
                subject: subject,
                text: message
            };

            const info = await this.transporter.sendMail(mailOptions);
            return { success: true, messageId: info.messageId };
        } catch (error) {
            console.error('Email sending failed:', error);
            return { success: false, error: error.message };
        }
    }

    async sendOTPEmail(email, otp) {
        const subject = 'HarvestHeaven Verification Code';
        const message = `Your HarvestHeaven verification code is: ${otp}. Valid for 5 minutes.`;
        return this.sendEmail(email, subject, message);
    }
}

module.exports = new EmailService();