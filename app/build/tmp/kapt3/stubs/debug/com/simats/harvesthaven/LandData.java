package com.simats.harvesthaven;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\t\u00a8\u0006 "}, d2 = {"Lcom/simats/harvesthaven/LandData;", "", "()V", "amenities", "", "", "getAmenities", "()Ljava/util/List;", "setAmenities", "(Ljava/util/List;)V", "documents", "getDocuments", "()Ljava/lang/String;", "setDocuments", "(Ljava/lang/String;)V", "healthCard", "getHealthCard", "setHealthCard", "photos", "getPhotos", "setPhotos", "previousUse", "getPreviousUse", "setPreviousUse", "restrictions", "getRestrictions", "setRestrictions", "yearlyProfits", "Lcom/simats/harvesthaven/models/YearlyProfit;", "getYearlyProfits", "setYearlyProfits", "Companion", "app_debug"})
public final class LandData {
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> photos;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String previousUse;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> amenities;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> restrictions;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.simats.harvesthaven.models.YearlyProfit> yearlyProfits;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String documents;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String healthCard;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.simats.harvesthaven.LandData instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.simats.harvesthaven.LandData.Companion Companion = null;
    
    private LandData() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getPhotos() {
        return null;
    }
    
    public final void setPhotos(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPreviousUse() {
        return null;
    }
    
    public final void setPreviousUse(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getAmenities() {
        return null;
    }
    
    public final void setAmenities(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getRestrictions() {
        return null;
    }
    
    public final void setRestrictions(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.simats.harvesthaven.models.YearlyProfit> getYearlyProfits() {
        return null;
    }
    
    public final void setYearlyProfits(@org.jetbrains.annotations.Nullable()
    java.util.List<com.simats.harvesthaven.models.YearlyProfit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDocuments() {
        return null;
    }
    
    public final void setDocuments(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHealthCard() {
        return null;
    }
    
    public final void setHealthCard(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/simats/harvesthaven/LandData$Companion;", "", "()V", "instance", "Lcom/simats/harvesthaven/LandData;", "clearInstance", "", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.simats.harvesthaven.LandData getInstance() {
            return null;
        }
        
        public final void clearInstance() {
        }
    }
}