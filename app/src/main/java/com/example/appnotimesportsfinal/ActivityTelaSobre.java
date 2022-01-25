package com.example.appnotimesportsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTelaSobre extends AppCompatActivity {
Button buttonEntendiSobre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobre);
        buttonEntendiSobre = findViewById(R.id. buttonEntendiSobre);
        abrirTelaMenu();
    }

    public void abrirTelaMenu(){
        buttonEntendiSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaMenu = new Intent(getApplicationContext(), ActivityTelaMenu.class);
                startActivity(telaMenu);
            }
        });

    }
}