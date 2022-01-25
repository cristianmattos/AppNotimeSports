package com.example.appnotimesportsfinal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterItensDocarrinho extends BaseAdapter {

   private Context context;
   private List<ItemDoCarrinho> itensDoCarrinho;

    public AdapterItensDocarrinho(Context context, List<ItemDoCarrinho> itensDocarrinho) {
        this.context = context;
        this.itensDoCarrinho = itensDocarrinho;
    }

    @Override
    public int getCount() {
        return this.itensDoCarrinho.size();
    }

    @Override
    public Object getItem(int posicao) {
        return this.itensDoCarrinho.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }


    public boolean removerItemDoCarrinho(int posicao)
    {
        this.itensDoCarrinho.remove(posicao);
        notifyDataSetChanged();
        return true;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        View v = View.inflate(this.context, R.layout.layout_carrinho, null);

        TextView tvNomeProduto = (TextView) v.findViewById(R.id.tvNomeProduto);
        TextView tvPrecoProduto = (TextView) v.findViewById(R.id.tvPrecoProduto);
        TextView tvQuantidadeSelecionada = (TextView) v.findViewById(R.id.tvQuantidadeProduto);
        TextView tvValorDoItem = (TextView) v.findViewById(R.id.tvValorTotaItem);


        tvNomeProduto.setText(this.itensDoCarrinho.get(posicao).getNome());
        tvPrecoProduto.setText(String.valueOf(this.itensDoCarrinho.get(posicao).getPrecoProduto()));
        tvQuantidadeSelecionada.setText(String.valueOf(this.itensDoCarrinho.get(posicao).getQuantidadeSelecionada()));
        tvValorDoItem.setText(String.valueOf(this.itensDoCarrinho.get(posicao).getPrecoDoItemVenda()));
        return v;
    }

    public void addItemDoCarrinho(ItemDoCarrinho pItemDoCarrinho){
        this.itensDoCarrinho.add(pItemDoCarrinho);
        this.notifyDataSetChanged();

    }


    public void ataualizar(List<ItemDoCarrinho> pItensDoCarrinho){
        this.itensDoCarrinho.clear();
        this.itensDoCarrinho = pItensDoCarrinho;
        this.notifyDataSetChanged();
    }

}
