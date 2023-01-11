package ru.d1r0x.newsGuu.ui.test;

import ru.d1r0x.newsGuu.ui.base.BaseView;

public class TestContract {

    public interface View extends BaseView {
        void testItemResult(Object test);
    }

    interface Presenter extends ru.d1r0x.newsGuu.ui.base.Presenter<View> {
        void getTestItems();
    }
}
