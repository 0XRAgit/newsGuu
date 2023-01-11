package ru.d1r0x.newsGuu.ui.base;

import javax.inject.Inject;

public class MvpFragment<P> extends BaseFragment {

    @Inject
    public P presenter;

    @Override
    protected void inject() {

    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void detachPresenter() {

    }
}
