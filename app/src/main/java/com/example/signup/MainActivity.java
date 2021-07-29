//MAIN ACTIVITY JAVA FILE
package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private TextView uname,pwd;
     private Button Signin,Login;
     String regularExpression="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    //String regularExpression="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=(TextView) findViewById(R.id.username);
        pwd=(TextView) findViewById(R.id.password);
        Signin=(Button)findViewById(R.id.signin);
        Login=(Button)findViewById(R.id.login);
        Login.setOnClickListener(this);
        Signin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.equals(Signin)){
            String newuname=uname.getText().toString();
            String newpass=pwd.getText().toString();
            
            if(validatePassword(newpass)){
                System.out.println(validatePassword(newpass));
                Bundle bundle=new Bundle();
                bundle.putString("namekey",newuname);
                bundle.putString("passkey",newpass);
                Intent it = new Intent(MainActivity.this,LoginActivity.class);
                it.putExtra("data",bundle);
                startActivity(it);
            }
            else {
                Toast.makeText(getBaseContext(), "Invalid Password", Toast.LENGTH_LONG).show();
            }
        }
        else if(v.equals(Login)){

            Intent t = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(t);

        }
    }
    public boolean validatePassword(String password) {
        System.out.println(password);
        Pattern pattern= Pattern.compile(regularExpression);
        Matcher matcher=pattern.matcher(password);
        System.out.println(matcher.matches());
        return matcher.matches();
    }

}