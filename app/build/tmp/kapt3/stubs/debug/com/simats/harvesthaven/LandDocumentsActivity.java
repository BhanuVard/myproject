package com.simats.harvesthaven;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\"\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/simats/harvesthaven/LandDocumentsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "RC_UPLOAD_FILE", "", "currentDocumentType", "", "landData", "Lcom/simats/harvesthaven/LandData;", "uploadedDocuments", "", "Landroid/net/Uri;", "checkEnableSubmit", "", "handleFileUpload", "fileUri", "handleUploadButtonClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "selectFileToUpload", "documentType", "setupDocumentUploadListeners", "submitFullLandListing", "app_debug"})
public final class LandDocumentsActivity extends androidx.appcompat.app.AppCompatActivity {
    private final int RC_UPLOAD_FILE = 1002;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String currentDocumentType;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, android.net.Uri> uploadedDocuments = null;
    @org.jetbrains.annotations.NotNull()
    private final com.simats.harvesthaven.LandData landData = null;
    
    public LandDocumentsActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupDocumentUploadListeners() {
    }
    
    private final void selectFileToUpload(java.lang.String documentType) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void handleFileUpload(android.net.Uri fileUri) {
    }
    
    private final void checkEnableSubmit() {
    }
    
    private final void handleUploadButtonClick() {
    }
    
    private final void submitFullLandListing() {
    }
}