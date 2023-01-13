package com.example.ezgreeting.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ezgreeting.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout start_EDT_email;
    private TextInputLayout start_EDT_password;
    private MaterialButton start_BTN_register;
    private MaterialButton start_BTN_login;
    private MaterialTextView start_TXT_forgot;
    private TextInputLayout[] loginFields;

//    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        fAuth = FirebaseAuth.getInstance();

        findViews();
        initBTNs();
        initCounters();
        checkLoginValidation();
    }


    private void initCounters() {
//        MyFirebaseDB.getCounter("meals_counter", new MyFirebaseDB.CallBack_Counter() {
//            @Override
//            public void dataReady(int value) {
//                Meal.setCounter(value);
//            }
//        });
//        MyFirebaseDB.getCounter("users_counter", new MyFirebaseDB.CallBack_Counter() {
//            @Override
//            public void dataReady(int value) {
//                User.setCounter(value);
//            }
//        });
    }

    private void initBTNs() {
        start_BTN_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { register();}
        });

        start_BTN_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { login();}
        });

        start_TXT_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { forgotPassword(v);}
        });
    }


    private void login() {
        finish();
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intent);


        if (isValid()) {
            String email, password;
            email = start_EDT_email.getEditText().getText().toString().trim();
            password = start_EDT_password.getEditText().getText().toString().trim();

//            fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if (task.isSuccessful()) {
//                        Toast.makeText(ActivityStart.this, "Logged in successfully!", Toast.LENGTH_LONG).show();
//                        finish();
//                        Intent intent = new Intent(ActivityStart.this, ActivityMenu.class);
//                        startActivity(intent);
//                    }
//                    else
//                        Toast.makeText(ActivityStart.this, "Email or Password are incorrect!", Toast.LENGTH_LONG).show();
//                }
//            });
        }

        else
            Toast.makeText(this, "One or more field are invalid!", Toast.LENGTH_LONG).show();

    }

    private void register() {
        finish();
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void forgotPassword(View v) {
        EditText resetMail = new EditText(v.getContext());
        AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
        passwordResetDialog.setTitle("Reset Password");
        passwordResetDialog.setMessage("Enter your email to receive a link for password reset");
        passwordResetDialog.setView(resetMail);

//        passwordResetDialog.setPositiveButton("Send", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                String mail = resetMail.getText().toString();
//                fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(@NonNull Void unused) {
//                        Toast.makeText(ActivityStart.this, "Reset link sent to your mail!", Toast.LENGTH_LONG).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(ActivityStart.this, "Error!", Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        });

        passwordResetDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        passwordResetDialog.create().show();
    }

    private void checkLoginValidation() {
//        Validator.Builder
//                .make(start_EDT_email)
//                .addWatcher(new Validator.Watcher_Email("Invalid email"))
//                .build();
//
//        Validator.Builder
//                .make(start_EDT_password)
//                .addWatcher(new Validator.Watcher_Password("Invalid password"))
//                .build();
    }

    private boolean isValid() {
        for (TextInputLayout field : loginFields) {
            if (field.getError() != null || field.getEditText().getText().toString().isEmpty())
                return false;
        }
        return true;
    }


    private void findViews() {
        start_EDT_email = findViewById(R.id.start_EDT_email);
        start_EDT_password = findViewById(R.id.start_EDT_password);
        start_BTN_register = findViewById(R.id.start_BTN_register);
        start_BTN_login = findViewById(R.id.start_BTN_login);
        start_TXT_forgot = findViewById(R.id.start_TXT_forgot);
        loginFields = new TextInputLayout[] {
                start_EDT_email,
                start_EDT_password
        };
    }
}