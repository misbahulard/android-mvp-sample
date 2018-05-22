package com.herballife.main.detailpenyakit;

import com.herballife.main.model.Penyakit;

/**
 * Created by Misbahul Ardani on 5/22/2018.
 */

public interface DetailPenyakitContract {
    interface View {
        void showDetailPenyakit(Penyakit penyakit);
    }

    interface Presenter {
        void getPenyakit(String q);
    }
}
