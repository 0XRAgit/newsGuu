package ru.d1r0x.newsGuu.data.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.d1r0x.newsGuu.data.models.news.NewsRes;

public interface NetworkApi {

    @GET("everything")
    Single<NewsRes> getEveryNews(@Query("language") String language, @Query("sortBy") String sortBy, @Query("q") String searchText, @Query("apiKey") String apiKey);
}
