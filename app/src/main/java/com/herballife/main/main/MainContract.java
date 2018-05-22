package com.herballife.main.main;

/**
 * Created by Misbahul Ardani on 5/21/2018.
 */

public interface MainContract {

    interface View {
        void showHelp(String s);
    }

    interface Presenter {
        void getHelp();
    }

}
