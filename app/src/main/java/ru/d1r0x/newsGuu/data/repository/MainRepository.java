package  ru.d1r0x.newsGuu.data.repository;

import static ru.d1r0x.newsGuu.utils.Constants.API_KEY;
import static ru.d1r0x.newsGuu.utils.Constants.DEFAULT_SEARCH;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import  ru.d1r0x.newsGuu.data.Prefs;
import ru.d1r0x.newsGuu.data.models.news.NewsRes;
import  ru.d1r0x.newsGuu.data.network.NetworkApi;

public class MainRepository {

    private final Prefs prefs;
    private final NetworkApi api;

    public MainRepository(NetworkApi api, Prefs prefs){
        this.prefs = prefs;
        this.api = api;
    }

    public Single<NewsRes> getNews(String searchText){
        if(searchText.isEmpty())
            searchText=DEFAULT_SEARCH;

        return api.getEveryNews(prefs.getLanguage(),prefs.getSortBy(),searchText, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
