const Land = require("../models/landModel.js"); 

exports.addLand = async (req, res) => {
    try {
        const {
            owner, title, description, landType, area, areaUnit,
            price, status, location, soilType, waterSource,
            irrigation, images
        } = req.body;

        // Validate required fields
        if (!owner || !title || !description || !landType || !area || !areaUnit || !price || !location.address) {
            return res.status(400).json({ message: "Missing required fields" });
        }

        const land = new Land({
            owner,
            title,
            description,
            landType,
            area,
            areaUnit,
            price,
            status,
            location,
            soilType,
            waterSource,
            irrigation,
            images
        });

        await land.save();
        res.status(201).json({ message: "Land added successfully", land });
    } catch (error) {
        res.status(500).json({ message: "Error adding land", error: error.message });
    }
};

exports.getAllLands = async (req, res) => {
    try {
        const lands = await Land.find().populate("owner");
        res.json(lands);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};

exports.getLandById = async (req, res) => {
    try {
        const land = await Land.findById(req.params.id.trim()).populate("owner");
        if (!land) return res.status(404).json({ message: "Land not found" });
        res.json(land);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};

exports.updateLand = async (req, res) => {
    try {
        const landId = req.params.id.trim();
        const updates = req.body;

        // Validate the update data
        if (updates.location && typeof updates.location === 'string') {
            return res.status(400).json({ message: "Location must be an object with address and coordinates" });
        }

        const updatedLand = await Land.findByIdAndUpdate(
            landId,
            { $set: updates },
            { new: true, runValidators: true }
        );

        if (!updatedLand) {
            return res.status(404).json({ message: "Land not found" });
        }

        res.json({ message: "Land updated successfully", land: updatedLand });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};

exports.deleteLand = async (req, res) => {
    try {
        const deletedLand = await Land.findByIdAndDelete(req.params.id.trim());
        if (!deletedLand) return res.status(404).json({ message: "Land not found" });
        res.json({ message: "Land deleted successfully" });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};
