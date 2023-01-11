package ru.d1r0x.newsGuu.ui.main.dialog;

import static ru.d1r0x.newsGuu.utils.Constants.SEARCH_LANGUAGE_ENGLISH;
import static ru.d1r0x.newsGuu.utils.Constants.SEARCH_LANGUAGE_RUSSIAN;
import static ru.d1r0x.newsGuu.utils.Constants.SEARCH_SORT_BY_POPULARITY;
import static ru.d1r0x.newsGuu.utils.Constants.SEARCH_SORT_BY_PUBLISHED_AT;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import ru.d1r0x.newsGuu.data.Prefs;
import ru.d1r0x.newsGuu.databinding.DialogFilterBinding;
import ru.d1r0x.newsGuu.ui.main.MainContract;
import ru.d1r0x.newsGuu.ui.main.MainFragment;

public class FilterDialog extends BottomSheetDialogFragment {

    DialogFilterBinding binding;
    private final MainContract.View contract;
    private Prefs prefs;

    public FilterDialog(MainContract.View contract){
        this.contract = contract;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogFilterBinding.inflate(inflater, container, false);
        prefs = new Prefs(requireContext());

        initRadio();

        return binding.getRoot();
    }

    private void initRadio(){
        binding.radioEnglish.setChecked(prefs.getLanguage().equals(SEARCH_LANGUAGE_ENGLISH));
        binding.radioRussian.setChecked(prefs.getLanguage().equals(SEARCH_LANGUAGE_RUSSIAN));

        binding.radioPublishedAt.setChecked(prefs.getSortBy().equals(SEARCH_SORT_BY_PUBLISHED_AT));
        binding.radioPopularity.setChecked(prefs.getSortBy().equals(SEARCH_SORT_BY_POPULARITY));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        prefs.setLanguage(binding.radioEnglish.isChecked()?SEARCH_LANGUAGE_ENGLISH:SEARCH_LANGUAGE_RUSSIAN);
        prefs.setSortBy(binding.radioPublishedAt.isChecked()?SEARCH_SORT_BY_PUBLISHED_AT:SEARCH_SORT_BY_POPULARITY);

        contract.updateNews();
    }
}
