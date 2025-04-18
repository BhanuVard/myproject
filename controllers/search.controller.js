const Land = require("../models/landModel.js");

exports.searchLands = async (req, res) => {
    try {
        const {
            minPrice,
            maxPrice,
            minArea,
            maxArea,
            areaUnit,
            landType,
            status,
            city,
            state,
            soilType,
            waterSource,
            irrigation,
            cropType
        } = req.query;

        // Build search query
        const query = {};

        // Price range
        if (minPrice || maxPrice) {
            query.price = {};
            if (minPrice) query.price.$gte = Number(minPrice);
            if (maxPrice) query.price.$lte = Number(maxPrice);
        }

        // Area range
        if (minArea || maxArea) {
            query.area = {};
            if (minArea) query.area.$gte = Number(minArea);
            if (maxArea) query.area.$lte = Number(maxArea);
        }

        // Area unit
        if (areaUnit) query.areaUnit = areaUnit;

        // Land type
        if (landType) query.landType = landType;

        // Status (Rent/Sell/Lease)
        if (status) query.status = status;

        // Location
        if (city) query['location.city'] = { $regex: city, $options: 'i' };
        if (state) query['location.state'] = { $regex: state, $options: 'i' };

        // Soil type
        if (soilType) query.soilType = { $regex: soilType, $options: 'i' };

        // Water source
        if (waterSource) query.waterSource = { $in: [waterSource] };

        // Irrigation
        if (irrigation !== undefined) query.irrigation = irrigation === 'true';

        // Crops
        if (cropType) query.cropsCultivated = { $in: [cropType] };

        // Execute search with pagination
        const page = parseInt(req.query.page) || 1;
        const limit = parseInt(req.query.limit) || 10;
        const skip = (page - 1) * limit;

        const lands = await Land.find(query)
            .populate('owner', 'name email phone')
            .skip(skip)
            .limit(limit)
            .sort({ createdAt: -1 });

        // Get total count for pagination
        const total = await Land.countDocuments(query);

        res.json({
            lands,
            pagination: {
                total,
                page,
                pages: Math.ceil(total / limit)
            }
        });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};

exports.getNearbyLands = async (req, res) => {
    try {
        const { latitude, longitude, radius = 10 } = req.query; // radius in kilometers

        if (!latitude || !longitude) {
            return res.status(400).json({ message: "Latitude and longitude are required" });
        }

        const lands = await Land.find({
            'location.coordinates': {
                $near: {
                    $geometry: {
                        type: "Point",
                        coordinates: [parseFloat(longitude), parseFloat(latitude)]
                    },
                    $maxDistance: radius * 1000 // Convert to meters
                }
            }
        }).populate('owner', 'name email phone');

        res.json(lands);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};