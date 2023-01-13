package com.example.ezgreeting.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezgreeting.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;




public class MenuActivity extends AppCompatActivity {
    public static String GLOBAL_OUTPUT;
    private MaterialTextView menu_TXT_output;
    private MaterialButton menu_BTN_summary;
    private MaterialTextView menu_TXT_verify;

//    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
//        fAuth = FirebaseAuth.getInstance();
//        FirebaseUser user = fAuth.getCurrentUser();

        findViews();
//        if (user.isEmailVerified())
//            initBTNs();
//        else
//            notVerified(user);
        initBTNs();
    }


    private void initBTNs() {
        menu_BTN_summary.setEnabled(true);
        menu_TXT_verify.setVisibility(View.INVISIBLE);

        menu_BTN_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                summary();
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


    private void summary() {
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

        menu_TXT_output.setText(GLOBAL_OUTPUT);

    }



    private void findViews() {
        menu_TXT_output = findViewById(R.id.menu_TXT_output);
        menu_BTN_summary = findViewById(R.id.menu_BTN_summary);
        menu_TXT_verify = findViewById(R.id.menu_TXT_verify);
    }
}