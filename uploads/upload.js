const multer = require("multer");
const path = require("path");

// Define storage configuration
const storage = multer.diskStorage({
    destination: (req, file, cb) => {
        cb(null, "uploads/");  // Save files in the 'uploads/' folder
    },
    filename: (req, file, cb) => {
        cb(null, file.fieldname + "_" + Date.now() + path.extname(file.documents));  
        // Example: healthCard_1708776543210.jpg or documents_1708776543210.pdf
    }
});

// Define file upload with two fields
const upload = multer({
    storage: storage,
}).fields([
    { name: "documents", maxCount: 1 },  // Upload 1 document file
    { name: "healthCard", maxCount: 1 }  // Upload 1 health card file
]);

module.exports = upload;
