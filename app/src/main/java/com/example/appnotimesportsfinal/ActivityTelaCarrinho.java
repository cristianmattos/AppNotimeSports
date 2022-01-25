package com.example.appnotimesportsfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appnotimesportsfinal.controller.ProdutoController;

import java.util.ArrayList;
import java.util.List;

public class ActivityTelaCarrinho extends AppCompatActivity {
    Button buttonFinalizaVenda;
    private Spinner spnProduto;
    private List<Produto> listaProduto;
    private ProdutoController produtoController;
    private TextView quantidadeItem;


    //carrinho
    private ListView lsvCarrinhosCompras;
    private List<ItemDoCarrinho> listaItensDoCarrinho;
    private AdapterItensDocarrinho adpItemDoCarrinho;
    private TextView tvTotalVenda;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_carrinho);



        buttonFinalizaVenda= findViewById(R.id.buttonFinalizaVenda);
//spinner
        this.produtoController = new ProdutoController(ConexaoSQlite.getInstancia(this));
        this.listaProduto = this.produtoController.getListaProdutoCtrl();

        this.spnProduto = (Spinner) this.findViewById(R.id.spnProduto);
        ArrayAdapter<Produto> spnProdutoAdapter = new ArrayAdapter<Produto>(this, android.R.layout.simple_spinner_item, this.listaProduto);

        this.spnProduto.setAdapter(spnProdutoAdapter);
//end spinner
        this.quantidadeItem = (TextView) this.findViewById(R.id.editQuantidaProduto);
        this.tvTotalVenda = (TextView) this.findViewById(R.id.tvTotalVenda);

        //variasveis e obketos Carrinho de compras
        this.lsvCarrinhosCompras = (ListView) this.findViewById(R.id.lsvProdutos);
        this.listaItensDoCarrinho = new ArrayList<>();
        this.adpItemDoCarrinho = new AdapterItensDocarrinho(ActivityTelaCarrinho.this, this.listaItensDoCarrinho);
        this.lsvCarrinhosCompras.setAdapter(this.adpItemDoCarrinho);


        this.lsvCarrinhosCompras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int posicao, long id) {

                final ItemDoCarrinho itemDoCarrinho = (ItemDoCarrinho) adpItemDoCarrinho.getItem(posicao);

                AlertDialog.Builder janelaDeEscolha = new AlertDialog.Builder(ActivityTelaCarrinho.this);
                janelaDeEscolha.setTitle("Escolha");
                janelaDeEscolha.setMessage("Deseja remover o item " + itemDoCarrinho.getNome() + "?");

                janelaDeEscolha.setNegativeButton("Não", null);

                janelaDeEscolha.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        boolean excluiu = false;

                       excluiu = adpItemDoCarrinho.removerItemDoCarrinho(posicao);

                        double totalVenda = calcularTotalVenda(listaItensDoCarrinho);
                        atualizarValorTotalVenda(totalVenda);


                        if (!excluiu){
                            Toast.makeText(ActivityTelaCarrinho.this, "Erro ao excluir item do carrinho", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                janelaDeEscolha.create().show();
            }
        });
        abrirTelaMaps();

    }

    public void eventAddProduto(View view){
        ItemDoCarrinho itemDoCarrinho = new ItemDoCarrinho();
        Produto produtoSelecionado = (Produto) this.spnProduto.getSelectedItem();

        int quantidadeProduto = 0;

        if (this.quantidadeItem.getText().toString().equals("")){
            quantidadeProduto = 1;
        } else{
            quantidadeProduto = Integer.parseInt(this.quantidadeItem.getText().toString());
        }

        itemDoCarrinho.setNome(produtoSelecionado.getNome());
        itemDoCarrinho.setQuantidadeSelecionada(quantidadeProduto);
        itemDoCarrinho.setPrecoProduto(produtoSelecionado.getPreco());
        itemDoCarrinho.setPrecoDoItemVenda(itemDoCarrinho.getPrecoProduto() * itemDoCarrinho.getQuantidadeSelecionada());

        this.adpItemDoCarrinho.addItemDoCarrinho(itemDoCarrinho);

        double totalVenda = this.calcularTotalVenda(this.listaItensDoCarrinho);
        this.atualizarValorTotalVenda(totalVenda);

    }




    private double calcularTotalVenda(List<ItemDoCarrinho> pItemDoCarrinho){
        double totalVenda = 0d;

        for (ItemDoCarrinho itemDoCarrinho: pItemDoCarrinho) {

            totalVenda += itemDoCarrinho.getPrecoDoItemVenda();
        }

        return totalVenda;
    }

    private  void atualizarValorTotalVenda(double pValorTotal){
        this.tvTotalVenda.setText(String.valueOf(pValorTotal));
    }


    public void abrirTelaMaps(){
        buttonFinalizaVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaMapa = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(telaMapa);
            }
        });

    }


}