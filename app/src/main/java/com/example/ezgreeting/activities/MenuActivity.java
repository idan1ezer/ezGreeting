package com.example.ezgreeting.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezgreeting.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

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


//    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
//        fAuth = FirebaseAuth.getInstance();
//        FirebaseUser user = fAuth.getCurrentUser();

        initGreets();
        findViews();
//        if (user.isEmailVerified())
//            initBTNs();
//        else
//            notVerified(user);
        initBTNs();
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
        menu_TXT_verify.setVisibility(View.INVISIBLE);

        menu_BTN_greet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greet();
            }
        });

    }

//    private void notVerified(FirebaseUser user) {
//        menu_BTN_share.setEnabled(false);
//        menu_BTN_receive.setEnabled(false);
//        menu_TXT_verify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(@NonNull Void unused) {
//                        Toast.makeText(ActivityMenu.this, "Verification mail has been sent!", Toast.LENGTH_LONG).show();
//                        finish();
//                        Intent intent = new Intent(ActivityMenu.this, ActivityStart.class);
//                        startActivity(intent);
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(ActivityMenu.this, "Error!" + e.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        });
//    }


    private void greet() {
        int index = (int)(Math.random() * greets.size());
        menu_TXT_output.setText(greets.get(index));


//        String input = menu_TXF_input.getText().toString();
//        CoreNLPSummarizer summarizer = (CoreNLPSummarizer) new CoreNLPSummarizer(input, new MyHTTPInterface() {
//            @Override
//            public void myMethod(boolean result) {
//                if (result == true) {
////                    Toast.makeText(MenuActivity.this, "Registered successfully!", Toast.LENGTH_LONG).show();
//                    System.out.println("Worked");
//                }
//            }
//        }).execute();

//        menu_TXT_output.setText(GLOBAL_OUTPUT);

    }



    private void findViews() {
        menu_TXT_output = findViewById(R.id.menu_TXT_output);
        menu_BTN_greet = findViewById(R.id.menu_BTN_greet);
        menu_TXT_verify = findViewById(R.id.menu_TXT_verify);
    }
}