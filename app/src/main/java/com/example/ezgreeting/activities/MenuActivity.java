package com.example.ezgreeting.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ezgreeting.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;




public class MenuActivity extends AppCompatActivity {
//    public static String GLOBAL_OUTPUT;
    private MaterialTextView menu_TXT_output;
    private MaterialButton menu_BTN_greet;
    private MaterialTextView menu_TXT_verify;
    private ArrayList<String> greets = new ArrayList<String>();
    private InterstitialAd mInterstitial;
    private AdView menu_AD_view;

    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        fAuth = FirebaseAuth.getInstance();
        FirebaseUser user = fAuth.getCurrentUser();

        initGreets();
        this.menu_AD_view = new AdView(this);
        findViews();
        if (user.isEmailVerified())
            menu_TXT_verify.setVisibility(View.INVISIBLE);
        else
            notVerified(user);
        initBTNs();

        initInterstitial();
        AdRequest adRequest = new AdRequest.Builder().build();
        menu_AD_view.loadAd(adRequest);
//        initAds();


    }



    private void initInterstitial() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        loadAd();
    }



    private void initAds() {
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
//            }
//        });
//
//
//        AdRequest adRequest = new AdRequest.Builder().build();
//        menu_AD_view.loadAd(adRequest);
//        showInterstitial();
//        loadAd();

    }

    private void showInterstitial() {
        if (mInterstitial != null) {
            mInterstitial.show(MenuActivity.this);
        } else {
//            Log.d(Constants.TAG, "The interstitial ad wasn't ready yet.");
        }
    }


    private void loadAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitial = interstitialAd;
//                        Log.i(Constants.TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
//                        Log.d(Constants.TAG, loadAdError.toString());
                        mInterstitial = null;
                    }
                });
    }

    private void initGreets() {
        Collections.addAll(greets,
                "\uD83C\uDF1E\uD83C\uDF3B Rise and shine! Have a great day! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, may your day be as beautiful as these flowers \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 Have a colorful day! ☀️\uD83C\uDF08",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the sunshine light up your day! \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF1E\uD83C\uDF3B Have a sunny day! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, may your day be filled with blooming opportunities! \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 Start your day with a positive attitude! ☀️\uD83C\uDF08",
                "\uD83C\uDF1E\uD83C\uDF3B Wake up, it's a new day! Make it a good one! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day inspire you! \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new chance to make things happen! ☀️\uD83C\uDF08",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the warmth of the sun fill you with energy! \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF1E\uD83C\uDF3B A fresh start to a new day! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day remind you of your own potential! \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new opportunity! ☀️\uD83C\uDF08",
                "\uD83C\uDF1E\uD83C\uDF3B Wake up and chase your dreams! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day remind you to be grateful! \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new beginning! ☀️\uD83C\uDF08",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the warmth of the sun remind you of your own \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the warmth of the sun remind you of your own inner strength. \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF1E\uD83C\uDF3B Wake up and make today count! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day inspire you to be your best self. \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new adventure! ☀️\uD83C\uDF08",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the warmth of the sun remind you to spread kindness. \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF1E\uD83C\uDF3B Wake up, it's a beautiful day to be alive! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day remind you to be present. \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new chance to make a difference! ☀️\uD83C\uDF08",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the warmth of the sun remind you to be grateful. \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF1E\uD83C\uDF3B Wake up, it's a new day! Make it a good one! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day inspire you to create something new. \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new opportunity! ☀️\uD83C\uDF08",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the warmth of the sun remind you to be your true self. \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF1E\uD83C\uDF3B Wake up, it's a new day! Make it a good one! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day remind you to take chances. \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new possibility! ☀️\uD83C\uDF08",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the warmth of the sun remind you to be kind to yourself. \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF1E\uD83C\uDF3B Wake up, it's a new day! Make it a good one! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day inspire you to achieve your goals. \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new chance to make things happen! ☀️\uD83C\uDF08",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the warmth of the sun remind you to appreciate the little things. \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF1E\uD83C\uDF3B Wake up, it's a new day! Make it a good one \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day remind you to be thankful for what you have. \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new chance to make a positive impact! ☀️\uD83C\uDF08",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the warmth of the sun remind you to enjoy the journey. \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF1E\uD83C\uDF3B Wake up, it's a new day! Make it a good one! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day inspire you to be creative. \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new chance to learn and grow! ☀️\uD83C\uDF08",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the warmth of the sun remind you to be patient. \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF1E\uD83C\uDF3B Wake up, it's a new day! Make it a good one! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day remind you to be persistent. \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new chance to achieve your dreams! ☀️\uD83C\uDF08",
                "\uD83C\uDF3B\uD83C\uDF3A Good morning, let the warmth of the sun remind you to be kind. \uD83C\uDF3B\uD83C\uDF3A",
                "\uD83C\uDF1E\uD83C\uDF3B Wake up, it's a new day! Make it a good one! \uD83C\uDF1E\uD83C\uDF3B",
                "\uD83C\uDF3A\uD83C\uDF38 Good morning, let the beauty of this day inspire you to be optimistic. \uD83C\uDF3A\uD83C\uDF38",
                "☀️\uD83C\uDF08 A new day, a new chance to be happy! ☀️\uD83C\uDF08"
                );
    }


    private void initBTNs() {
        menu_BTN_greet.setEnabled(true);
        menu_BTN_greet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greet();
            }
        });



    }

    private void notVerified(FirebaseUser user) {
        menu_TXT_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(@NonNull Void unused) {
                        Toast.makeText(MenuActivity.this, "Verification mail has been sent!", Toast.LENGTH_LONG).show();
                        finish();
                        Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MenuActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }


    private void greet() {
        int index = (int)(Math.random() * greets.size());
        menu_TXT_output.setText(greets.get(index));
    }



    private void findViews() {
        menu_AD_view = findViewById(R.id.menu_AD_view);
        menu_TXT_output = findViewById(R.id.menu_TXT_output);
        menu_BTN_greet = findViewById(R.id.menu_BTN_greet);
        menu_TXT_verify = findViewById(R.id.menu_TXT_verify);
    }
}