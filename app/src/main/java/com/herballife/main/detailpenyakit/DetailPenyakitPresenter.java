package com.herballife.main.detailpenyakit;

import android.content.Context;

import com.herballife.main.model.CatalogModel;

/**
 * Created by Misbahul Ardani on 5/22/2018.
 */

public class DetailPenyakitPresenter implements DetailPenyakitContract.Presenter {
    private DetailPenyakitContract.View mView;
    private CatalogModel mCatalogModel;

    public DetailPenyakitPresenter(DetailPenyakitContract.View mView, Context context) {
        this.mView = mView;
        mCatalogModel = new CatalogModel(context);
    }

    @Override
    public void getPenyakit(String q) {
        mView.showDetailPenyakit(mCatalogModel.getPenyakit(q));
    }
}
