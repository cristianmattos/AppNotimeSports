package com.example.appnotimesportsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appnotimesportsfinal.controller.ProdutoController;
import com.example.appnotimesportsfinal.controller.UsuarioController;

public class ActivityUsuario extends AppCompatActivity {

    private EditText editTextEmail;
    private   EditText editTextSenha;
    private   EditText editTextSenha2;
    private Button btnSalvarUsuario;
    private Usuario usuario;
   // private EditText editIDusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        //editIDusuario = findViewById(R.id. editIDusuario);
        editTextEmail = findViewById(R.id. editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        editTextSenha2 = findViewById(R.id.editTextSenha2);
        btnSalvarUsuario = findViewById(R.id.btnSalvarUsuario);

        btnSalvarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario();
                usuario.setEmail(editTextEmail.getText().toString());
                usuario.setSenha(editTextSenha.getText().toString());

                String p1 = editTextSenha.getText().toString();
                String p2 = editTextSenha2.getText().toString();


                if (
                        !editTextEmail.getText().toString().equals("") &&
                        !editTextSenha.getText().toString().equals("") &&
                        !editTextSenha2.getText().toString().equals("")) {
                    if (p1.equals(p2)) {
                        ConexaoSQlite conexaoSQlite = new ConexaoSQlite(ActivityUsuario.this);
                        try {
                            long linhasInseridas = conexaoSQlite.Inserir(usuario);
                            if (linhasInseridas > 0) {
                                Toast.makeText(ActivityUsuario.this, "Inserido com sucesso", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ActivityUsuario.this, ActivityTelaLogin.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(ActivityUsuario.this, "Não foi possivel inserir, Contate o administrador do sistema", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception ex) {
                            Toast.makeText(ActivityUsuario.this, "Erro ao inserir" + ex.toString(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ActivityUsuario.this, "As senhas devem ser iguais ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ActivityUsuario.this, "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }






}