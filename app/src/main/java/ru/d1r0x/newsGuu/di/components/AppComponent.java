package ru.d1r0x.newsGuu.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.d1r0x.newsGuu.di.modules.NetworkModule;
import ru.d1r0x.newsGuu.di.modules.RepositoryModule;
import ru.d1r0x.newsGuu.ui.test.TestFragment;

@Singleton
@Component(modules = {RepositoryModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(TestFragment testFragment);
}