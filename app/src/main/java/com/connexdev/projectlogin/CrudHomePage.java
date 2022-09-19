package com.connexdev.projectlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CrudHomePage extends AppCompatActivity {
    Button tombolsiswas,tombolgurus,tombolkelass,tombolnilais,tombolmapels,tombolbantuans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepages);
        getSupportActionBar().hide();

        tombolsiswas = (Button) findViewById(R.id.tombolsiswa);
        tombolgurus = (Button) findViewById(R.id.tombolguru);
        tombolkelass = (Button) findViewById(R.id.tombolnilai);
        tombolnilais = (Button) findViewById(R.id.tombolmapel);
        tombolmapels = (Button) findViewById(R.id.tombolmapel);
        tombolbantuans = (Button) findViewById(R.id.bantuan);



        tombolsiswas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrudHomePage.this, TambahSiswa.class);
                CrudHomePage.this.startActivity(intent);
                finish();
            }
        });

        tombolgurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrudHomePage.this, TambahGuru.class);
                CrudHomePage.this.startActivity(intent);
                finish();
            }
        });

        tombolkelass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrudHomePage.this, TambahKelas.class);
                CrudHomePage.this.startActivity(intent);
                finish();
            }
        });

        tombolnilais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrudHomePage.this, TambahNilai.class);
                CrudHomePage.this.startActivity(intent);
                finish();
            }
        });

        tombolmapels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrudHomePage.this, TambahMapel.class);
                CrudHomePage.this.startActivity(intent);
                finish();
            }
        });

       tombolbantuans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrudHomePage.this, Bantuan.class);
                CrudHomePage.this.startActivity(intent);
                finish();


            }
        });
    }
}