const mongoose = require("mongoose");

const LandSchema = new mongoose.Schema({
    // Basic Information
    owner: { type: mongoose.Schema.Types.ObjectId, ref: "User", required: true },
    title: { type: String, required: true },
    description: { type: String, required: true },
    landType: { type: String, required: true },
    area: { type: Number, required: true },
    areaUnit: { type: String, enum: ["Acres", "Hectares", "Square Meters"], required: true },
    price: { type: Number, required: true },
    status: { type: String, enum: ["Rent", "Sell", "Lease"], default: "Sell" },
    
    // Location Details
    location: {
        address: { type: String, required: true },
        city: { type: String, required: true },
        state: { type: String, required: true },
        country: { type: String, required: true },
        coordinates: {
            type: { type: String, default: "Point" },
            coordinates: [Number] // [longitude, latitude]
        }
    },
    
    // Land Characteristics
    soilType: { type: String, required: true },
    waterSource: { type: [String] },
    irrigation: { type: Boolean, default: false },
    
    // Media
    images: [{
        url: { type: String },
        caption: { type: String }
    }],
    
    // Land Documents
    documents: {
        adangal: {
            url: { type: String },
            verified: { type: Boolean, default: false },
            uploadDate: { type: Date }
        },
        oneB: {
            url: { type: String },
            verified: { type: Boolean, default: false },
            uploadDate: { type: Date }
        },
        soilHealthCard: {
            url: { type: String },
            verified: { type: Boolean, default: false },
            uploadDate: { type: Date },
            validUntil: { type: Date }
        },
        passbook: {
            url: { type: String },
            verified: { type: Boolean, default: false },
            uploadDate: { type: Date }
        }
    },
    
    // Additional Info
    verified: { type: Boolean, default: false }
}, { timestamps: true });

// Create indexes for efficient searching
LandSchema.index({ 'location.coordinates': '2dsphere' });
LandSchema.index({ price: 1, area: 1 });
LandSchema.index({ 'location.city': 1, 'location.state': 1 });
LandSchema.index({ landType: 1, status: 1 });
LandSchema.index({ soilType: 1, cropsCultivated: 1 });

module.exports = mongoose.model("Land", LandSchema);
