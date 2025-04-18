package com.simats.harvesthaven.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/simats/harvesthaven/api/RetrofitClient;", "", "()V", "BASE_URL", "", "getBASE_URL", "()Ljava/lang/String;", "PORT", "apiService", "Lcom/simats/harvesthaven/api/ApiService;", "getApiService", "()Lcom/simats/harvesthaven/api/ApiService;", "apiService$delegate", "Lkotlin/Lazy;", "landService", "Lcom/simats/harvesthaven/api/LandService;", "getLandService", "()Lcom/simats/harvesthaven/api/LandService;", "landService$delegate", "loggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "networkInterceptor", "Lokhttp3/Interceptor;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit$delegate", "getSecureOkHttpClient", "Lokhttp3/OkHttpClient;", "app_debug"})
public final class RetrofitClient {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PORT = "5000";
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.Interceptor networkInterceptor = null;
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.logging.HttpLoggingInterceptor loggingInterceptor = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy retrofit$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy landService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy apiService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.simats.harvesthaven.api.RetrofitClient INSTANCE = null;
    
    private RetrofitClient() {
        super();
    }
    
    private final java.lang.String getBASE_URL() {
        return null;
    }
    
    private final okhttp3.OkHttpClient getSecureOkHttpClient() {
        return null;
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.simats.harvesthaven.api.LandService getLandService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.simats.harvesthaven.api.ApiService getApiService() {
        return null;
    }
}