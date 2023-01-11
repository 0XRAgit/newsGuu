package ru.d1r0x.newsGuu.ui.main;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import ru.d1r0x.newsGuu.App;
import ru.d1r0x.newsGuu.R;
import ru.d1r0x.newsGuu.data.models.news.NewsRes;
import ru.d1r0x.newsGuu.databinding.FragmentMainBinding;
import ru.d1r0x.newsGuu.ui.base.BaseFragment;
import ru.d1r0x.newsGuu.ui.main.adapters.NewsAdapter;
import ru.d1r0x.newsGuu.ui.main.dialog.FilterDialog;
import ru.d1r0x.newsGuu.utils.Loader;

public class MainFragment extends BaseFragment implements MainContract.View {

    private FragmentMainBinding binding;

    @Inject
    MainPresenter mainPresenter;
    private Loader loader;
    private FilterDialog filterDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);

        loader = Loader.createInstance(requireContext());

        setViewClickListeners();

        updateNews();

        filterDialog = new FilterDialog(this);

        return binding.getRoot();
    }

    private void setViewClickListeners() {
        binding.editSearch.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus)
                updateNews();
        });

        binding.buttonFilter.setOnClickListener(v-> filterDialog.show(getParentFragmentManager(), FilterDialog.class.getName()));

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
        mainPresenter.attachView(this);
    }

    @Override
    protected void detachPresenter() {
        mainPresenter.detachView();
    }

    @Override
    public void successNewsUpdate(NewsRes newsRes) {
        NewsAdapter newsAdapter = new NewsAdapter(newsRes.getArticles());
        binding.recyclerNews.setAdapter(newsAdapter);
        loader.onLoader(false);

        if(newsRes.getArticles().length==0)
            Toast.makeText(requireContext(),getString(R.string.for_toast_no_result),Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateNews() {
        mainPresenter.getNews(binding.editSearch.getText().toString());
        loader.onLoader(true);
    }
}
