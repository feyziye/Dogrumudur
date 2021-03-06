package com.example.kullanc.dogrumudur;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class cografyaActivity extends AppCompatActivity {

    private TextView soru,puan;
    private String[] sorular;
    private int      soruKontrol=0;
    private int[]    cevapKontrol;
    private Button dogru,yanlis;

    private int      yanlısSayısı=0, dogruSayısı=0, clikKontrol;

    private TextView zaman;
    private Handler handle = null;
    private Runnable runnable = null;
    private int      zamanKontrol= 25;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cografya);

        soru= (TextView) findViewById(R.id.soru);
        puan= (TextView) findViewById(R.id.puan);
        dogru= (Button) findViewById(R.id.dogru);
        yanlis= (Button) findViewById(R.id.yanlis);
        zaman = (TextView) findViewById(R.id.zaman);
        //geributon
        Button geri = (Button) findViewById(R.id.geri);
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(cografyaActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        sorular= new String[]{
                "Dünyanın en yüksek dağı Everest Dağıdır.",
                "Türkiye’nin en büyük yüzölçümüne sahip ili Sivas’dır.",
                "Türkiye ile Türk devletleri arasında kara bağlantısı olan tek toprak parçası Nahcivan’dır.",
                "Deniz üzerine inşa edilen Türkiye’nin ilk havalimanı Antalya Kaş Havalimanı’dır.",
                "Antalya çevresini göller yöresine bağlayan geçit Çubuk’tur."
        };
        cevapKontrol= new int[]{1,0,1,0,1};
        // zaman
        handle = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                zaman.setText(String.valueOf(zamanKontrol));
                // soru
                soru.setText(sorular[soruKontrol]);
                // şıklar
                dogru.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (clikKontrol == 0) {
                            if (cevapKontrol[soruKontrol] == 1) {
                                dogruSayısı += 1;
                            } else {
                                yanlısSayısı += 1;
                            }
                            puan.setText("puanınız: " + 5 * dogruSayısı);
                            clikKontrol = 1;
                        }

                    }
                });
                yanlis.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if (clikKontrol == 0) {
                            if (cevapKontrol[soruKontrol] == 0) {
                                dogruSayısı += 1;
                            } else {
                                yanlısSayısı += 1;
                            }
                            puan.setText("puanınız: " + 5 * dogruSayısı);
                            clikKontrol = 1;
                        }
                    }
                });
                // yeni soru
                // cevap verdikten yarım sn sonra komut çalışsın
                if(clikKontrol==1) {
                    soruKontrol += 1;
                }
                // kontrol
                if (zamanKontrol != 0) {
                    zamanKontrol--;
                } else {
                    handle.removeCallbacks(runnable);
                    zamanKontrol=25;
                    clikKontrol=0;

                    if(soruKontrol==sorular.length){

                    }
                    soruKontrol+=1;
                }
                if(soruKontrol==5){
                    Toast.makeText(cografyaActivity.this, "OYUN BİTTİ!", Toast.LENGTH_SHORT).show();
                }
                handle.postDelayed(runnable, 1000);
                clikKontrol  =0;
            }	};
        runnable.run();

    }	}
