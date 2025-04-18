package com.simats.harvesthaven.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ$\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJz\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r0\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\nH\u00a7@\u00a2\u0006\u0002\u0010\u001cJ(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lcom/simats/harvesthaven/api/LandService;", "", "createLandPost", "Lretrofit2/Response;", "Lcom/simats/harvesthaven/models/LandPost;", "landPost", "(Lcom/simats/harvesthaven/models/LandPost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLandPost", "", "landId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLands", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLandById", "getLandsByOwnerId", "ownerId", "searchLands", "location", "minPrice", "", "maxPrice", "minArea", "maxArea", "soilType", "waterSource", "cropType", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLandPost", "(Ljava/lang/String;Lcom/simats/harvesthaven/models/LandPost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface LandService {
    
    @retrofit2.http.GET(value = "api/lands")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllLands(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.simats.harvesthaven.models.LandPost>>> $completion);
    
    @retrofit2.http.GET(value = "api/lands/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLandById(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String landId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.models.LandPost>> $completion);
    
    @retrofit2.http.GET(value = "api/lands/owner/{ownerId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLandsByOwnerId(@retrofit2.http.Path(value = "ownerId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String ownerId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.simats.harvesthaven.models.LandPost>>> $completion);
    
    @retrofit2.http.POST(value = "api/lands")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createLandPost(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.models.LandPost landPost, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.models.LandPost>> $completion);
    
    @retrofit2.http.PUT(value = "api/lands/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateLandPost(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String landId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.models.LandPost landPost, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.models.LandPost>> $completion);
    
    @retrofit2.http.DELETE(value = "api/lands/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteLandPost(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String landId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "api/lands/search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchLands(@retrofit2.http.Query(value = "location")
    @org.jetbrains.annotations.Nullable()
    java.lang.String location, @retrofit2.http.Query(value = "minPrice")
    @org.jetbrains.annotations.Nullable()
    java.lang.Double minPrice, @retrofit2.http.Query(value = "maxPrice")
    @org.jetbrains.annotations.Nullable()
    java.lang.Double maxPrice, @retrofit2.http.Query(value = "minArea")
    @org.jetbrains.annotations.Nullable()
    java.lang.Double minArea, @retrofit2.http.Query(value = "maxArea")
    @org.jetbrains.annotations.Nullable()
    java.lang.Double maxArea, @retrofit2.http.Query(value = "soilType")
    @org.jetbrains.annotations.Nullable()
    java.lang.String soilType, @retrofit2.http.Query(value = "waterSource")
    @org.jetbrains.annotations.Nullable()
    java.lang.String waterSource, @retrofit2.http.Query(value = "cropType")
    @org.jetbrains.annotations.Nullable()
    java.lang.String cropType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.simats.harvesthaven.models.LandPost>>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}