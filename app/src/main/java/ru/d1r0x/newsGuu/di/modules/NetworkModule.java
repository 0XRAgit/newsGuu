package ru.d1r0x.newsGuu.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.d1r0x.newsGuu.BuildConfig;
import ru.d1r0x.newsGuu.data.network.NetworkApi;
import ru.d1r0x.newsGuu.utils.Constants;

@Module
public class NetworkModule {

    @Provides
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    }

    @Provides
    public OkHttpClient provideHttpClient(HttpLoggingInterceptor loggingInterceptor) {

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .followRedirects(true)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    public Gson provideGson() {
        return new GsonBuilder().setLenient().create();
    }

    @Provides
    public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl(Constants.NETWORK_BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(client)
                .build();
    }

    @Provides
    public NetworkApi provideNetworkApi(Retrofit retrofit) {
        return retrofit.create(NetworkApi.class);
    }
}
