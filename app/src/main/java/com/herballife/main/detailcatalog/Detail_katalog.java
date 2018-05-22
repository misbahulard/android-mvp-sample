package com.herballife.main.detailcatalog;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.herballife.main.R;
import com.herballife.main.model.Tumbuhan;
import com.herballife.main.util.SQLiteDBHelper;

public class Detail_katalog extends Activity implements DetailCatalogContract.View {
    private DetailCatalogPresenter mDetailCatalogPresenter;
    private TextView nama;
    private TextView guna;
    private ImageView gambar;
    private String cek;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_katalog);

        mDetailCatalogPresenter = new DetailCatalogPresenter(this, Detail_katalog.this);

        Intent qwe = getIntent();
        cek = qwe.getStringExtra("kirim_tumbuhan");

        nama = (TextView) findViewById(R.id.nama_tumbuhan);
        guna = (TextView) findViewById(R.id.kegunaan);
        gambar = (ImageView) findViewById(R.id.gambar);

        mDetailCatalogPresenter.getTumbuhan(cek);
    }

    @Override
    public void showDetailKatalog(Tumbuhan tumbuhan) {
        nama.setText(tumbuhan.getNama());
        guna.setText(tumbuhan.getKegunaan());
        Bitmap image = BitmapFactory.decodeByteArray(tumbuhan.getGambar(), 0, tumbuhan.getGambar().length);
        gambar.setImageBitmap(image);
    }
}