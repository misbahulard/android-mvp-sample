package com.herballife.main.listpenyakit;

import android.content.Context;

import com.herballife.main.model.CatalogModel;

/**
 * Created by Misbahul Ardani on 5/21/2018.
 */

public class ListPenyakitPresenter implements ListPenyakitContract.Presenter {
    private ListPenyakitContract.View mView;
    private CatalogModel mCatalogModel;

    public ListPenyakitPresenter(ListPenyakitContract.View mView, Context context) {
        this.mView = mView;
        mCatalogModel = new CatalogModel(context);
    }

    @Override
    public void getPenyakit() {
        mView.showPenyakit(mCatalogModel.getPenyakitNames());
    }
}
