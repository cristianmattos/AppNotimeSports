package com.example.appnotimesportsfinal.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.appnotimesportsfinal.ConexaoSQlite;
import com.example.appnotimesportsfinal.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private final ConexaoSQlite conexaoSQlite;

    public ProdutoDAO(ConexaoSQlite conexaoSQlite){
        this.conexaoSQlite = conexaoSQlite;
    }

    public long salvarProdutoDAO(Produto pProduto){

        SQLiteDatabase db = conexaoSQlite.getWritableDatabase();

        try{

            ContentValues values = new ContentValues();
            values.put("nome", pProduto.getNome());
            values.put("quantidade_em_estoque", pProduto.getQuantidade());
            values.put("preco", pProduto.getPreco());
           long idProdutoInserido = db.insert("produto", null,values);

           return idProdutoInserido;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(db != null){
                db.close();
            }
        }

        return 0;
    }

    public List<Produto> getListaProdutoCtrlDAO(){

        List<Produto> listaProdutos = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM produto;";

        try {
            db = this.conexaoSQlite.getReadableDatabase();

            cursor = db.rawQuery(query, null);

            if(cursor.moveToFirst()){
                Produto produto = null;
                do {

                    produto = new Produto();
                    produto.setId(cursor.getLong(0));
                    produto.setNome(cursor.getString(1));
                    produto.setQuantidade(cursor.getInt(2));
                    produto.setPreco(cursor.getDouble(3));

                    listaProdutos.add(produto);

                }while (cursor.moveToNext());

            }

        }catch (Exception e){
            Log.d("ERRO LISTA PRODUTOS", "erro ao retornar o produto");
            return null;
        }finally {
            if(db != null){db.close();}
        }
        return listaProdutos;
    }

}
