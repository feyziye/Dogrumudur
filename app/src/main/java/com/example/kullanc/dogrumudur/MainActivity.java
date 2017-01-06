package com.example.kullanc.dogrumudur;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton tarih = (ImageButton) findViewById(R.id.tarih);
        ImageButton cografya = (ImageButton) findViewById(R.id.cografya);
        ImageButton edebiyat = (ImageButton) findViewById(R.id.edebiyat);
        tarih.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent a = new Intent(MainActivity.this, tarihActivity.class);

                startActivity(a);

            }

        });
        cografya.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent a = new Intent(MainActivity.this, cografyaActivity.class);

                startActivity(a);

            }

        });
        edebiyat.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent a = new Intent(MainActivity.this, edebiyatActivity.class);

                startActivity(a);

            }

        });
    }
}