package com.herballife.main.detailcatalog;

import android.content.Context;

import com.herballife.main.model.CatalogModel;

/**
 * Created by Misbahul Ardani on 5/21/2018.
 */

public class DetailCatalogPresenter implements DetailCatalogContract.Presenter {

    private DetailCatalogContract.View mView;
    private CatalogModel mCatalogModel;

    public DetailCatalogPresenter(DetailCatalogContract.View mView, Context context) {
        this.mView = mView;
        mCatalogModel = new CatalogModel(context);
    }

    public void getTumbuhan(String q) {
        mView.showDetailKatalog(mCatalogModel.getTumbuhan(q));
    }
}
