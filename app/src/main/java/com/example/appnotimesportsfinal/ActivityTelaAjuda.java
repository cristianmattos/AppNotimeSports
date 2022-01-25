package com.example.appnotimesportsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTelaAjuda extends AppCompatActivity {
Button buttonEntendi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);
        buttonEntendi = findViewById(R.id.buttonEntendi);
        voltarTelaLoginAjuda();
    }


    public void voltarTelaLoginAjuda(){
        buttonEntendi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaLogin = new Intent(getApplicationContext(), ActivityTelaLogin.class);
                startActivity(telaLogin);
            }
        });

    }
}