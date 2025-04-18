package com.simats.harvesthaven.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u001aH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u001aH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u001fH\u00a7@\u00a2\u0006\u0002\u0010 J(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\"J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010\u0014\u001a\u00020%H\u00a7@\u00a2\u0006\u0002\u0010&\u00a8\u0006\'"}, d2 = {"Lcom/simats/harvesthaven/api/ApiService;", "", "addLand", "Lretrofit2/Response;", "Lcom/simats/harvesthaven/api/Land;", "land", "(Lcom/simats/harvesthaven/api/Land;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLand", "", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLands", "", "Lcom/simats/harvesthaven/models/LandPost;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLandById", "getLandListings", "login", "Lcom/simats/harvesthaven/api/LoginResponse;", "request", "Lcom/simats/harvesthaven/api/LoginRequest;", "(Lcom/simats/harvesthaven/api/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ownerLogin", "register", "Lcom/simats/harvesthaven/api/RegisterResponse;", "Lcom/simats/harvesthaven/api/RegisterRequest;", "(Lcom/simats/harvesthaven/api/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerOwner", "sendOtp", "Lcom/simats/harvesthaven/api/SendOtpResponse;", "Lcom/simats/harvesthaven/api/SendOtpRequest;", "(Lcom/simats/harvesthaven/api/SendOtpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLand", "(Ljava/lang/String;Lcom/simats/harvesthaven/api/Land;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyOtp", "Lcom/simats/harvesthaven/api/VerifyOtpResponse;", "Lcom/simats/harvesthaven/api/VerifyOtpRequest;", "(Lcom/simats/harvesthaven/api/VerifyOtpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "api/users/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.api.LoginRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.api.LoginResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/owners/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object ownerLogin(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.api.LoginRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.api.LoginResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/users/register")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object register(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.api.RegisterRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.api.RegisterResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/owners/register")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerOwner(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.api.RegisterRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.api.RegisterResponse>> $completion);
    
    @retrofit2.http.POST(value = "auth/sendotp")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendOtp(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.api.SendOtpRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.api.SendOtpResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/lands")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLandListings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.simats.harvesthaven.api.Land>>> $completion);
    
    @retrofit2.http.GET(value = "api/lands/all")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllLands(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.simats.harvesthaven.models.LandPost>>> $completion);
    
    @retrofit2.http.GET(value = "api/lands/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLandById(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.api.Land>> $completion);
    
    @retrofit2.http.POST(value = "api/lands")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addLand(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.api.Land land, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.api.Land>> $completion);
    
    @retrofit2.http.PUT(value = "api/lands/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateLand(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.api.Land land, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.api.Land>> $completion);
    
    @retrofit2.http.DELETE(value = "api/lands/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteLand(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "auth/verifyotp")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object verifyOtp(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.simats.harvesthaven.api.VerifyOtpRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.simats.harvesthaven.api.VerifyOtpResponse>> $completion);
}