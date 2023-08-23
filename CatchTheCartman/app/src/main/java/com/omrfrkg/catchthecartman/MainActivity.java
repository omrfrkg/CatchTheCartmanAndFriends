package com.omrfrkg.catchthecartman;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int skor = 0;
    String karakter ="";
    TextView sure;
    TextView skorGosterge;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    MediaPlayer mediaPlayer;
    MediaPlayer hit;
    MediaPlayer highScore;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sure = findViewById(R.id.sure);
        skorGosterge = findViewById(R.id.skorGosterge);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);

        sharedPreferences = getSharedPreferences("com.omrfrkg.catchthecartman", Context.MODE_PRIVATE);

        imageArray = new ImageView[] {imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12};


       String secilenKarakter = sharedPreferences.getString("character","cartman");
       int enYuksekSkor = sharedPreferences.getInt("enYuksekSkor",0);

        int id = getResources().getIdentifier(
                "com.omrfrkg.catchthecartman:drawable/" + secilenKarakter,
                null,
                null
        );
        for (ImageView image : imageArray){
            image.setImageResource(id);
        }

        //int kapaliMi = sharedPreferences.getInt("muzakKapat",1);

        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.music);
        highScore = MediaPlayer.create(MainActivity.this,R.raw.cong_song);
        hit = MediaPlayer.create(MainActivity.this,R.raw.hit_sounds);

        mediaPlayer.start();


        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long zaman) {
                sure.setText("Süre : "+zaman/1000);
            }

            @Override
            public void onFinish() {

                sure.setText("Süre Bitti!");

                handler.removeCallbacks(runnable);

                for (ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Oyun Bitti");
                alert.setMessage("Süreniz doldu tekrar oynamak ister misiniz?");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent
                        );

                    }
                });
                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(),StartScreenActivity.class);
                        startActivity(intent);
                    }
                });

                alert.show();

                enYuksekSkorHesaplaVeKaydet(skor,enYuksekSkor);

            }
        }.start();

        resimleriSakla();


    }

    public void skorArttir(View view){

        skor++;
        skorGosterge.setText("Skorunuz : "+skor);
        hit.start();

    }

    public void resimleriSakla(){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(12);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };

        handler.post(runnable);
    }

    public void enYuksekSkorHesaplaVeKaydet(int skor,int enYuksekSkor){
        if (skor > enYuksekSkor){
            sharedPreferences.edit().putInt("enYuksekSkor",skor).apply();
            highScore.start();
            Toast.makeText(MainActivity.this,"Tebrikler En Yüksek Skoru Yaptınız...",Toast.LENGTH_LONG).show();
        }

    }
}