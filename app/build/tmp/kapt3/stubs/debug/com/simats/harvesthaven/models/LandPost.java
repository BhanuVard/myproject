package com.simats.harvesthaven.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\bL\b\u0086\b\u0018\u00002\u00020\u0001B\u00e9\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u0012\u0006\u0010\'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0011\u0012\b\b\u0002\u0010*\u001a\u00020\u0011\u0012\b\b\u0002\u0010+\u001a\u00020,\u00a2\u0006\u0002\u0010-J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\t\u0010T\u001a\u00020\fH\u00c6\u0003J\t\u0010U\u001a\u00020\u0003H\u00c6\u0003J\t\u0010V\u001a\u00020\u0011H\u00c6\u0003J\t\u0010W\u001a\u00020\u0013H\u00c6\u0003J\t\u0010X\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0011H\u00c6\u0003J\u000f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u00c6\u0003J\u0011\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016H\u00c6\u0003J\t\u0010]\u001a\u00020\u0003H\u00c6\u0003J\t\u0010^\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010_\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016H\u00c6\u0003J\u0011\u0010`\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0016H\u00c6\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010c\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0016H\u00c6\u0003J\u0011\u0010d\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0016H\u00c6\u0003J\u0011\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016H\u00c6\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016H\u00c6\u0003J\t\u0010g\u001a\u00020\u0003H\u00c6\u0003J\t\u0010h\u001a\u00020\u0003H\u00c6\u0003J\t\u0010i\u001a\u00020\u0003H\u00c6\u0003J\t\u0010j\u001a\u00020\u0011H\u00c6\u0003J\t\u0010k\u001a\u00020\u0011H\u00c6\u0003J\t\u0010l\u001a\u00020,H\u00c6\u0003J\t\u0010m\u001a\u00020\u0003H\u00c6\u0003J\t\u0010n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010o\u001a\u00020\u0003H\u00c6\u0003J\t\u0010p\u001a\u00020\u0003H\u00c6\u0003J\t\u0010q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010r\u001a\u00020\fH\u00c6\u0003J\u009d\u0003\u0010s\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00112\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00032\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00162\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00162\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00162\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00162\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\b\b\u0002\u0010\'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00112\b\b\u0002\u0010*\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020,H\u00c6\u0001J\u0013\u0010t\u001a\u00020\u00112\b\u0010u\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010v\u001a\u00020,H\u00d6\u0001J\t\u0010w\u001a\u00020\u0003H\u00d6\u0001R\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\'\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00103R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00103R\u0011\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u00103R\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010/R\u0011\u0010\u0017\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010*\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010>R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010>R\u0011\u0010)\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010>R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u00103R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u00103R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u00103R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u00103R\u0019\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010/R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u00103R\u0011\u0010\u000e\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u00101R\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010/R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u00103R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u00103R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u00103R\u0011\u0010(\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u00103R\u0011\u0010+\u001a\u00020,\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010/R\u0019\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010/\u00a8\u0006x"}, d2 = {"Lcom/simats/harvesthaven/models/LandPost;", "", "id", "", "owner", "ownerName", "ownerContact", "landTitle", "title", "description", "landType", "area", "", "areaUnit", "price", "status", "isAvailable", "", "location", "Lcom/simats/harvesthaven/api/Location;", "soilType", "waterSource", "", "irrigation", "cropTypes", "cropsCultivated", "imageUrl", "images", "Lcom/simats/harvesthaven/api/Image;", "documents", "Lcom/simats/harvesthaven/api/Document;", "healthCard", "previousUse", "previousProfits", "Lcom/simats/harvesthaven/models/YearlyProfit;", "yieldHistory", "Lcom/simats/harvesthaven/models/YearlyYield;", "amenities", "restrictions", "createdAt", "updatedAt", "isVerified", "isActive", "views", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;DLjava/lang/String;ZLcom/simats/harvesthaven/api/Location;Ljava/lang/String;Ljava/util/List;ZLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZZI)V", "getAmenities", "()Ljava/util/List;", "getArea", "()D", "getAreaUnit", "()Ljava/lang/String;", "getCreatedAt", "getCropTypes", "getCropsCultivated", "getDescription", "getDocuments", "getHealthCard", "getId", "getImageUrl", "getImages", "getIrrigation", "()Z", "getLandTitle", "getLandType", "getLocation", "()Lcom/simats/harvesthaven/api/Location;", "getOwner", "getOwnerContact", "getOwnerName", "getPreviousProfits", "getPreviousUse", "getPrice", "getRestrictions", "getSoilType", "getStatus", "getTitle", "getUpdatedAt", "getViews", "()I", "getWaterSource", "getYieldHistory", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class LandPost {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String owner = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ownerName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ownerContact = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String landTitle = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String landType = null;
    private final double area = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String areaUnit = null;
    private final double price = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String status = null;
    private final boolean isAvailable = false;
    @org.jetbrains.annotations.NotNull()
    private final com.simats.harvesthaven.api.Location location = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String soilType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> waterSource = null;
    private final boolean irrigation = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> cropTypes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> cropsCultivated = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String imageUrl = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.simats.harvesthaven.api.Image> images = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.simats.harvesthaven.api.Document> documents = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String healthCard = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String previousUse = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.simats.harvesthaven.models.YearlyProfit> previousProfits = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.simats.harvesthaven.models.YearlyYield> yieldHistory = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> amenities = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> restrictions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String createdAt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String updatedAt = null;
    private final boolean isVerified = false;
    private final boolean isActive = false;
    private final int views = 0;
    
    public LandPost(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String owner, @org.jetbrains.annotations.NotNull()
    java.lang.String ownerName, @org.jetbrains.annotations.NotNull()
    java.lang.String ownerContact, @org.jetbrains.annotations.NotNull()
    java.lang.String landTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String landType, double area, @org.jetbrains.annotations.NotNull()
    java.lang.String areaUnit, double price, @org.jetbrains.annotations.NotNull()
    java.lang.String status, boolean isAvailable, @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.api.Location location, @org.jetbrains.annotations.NotNull()
    java.lang.String soilType, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> waterSource, boolean irrigation, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> cropTypes, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> cropsCultivated, @org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, @org.jetbrains.annotations.Nullable()
    java.util.List<com.simats.harvesthaven.api.Image> images, @org.jetbrains.annotations.Nullable()
    java.util.List<com.simats.harvesthaven.api.Document> documents, @org.jetbrains.annotations.Nullable()
    java.lang.String healthCard, @org.jetbrains.annotations.Nullable()
    java.lang.String previousUse, @org.jetbrains.annotations.Nullable()
    java.util.List<com.simats.harvesthaven.models.YearlyProfit> previousProfits, @org.jetbrains.annotations.Nullable()
    java.util.List<com.simats.harvesthaven.models.YearlyYield> yieldHistory, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> amenities, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> restrictions, @org.jetbrains.annotations.NotNull()
    java.lang.String createdAt, @org.jetbrains.annotations.NotNull()
    java.lang.String updatedAt, boolean isVerified, boolean isActive, int views) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOwner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOwnerName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOwnerContact() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLandTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLandType() {
        return null;
    }
    
    public final double getArea() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAreaUnit() {
        return null;
    }
    
    public final double getPrice() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final boolean isAvailable() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.simats.harvesthaven.api.Location getLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSoilType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getWaterSource() {
        return null;
    }
    
    public final boolean getIrrigation() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getCropTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getCropsCultivated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.simats.harvesthaven.api.Image> getImages() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.simats.harvesthaven.api.Document> getDocuments() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHealthCard() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPreviousUse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.simats.harvesthaven.models.YearlyProfit> getPreviousProfits() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.simats.harvesthaven.models.YearlyYield> getYieldHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getAmenities() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getRestrictions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdatedAt() {
        return null;
    }
    
    public final boolean isVerified() {
        return false;
    }
    
    public final boolean isActive() {
        return false;
    }
    
    public final int getViews() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    public final double component11() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    public final boolean component13() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.simats.harvesthaven.api.Location component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component16() {
        return null;
    }
    
    public final boolean component17() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.simats.harvesthaven.api.Image> component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.simats.harvesthaven.api.Document> component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.simats.harvesthaven.models.YearlyProfit> component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.simats.harvesthaven.models.YearlyYield> component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component30() {
        return null;
    }
    
    public final boolean component31() {
        return false;
    }
    
    public final boolean component32() {
        return false;
    }
    
    public final int component33() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.simats.harvesthaven.models.LandPost copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String owner, @org.jetbrains.annotations.NotNull()
    java.lang.String ownerName, @org.jetbrains.annotations.NotNull()
    java.lang.String ownerContact, @org.jetbrains.annotations.NotNull()
    java.lang.String landTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String landType, double area, @org.jetbrains.annotations.NotNull()
    java.lang.String areaUnit, double price, @org.jetbrains.annotations.NotNull()
    java.lang.String status, boolean isAvailable, @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.api.Location location, @org.jetbrains.annotations.NotNull()
    java.lang.String soilType, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> waterSource, boolean irrigation, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> cropTypes, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> cropsCultivated, @org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, @org.jetbrains.annotations.Nullable()
    java.util.List<com.simats.harvesthaven.api.Image> images, @org.jetbrains.annotations.Nullable()
    java.util.List<com.simats.harvesthaven.api.Document> documents, @org.jetbrains.annotations.Nullable()
    java.lang.String healthCard, @org.jetbrains.annotations.Nullable()
    java.lang.String previousUse, @org.jetbrains.annotations.Nullable()
    java.util.List<com.simats.harvesthaven.models.YearlyProfit> previousProfits, @org.jetbrains.annotations.Nullable()
    java.util.List<com.simats.harvesthaven.models.YearlyYield> yieldHistory, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> amenities, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> restrictions, @org.jetbrains.annotations.NotNull()
    java.lang.String createdAt, @org.jetbrains.annotations.NotNull()
    java.lang.String updatedAt, boolean isVerified, boolean isActive, int views) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}