const Land = require("../models/land.model"); // Import Land model

exports.createLand = async (landData) => {
    return await new Land(landData).save();
};

exports.getAllLands = async () => {
    return await Land.find().populate("owner");
};

exports.getLandById = async (id) => {
    return await Land.findById(id).populate("owner");
};

exports.updateLand = async (id, landData) => {
    return await Land.findByIdAndUpdate(id, landData, { new: true });
};

exports.deleteLand = async (id) => {
    return await Land.findByIdAndDelete(id);
};
