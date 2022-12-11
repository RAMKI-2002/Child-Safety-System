package com.example.childtracking;

import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        Button button1 = (Button) findViewById(R.id.clogin);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(page1.this, SignUPActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.plogin);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(page1.this, LoginActivity2.class);
                startActivity(intent);
            }
        });
    }


}