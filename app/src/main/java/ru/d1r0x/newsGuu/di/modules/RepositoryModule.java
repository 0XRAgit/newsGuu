package ru.d1r0x.newsGuu.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.d1r0x.newsGuu.data.Prefs;
import ru.d1r0x.newsGuu.data.network.NetworkApi;
import ru.d1r0x.newsGuu.data.repository.MainRepository;
import ru.d1r0x.newsGuu.data.repository.TestRepository;

@Module
public class RepositoryModule {

    private final Context context;

    public RepositoryModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    public Prefs providePrefs(){
        return new Prefs(context);
    }

    @Singleton
    @Provides
    public TestRepository provideTestRepository() {
        return new TestRepository(providePrefs());
    }

    @Singleton
    @Provides
    public MainRepository provideAuthRepository(NetworkApi api) {
        return new MainRepository(api, providePrefs());
    }

}
