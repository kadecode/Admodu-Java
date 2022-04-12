package com.example.admodu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    private AdView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(MainActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        banner = findViewById(R.id.banner);
        AdRequest adRequest = new AdRequest.Builder().build();
        banner.loadAd(adRequest);

        banner.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                Log.e("Banner","OnAdLoaded Çalıştı");
            }

            @Override
            public void onAdFailedToLoad(int i) {
                Log.e("Banner","onAdFailedToLoad Çalıştı");
            }

            @Override
            public void onAdClosed() {
                Log.e("Banner","onAdClosed Çalıştı");
            }

            @Override
            public void onAdOpened() {
                Log.e("Banner","onAdOpened Çalıştı");
            }

            @Override
            public void onAdLeftApplication() {
                Log.e("Banner","onAdLeftApplication Çalıştı");
            }
        });
    }
}