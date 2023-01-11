package ru.d1r0x.newsGuu.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Prefs {

    private final SharedPreferences sp;

    public Prefs(Context context) {
        sp = PreferenceManager.getDefaultSharedPreferences(context);
    }


}
