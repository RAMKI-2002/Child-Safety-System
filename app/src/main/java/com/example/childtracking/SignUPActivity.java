package com.example.childtracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPActivity extends AppCompatActivity {

    EditText username,password,repassword;
    Button signup,signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.signup);
        signin=findViewById(R.id.signin);
        repassword=findViewById(R.id.repassword);
        DB= new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(SignUPActivity.this,"All fields Required",Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(SignUPActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(SignUPActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignUPActivity.this,"User Already Exists",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(SignUPActivity.this,"Paawords are not matching",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}