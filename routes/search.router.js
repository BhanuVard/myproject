const router = require("express").Router();
const SearchController = require("../controllers/search.controller.js");

// Search lands with filters
router.get("/lands", SearchController.searchLands);

// Get nearby lands
router.get("/nearby", SearchController.getNearbyLands);

module.exports = router;