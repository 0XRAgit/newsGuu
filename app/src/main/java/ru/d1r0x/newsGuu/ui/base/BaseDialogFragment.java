package ru.d1r0x.newsGuu.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

public abstract class BaseDialogFragment extends BaseBottomSheetDialogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        attachView();
    }

    protected abstract void inject();

    protected abstract void attachView();

    protected abstract void detachPresenter();

    @Override
    public void onDestroy() {
        detachPresenter();
        super.onDestroy();
    }
}
