package ru.d1r0x.newsGuu.ui.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ru.d1r0x.newsGuu.databinding.FragmentTestBinding;
import ru.d1r0x.newsGuu.App;
import ru.d1r0x.newsGuu.ui.base.BaseFragment;

public class TestFragment extends BaseFragment implements TestContract.View {

    FragmentTestBinding binding;

    @Inject
    TestPresenter testPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTestBinding.inflate(inflater, container, false);

        setViewClickListeners();

        return binding.getRoot();
    }

    private void setViewClickListeners() {
        binding.btn.setOnClickListener(v -> {
            testPresenter.getTestItems();
        });
    }

    @Override
    public void inject() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void attachView() {
        testPresenter.attachView(this);
    }

    @Override
    protected void detachPresenter() {
        testPresenter.detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void testItemResult(Object test) {

    }
}
