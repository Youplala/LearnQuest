package com.example.learnquest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoggedOutActivity extends AppCompatActivity {

    Button logInButton;
    Button registerButton;
    float y_ini;
    float y_end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            setContentView(R.layout.loggedout_view);
        }else{
            //TODO : Faire le transfert vers l'activitée principale
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        setLogInButton(this);
        setRegisterButton(this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                y_ini = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                y_end = event.getY();
                if(y_ini > y_end+300){
                    startActivity(new Intent(this,LogInActiviy.class));
                    overridePendingTransition(R.anim.slide_in_bot, R.anim.slide_out_top);
                }
                break;
        }
        return false;
    }

    protected void setLogInButton(final Context context){
        logInButton = findViewById(R.id.loggedOutLogInButton);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,LogInActiviy.class));
                overridePendingTransition(R.anim.slide_in_bot, R.anim.slide_out_top);
            }
        });
    }

    protected void setRegisterButton(final Context context){
        registerButton = findViewById(R.id.loggedOutRegisterButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,RegisterActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
    }
}
