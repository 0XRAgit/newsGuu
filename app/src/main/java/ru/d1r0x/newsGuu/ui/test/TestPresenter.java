package ru.d1r0x.newsGuu.ui.test;

import javax.inject.Inject;

import ru.d1r0x.newsGuu.data.repository.MainRepository;
import ru.d1r0x.newsGuu.data.repository.TestRepository;
import ru.d1r0x.newsGuu.ui.base.BasePresenter;

public class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presenter {

    public TestRepository testRepository;
    public MainRepository mainRepository;

    @Inject
    public TestPresenter(TestRepository testRepository, MainRepository mainRepository) {
        this.testRepository = testRepository;
        this.mainRepository = mainRepository;
    }

    @Override
    public void attachView(TestContract.View view) {
        super.attachView(view);
    }

    @Override
    public void getTestItems() {
        checkViewAttached();
    }
}
