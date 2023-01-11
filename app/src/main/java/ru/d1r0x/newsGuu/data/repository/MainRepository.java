package  ru.d1r0x.newsGuu.data.repository;

import  ru.d1r0x.newsGuu.data.Prefs;
import  ru.d1r0x.newsGuu.data.network.NetworkApi;

public class MainRepository {

    private final Prefs prefs;
    private final NetworkApi api;

    public MainRepository(NetworkApi api, Prefs prefs){
        this.prefs = prefs;
        this.api = api;
    }

}
