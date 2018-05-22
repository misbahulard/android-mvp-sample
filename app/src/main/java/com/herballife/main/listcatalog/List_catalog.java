package com.herballife.main.listcatalog;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.herballife.main.detailcatalog.Detail_katalog;
import com.herballife.main.R;

import java.util.ArrayList;

public class List_catalog extends Activity implements ListCatalogContract.View {
    public ListView list;
    int checked = -1;
    ArrayAdapter<String> adapter;
    private ListCatalogPresenter mListCatalogPresenter;

    @Override
    public void showCatalog(final ArrayList<String> catalogNames) {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catalogNames);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                checked = arg2;
                String tumbuhan = catalogNames.get(checked);

                Intent tambah = new Intent(List_catalog.this, Detail_katalog.class);
                tambah.putExtra("kirim_tumbuhan", tumbuhan);
                startActivity(tambah);
            }
        });
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_katalog);

        list = (ListView) findViewById(R.id.list_tumbuhan);

        mListCatalogPresenter = new ListCatalogPresenter(this, List_catalog.this);
        mListCatalogPresenter.getCatalog();
    }

}