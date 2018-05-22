package com.herballife.main.listpenyakit;

import java.util.ArrayList;

/**
 * Created by Misbahul Ardani on 5/21/2018.
 */

public interface ListPenyakitContract {
    interface View {
        void showPenyakit(ArrayList<String> penyakitNames);
    }

    interface Presenter {
        void getPenyakit();
    }
}
