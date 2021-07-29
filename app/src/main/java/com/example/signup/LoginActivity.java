//LOGIN ACTIVITY JAVA FILE
package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText euname,epass;
    private Button login;
    String username;
    String password;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        euname = (EditText) findViewById(R.id.unameid);
        epass = (EditText)findViewById(R.id.passid);
        login = (Button)findViewById(R.id.blogin);

        login.setOnClickListener(this);

        Bundle bundle=getIntent().getBundleExtra("data");
        username=bundle.getString("namekey");
        password=bundle.getString("passkey");
    }

    @Override
    public void onClick(View v) {
        String inputname = euname.getText().toString();
        String inputpwd = epass.getText().toString();

        Boolean isValid = validate(inputname,inputpwd);
        if(!isValid) {
            count++;
            if (count == 3) {
                login.setEnabled(false);
                Toast.makeText(this, "Failed Login Attempts", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Login Failed " + count, Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

            Intent inti = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(inti);
        }

    }
    private boolean validate(String name , String password)
    {
        if(name.equals(username)&& password.equals(password)){
            return true;
        }
        return false;
    }
}