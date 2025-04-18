const express = require('express');
const router = express.Router();
const profileController = require('../controllers/profile.controller');

// User profile routes
router.get('/user/profile/:userId', profileController.getUserProfile);
router.put('/user/profile/update/:userId', profileController.updateUserProfile);

// Owner profile routes
router.get('/owner/profile/:ownerId', profileController.getOwnerProfile);
router.put('/owner/profile/update/:ownerId', profileController.updateOwnerProfile);

module.exports = router;