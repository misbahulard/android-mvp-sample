package com.herballife.main.listpenyakit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.herballife.main.caripenyakit.Cari_Penyakit;
import com.herballife.main.detailpenyakit.Detail;
import com.herballife.main.R;

import java.util.ArrayList;

public class List extends Activity implements ListPenyakitContract.View {
    public ListView list;
    Button button;
    int checked = -1;
    private ArrayAdapter<String> adapter;
    private ListPenyakitPresenter mListPenyakitPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        list = (ListView) findViewById(R.id.listpenyakit);

        button = (Button) findViewById(R.id.tombol_cari);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tombol = new Intent(List.this, Cari_Penyakit.class);
                startActivity(tombol);
            }
        });

        mListPenyakitPresenter = new ListPenyakitPresenter(this, List.this);
        mListPenyakitPresenter.getPenyakit();
    }

    @Override
    public void showPenyakit(final ArrayList<String> penyakitNames) {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, penyakitNames);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                checked = arg2;
                String penyakit = penyakitNames.get(checked);

                Intent tambah = new Intent(List.this, Detail.class);
                tambah.putExtra("kirim_penyakit", penyakit);
                startActivity(tambah);
            }
        });
    }
}
