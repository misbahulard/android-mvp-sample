package com.herballife.main.listcatalog;

import android.content.Context;

import com.herballife.main.model.CatalogModel;

/**
 * Created by Misbahul Ardani on 5/21/2018.
 */

public class ListCatalogPresenter implements ListCatalogContract.Presenter {

    private ListCatalogContract.View mView;
    private CatalogModel mCatalogModel;

    public ListCatalogPresenter(ListCatalogContract.View mView, Context context) {
        this.mView = mView;
        mCatalogModel = new CatalogModel(context);
    }

    public void getCatalog() {
        mView.showCatalog(mCatalogModel.getCatalogNames());
    }
}
