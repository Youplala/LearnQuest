package com.example.learnquest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggedout_view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        load(this);
    }

    private void load(final Context context) {
        Button button = findViewById(R.id.tempobouton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, ExerciseActivity.class));
            }
        });
    }


}
