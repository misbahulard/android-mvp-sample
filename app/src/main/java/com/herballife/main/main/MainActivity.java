package com.herballife.main.main;


import android.app.Activity;
import android.app.AlertDialog;

import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.herballife.main.listpenyakit.List;
import com.herballife.main.listcatalog.List_catalog;
import com.herballife.main.R;

public class MainActivity extends Activity implements MainContract.View {

    private MainContract.Presenter mPresenter;
    private ImageView mSearchButton, mCatalogButton, mHelpButton, mExitButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);

        mSearchButton = (ImageView) findViewById(R.id.btn_search);
        mCatalogButton = (ImageView) findViewById(R.id.btn_catalog);
        mHelpButton = (ImageView) findViewById(R.id.btn_help);
        mExitButton = (ImageView) findViewById(R.id.btn_exit);

        mSearchButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_search = new Intent(MainActivity.this, List.class);
                startActivity(btn_search);
            }
        });

        mCatalogButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn_catalog = new Intent(MainActivity.this, List_catalog.class);
                startActivity(btn_catalog);
            }
        });

        mHelpButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getHelp();
            }
        });

        mExitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                builder2.setMessage("Apakah anda benar-benar ingin keluar?")
                        .setCancelable(false)
                        .setPositiveButton("Tidak", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Ya", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }
                        });
                AlertDialog judul2 = builder2.create();
                judul2.setIcon(R.drawable.exit);
                judul2.setTitle("Exit");
                judul2.show();
            }
        });
    }

    @Override
    public void showHelp(String helpText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(helpText)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog judul = builder.create();
        judul.setIcon(R.drawable.help);
        judul.setTitle("Help");
        judul.show();
    }
}