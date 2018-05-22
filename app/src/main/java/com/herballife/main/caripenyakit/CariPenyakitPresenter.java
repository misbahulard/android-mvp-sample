package com.herballife.main.caripenyakit;

import com.herballife.main.model.StaticData;

/**
 * Created by Misbahul Ardani on 5/22/2018.
 */

public class CariPenyakitPresenter implements CariPenyakitContract.Presenter {

    private CariPenyakitContract.View mView;
    private StaticData mStaticData;

    public CariPenyakitPresenter(CariPenyakitContract.View mView) {
        this.mView = mView;
        mStaticData = new StaticData();
    }

    @Override
    public void getSaranPenyakit() {
        mView.showSaranPenyakit(mStaticData.getSaran());
    }
}
