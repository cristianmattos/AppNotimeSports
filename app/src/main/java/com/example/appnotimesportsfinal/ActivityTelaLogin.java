package com.example.appnotimesportsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTelaLogin extends AppCompatActivity {
Button btnEntrar;
EditText editTextEmail;
EditText editTextSenha;
TextView textCriarCadastro;
TextView textAjuda;
ConexaoSQlite conexaoSQlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        textAjuda= findViewById(R.id.textAjuda);
        editTextEmail= findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        textCriarCadastro = findViewById(R.id.textCriarCadastro);


        conexaoSQlite = new ConexaoSQlite(this);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();

                if(email.equals("")) {
                    Toast.makeText(ActivityTelaLogin.this, "Email não inserido", Toast.LENGTH_SHORT).show();
                } else if (senha.equals("")) {
                    Toast.makeText(ActivityTelaLogin.this, "Senha não inserida", Toast.LENGTH_SHORT).show();
                } else {

                    String res = conexaoSQlite.ValidarLogin(email, senha);
                    if(res.equals("OK")){

                        Toast.makeText(ActivityTelaLogin.this, "Logado com sucesso", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(ActivityTelaLogin.this, ActivityTelaMenu.class);
                        startActivity(i);


                    } else {
                        Toast.makeText(ActivityTelaLogin.this, "Login errado, tente novamente", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


        abrirTelaUsuario();
        abrirTelaAjuda();

    }



    public void abrirTelaUsuario(){
        textCriarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaUsu = new Intent(getApplicationContext(), ActivityUsuario.class);
                startActivity(telaUsu);
            }
        });

    }

    public void abrirTelaAjuda(){
        textAjuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaAjuda = new Intent(getApplicationContext(), ActivityTelaAjuda.class);
                startActivity(telaAjuda);
            }
        });

    }


}