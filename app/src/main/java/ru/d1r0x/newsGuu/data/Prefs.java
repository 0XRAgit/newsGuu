package ru.d1r0x.newsGuu.data;

import static ru.d1r0x.newsGuu.utils.Constants.BUNDLE_LANGUAGE;
import static ru.d1r0x.newsGuu.utils.Constants.BUNDLE_SORT_BY;
import static ru.d1r0x.newsGuu.utils.Constants.DEFAULT_LANGUAGE;
import static ru.d1r0x.newsGuu.utils.Constants.DEFAULT_SORT_BY;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Prefs {

    private final SharedPreferences sp;

    public Prefs(Context context) {
        sp = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getLanguage(){
        return sp.getString(BUNDLE_LANGUAGE, DEFAULT_LANGUAGE);
    }

    public void setLanguage(String language){
        sp.edit().putString(BUNDLE_LANGUAGE, language).apply();
    }

    public String getSortBy(){
        return sp.getString(BUNDLE_SORT_BY, DEFAULT_SORT_BY);
    }

    public void setSortBy(String sortBy){
        sp.edit().putString(BUNDLE_SORT_BY, sortBy).apply();
    }
}
