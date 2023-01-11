package ru.d1r0x.newsGuu.ui.main;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import ru.d1r0x.newsGuu.data.models.news.NewsRes;
import ru.d1r0x.newsGuu.data.repository.MainRepository;
import ru.d1r0x.newsGuu.data.repository.TestRepository;
import ru.d1r0x.newsGuu.ui.base.BasePresenter;
import ru.d1r0x.newsGuu.ui.test.TestContract;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    public MainRepository mainRepository;

    @Inject
    public MainPresenter(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @Override
    public void getNews(String searchText) {
        mainRepository.getNews(searchText).subscribe(new SingleObserver<NewsRes>() {
            @Override
            public void onSubscribe(Disposable d) {}

            @Override
            public void onSuccess(NewsRes newsRes) {
                getView().successNewsUpdate(newsRes);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("getNews",e.toString());
            }
        });
    }
}
