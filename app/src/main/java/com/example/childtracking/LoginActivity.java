package com.example.childtracking;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.childtracking.ui.home.HomeFragment;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        signin=findViewById(R.id.signin1);
        DB= new DBHelper(this);
        alertDi(getString(R.string.alerttitle), getString(R.string.perminfo), Settings.ACTION_ACCESSIBILITY_SETTINGS);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(LoginActivity.this,"All fields Required",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), childpage.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void alertDi(String Title, String msg, final String action) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg);
        builder.setTitle(Title);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(action);
                startActivity(intent);
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}