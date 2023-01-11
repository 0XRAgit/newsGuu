package ru.d1r0x.newsGuu.ui.main;

import ru.d1r0x.newsGuu.data.models.news.NewsRes;
import ru.d1r0x.newsGuu.ui.base.BaseView;

public class MainContract {

    public interface View extends BaseView {
        void successNewsUpdate(NewsRes newsRes);
        void updateNews();
    }

    interface Presenter extends ru.d1r0x.newsGuu.ui.base.Presenter<View> {
        void getNews(String searchText);
    }
}
