package com.herballife.main.listcatalog;

import java.util.ArrayList;

/**
 * Created by Misbahul Ardani on 5/21/2018.
 */

public interface ListCatalogContract {
    interface View {
        void showCatalog(ArrayList<String> catalogNames);
    }

    interface Presenter {
        void getCatalog();
    }
}
