package com.example.appnotimesportsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appnotimesportsfinal.controller.ProdutoController;

public class ActivityCadastro extends AppCompatActivity {
   // private EditText editTextIdProduto;
    private   EditText editTextDescricao;
    private EditText editTextPreco;
    private EditText editTextUnidade;
    private Button buttonSalvar;
    private Button buttonCancelar;

    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //editTextIdProduto = findViewById(R.id. editTextIdProduto);
        editTextDescricao = findViewById(R.id.editTextDescricao);
        editTextPreco = findViewById(R.id.editTextPreco);
        editTextUnidade = findViewById(R.id.editTextUnidade);
        buttonSalvar = findViewById(R.id. buttonSalvar);
        buttonCancelar = findViewById(R.id.buttonCancelar);

        this.clickNoBotaoSalvar();
    }

    private void clickNoBotaoSalvar(){
        this.buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produto produtoACadastrar = dadosProduto();

                if(produtoACadastrar != null){

                    ProdutoController produtoController = new ProdutoController(ConexaoSQlite.getInstancia(ActivityCadastro.this));
                    long idProduto = produtoController.salvarProdutoController(produtoACadastrar);

                    if(idProduto > 0){
                        Toast.makeText(ActivityCadastro.this, "Produto Salvo com sucesso!", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(ActivityCadastro.this, "Não foi possivel cadastrar!", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(ActivityCadastro.this, "Todos os campos são obrigatórios", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private Produto dadosProduto(){

        this.produto = new Produto();


        if(this.editTextDescricao.getText().toString().isEmpty() == false){
            this.produto.setNome(this.editTextDescricao.getText().toString());
        } else {
            return null;
        }

        if(this.editTextUnidade.getText().toString().isEmpty() == false){
            int quantidadeProduto = Integer.parseInt(this.editTextUnidade.getText().toString());
            this.produto.setQuantidade(quantidadeProduto);
        } else {
            return null;
        }

        if(this.editTextPreco.getText().toString().isEmpty() == false){
            double precoProduto = Double.parseDouble(this.editTextPreco.getText().toString());
            this.produto.setPreco(precoProduto);
        } else {
            return null;
        }

        return produto;




    }

}