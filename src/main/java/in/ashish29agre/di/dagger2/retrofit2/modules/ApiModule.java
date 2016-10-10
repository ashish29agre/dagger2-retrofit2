/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ashish29agre.di.dagger2.retrofit2.modules;

import dagger.Module;
import dagger.Provides;
import in.ashish29agre.di.dagger2.retrofit2.Api;
import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Singleton;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Ashish
 */
@Module
public class ApiModule {

    private static final Logger logger = Logger.getLogger(ApiModule.class.getSimpleName());

    private final String baseUrl;

    public ApiModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    boolean provideIsLoggerEnabled() {
        logger.info("proviedIsLoggerEnabled()");
        return true;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(boolean logEnabled) {
        logger.info(" provideOkHttpClient(logEnabled)");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        Interceptor requestInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request());
            }
        };
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addNetworkInterceptor(interceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    Api provideApi(OkHttpClient okHttpClient) {
        logger.info("provideApi");
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Api.class);
    }

}
