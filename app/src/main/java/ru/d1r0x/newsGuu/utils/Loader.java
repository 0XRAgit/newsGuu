package ru.d1r0x.newsGuu.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.ProgressBar;

import ru.d1r0x.newsGuu.R;

public class Loader {

    private static volatile Loader instance;
    private Context context;

    public static Loader createInstance(Context context) {

        Loader localInstance = instance;
        if (localInstance == null) {
            synchronized (Loader.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Loader();
                }
            }
        }
        instance.context = context;

        return localInstance;
    }

    protected Dialog dialog = null;

    public void onLoader(boolean b){
        if (b == true){
            if (dialog == null) {
                try {
                    dialog = new Dialog(context);
                    dialog.setContentView(R.layout.loader);
                    dialog.setCanceledOnTouchOutside(false);
                    ProgressBar progressBar = dialog.findViewById(R.id.progressBar);
                    dialog.show();
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.transparent)));
                } catch (Exception e) {

                }
            } else if (dialog != null){
                return;
            }

        } else if (b == false){
            if (dialog == null) {
                return;
            } else if (dialog != null){
                dialog.dismiss();
                dialog = null;
            }
        }
    }

}
