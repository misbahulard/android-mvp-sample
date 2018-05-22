package com.herballife.main.main;

import com.herballife.main.model.StaticData;

/**
 * Created by Misbahul Ardani on 5/21/2018.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;
    private StaticData mStaticData;

    public MainPresenter(MainContract.View mMainView) {
        this.mMainView = mMainView;
        mStaticData = new StaticData();
    }

    @Override
    public void getHelp() {
        mMainView.showHelp(mStaticData.getHelp());
    }
}
