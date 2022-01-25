package com.example.appnotimesportsfinal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterListaProdutos extends BaseAdapter {

   private Context context;
   private List<Produto> produtoList;

    public AdapterListaProdutos(Context context, List<Produto> produtoList) {
        this.context = context;
        this.produtoList = produtoList;
    }

    @Override
    public int getCount() {
        return this.produtoList.size();
    }

    @Override
    public Object getItem(int posicao) {
        return this.produtoList.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        View v = View.inflate(this.context, R.layout.activity_cadastro, null);

        TextView editTextDescricao = (TextView) v.findViewById(R.id.editTextDescricao);
        TextView editTextPreco = (TextView) v.findViewById(R.id.editTextPreco);
        TextView editTextUnidade = (TextView) v.findViewById(R.id.editTextUnidade);


        editTextDescricao.setText(this.produtoList.get(posicao).getNome());
        editTextPreco.setText(String.valueOf(this.produtoList.get(posicao).getPreco()));
        editTextUnidade.setText(String.valueOf(this.produtoList.get(posicao).getQuantidade()));

        return v;
    }
}
