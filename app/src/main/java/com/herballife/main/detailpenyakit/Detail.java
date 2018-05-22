package com.herballife.main.detailpenyakit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.herballife.main.R;
import com.herballife.main.listcatalog.List_catalog;
import com.herballife.main.model.Penyakit;

public class Detail extends Activity implements DetailPenyakitContract.View {
    private DetailPenyakitPresenter mDetailPenyakitPresenter;
    private TextView nama;
    private TextView bahan;
    private TextView tutor;
    private Button button;
    private String cek;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_penyakit);
        Intent qwe = getIntent();
        cek = qwe.getStringExtra("kirim_penyakit");

        nama = (TextView) findViewById(R.id.daftar_penyakit);
        bahan = (TextView) findViewById(R.id.bahan);
        button = (Button) findViewById(R.id.button1);
        tutor = (TextView) findViewById(R.id.tutorial);

        mDetailPenyakitPresenter = new DetailPenyakitPresenter(this, Detail.this);
        mDetailPenyakitPresenter.getPenyakit(cek);
    }

    @Override
    public void showDetailPenyakit(Penyakit penyakit) {
        nama.setText(penyakit.getNama());
        bahan.setText("Bahan : " + penyakit.getBahanObat());
        tutor.setText("Cara Menggunakan : " + penyakit.getTutorial());
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tombol = new Intent(Detail.this, List_catalog.class);
                startActivity(tombol);
            }
        });
    }
}
