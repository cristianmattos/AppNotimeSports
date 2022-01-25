package com.example.appnotimesportsfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphNavigator;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appnotimesportsfinal.controller.ProdutoController;

public class ActivityTelaMenu extends AppCompatActivity {
 //   Button btnCadastroProdutos;
    Button buttonProduto;
    Button buttonCarrinho;
    Button buttonLoja;
    Button buttonSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu);

        ConexaoSQlite.getInstancia(this);


        buttonProduto = findViewById(R.id.buttonProduto);
        buttonCarrinho = findViewById(R.id.buttonCarrinho);
        buttonLoja = findViewById(R.id. buttonLoja);
        buttonSobre = findViewById(R.id. buttonSobre);



       // this.btnCadastroProdutos = findViewById(R.id.btnCadastroProdutos);
      //  abrirTelaCadastro();
        abrirTelaProduto();
        abrirTelaCarrinho();
        abrirTelaLocalizacao();
        abrirTelaSobre();

    }


   // public void abrirTelaCadastro() {
        //this.btnCadastroProdutos.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View view) {
            //    Intent telaCadastro = new Intent(getApplicationContext(), ActivityCadastro.class);
           //     startActivity(telaCadastro);
         //   }
       // });

   // }

    public void abrirTelaProduto() {
        buttonProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaProduto = new Intent(getApplicationContext(), ActivityTelaProduto.class);
                startActivity(telaProduto);
            }
        });


    }

    public void abrirTelaCarrinho() {
        buttonCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaCarrinho = new Intent(getApplicationContext(), ActivityTelaCarrinho.class);
                startActivity(telaCarrinho);
            }
        });


    }

    public void abrirTelaLocalizacao() {
        this.buttonLoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaLocal = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(telaLocal);
            }
        });

    }

    public void abrirTelaSobre() {
        this.buttonSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaSobre = new Intent(getApplicationContext(), ActivityTelaSobre.class);
                startActivity(telaSobre);
            }
        });

    }



}