package com.herballife.main.detailcatalog;

import com.herballife.main.model.Tumbuhan;

/**
 * Created by Misbahul Ardani on 5/21/2018.
 */

public interface DetailCatalogContract {
    interface View {
        void showDetailKatalog(Tumbuhan tumbuhan);
    }

    interface Presenter {
        void getTumbuhan(String q);
    }
}
