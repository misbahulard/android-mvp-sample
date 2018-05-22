package com.herballife.main.caripenyakit;

/**
 * Created by Misbahul Ardani on 5/22/2018.
 */

public interface CariPenyakitContract {
    interface View {
        void showSaranPenyakit(String[] saran);
    }

    interface Presenter {
        void getSaranPenyakit();
    }
}
