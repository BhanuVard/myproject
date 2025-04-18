const router = require("express").Router();
const LandController = require("../controllers/land.controller.js");

router.post("/add", LandController.addLand);
router.get("/list", LandController.getAllLands);
router.get("/:id", LandController.getLandById);
router.put("/:id", LandController.updateLand);
router.delete("/:id", LandController.deleteLand);

module.exports = router;
