package ru.d1r0x.newsGuu;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import ru.d1r0x.newsGuu.di.components.AppComponent;
import ru.d1r0x.newsGuu.di.components.DaggerAppComponent;
import ru.d1r0x.newsGuu.di.modules.RepositoryModule;

public class App extends Application {

    private static Context appContext;
    private static DisplayMetrics displayMetrics;

    public static App instance;

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();

        displayMetrics = appContext.getResources().getDisplayMetrics();

        instance = this;

        appComponent = DaggerAppComponent.builder()
                .repositoryModule(new RepositoryModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static App getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static DisplayMetrics getDisplayMetrics() {
        return displayMetrics;
    }
}
