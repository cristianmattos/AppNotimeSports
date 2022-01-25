package com.example.appnotimesportsfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.PublicKey;

public class ConexaoSQlite extends SQLiteOpenHelper {

    private static ConexaoSQlite INSTANCIA_CONEXAO;
    private static final int VERSAO_DB = 1;
    private static final String NOME_DB = "bl_produtos_app";




    public ConexaoSQlite(@Nullable Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    public static ConexaoSQlite getInstancia(Context context){
        if(INSTANCIA_CONEXAO == null){
            INSTANCIA_CONEXAO = new ConexaoSQlite(context);
        }
        return INSTANCIA_CONEXAO;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {



        String sqlTabelaUsuario  =
                "CREATE TABLE IF NOT EXISTS usuario "+
                        "(" +
                        "id INTEGER PRIMARY KEY," +
                        "email VARCHAR(50)," +
                        "senha VARCHAR(50)" +
                        ")";
        sqLiteDatabase.execSQL(sqlTabelaUsuario);



        String sqlTabelaProduto =
                "CREATE TABLE IF NOT EXISTS produto "+
                        "(" +
                "id INTEGER PRIMARY KEY," +
                "nome TEXT," +
                "quantidade_em_estoque INTEGER," +
                "preco REAL" +
                        ")";

        sqLiteDatabase.execSQL(sqlTabelaProduto);

        String sqlTabelaVenda =
                "CREATE TABLE IF NOT EXISTS venda "+
                        "(" +
                        "id INTEGER PRIMARY KEY," +
                        "data INTEGER" +
                        ")";

        sqLiteDatabase.execSQL(sqlTabelaVenda);

        String sqlTabelaItemDaVenda =
                "CREATE TABLE IF NOT EXISTS item_da_venda "+
                        "(" +
                        "id INTEGER PRIMARY KEY," +
                        "quantidade_vendida INTEGER," +
                        "id_venda INTEGER" +
                        ")";

        sqLiteDatabase.execSQL(sqlTabelaItemDaVenda);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public String ValidarLogin(String email, String senha){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + "usuario" + " WHERE email=? and senha=?", new String[]{email,senha});
        if(cursor.getCount() > 0){
            return "OK";
        }
        return"ERRO";
    }

    public long Inserir(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("EMAIL", usuario.getEmail());
        values.put("SENHA", usuario.getSenha());

        long nLinhas = getWritableDatabase().insert("usuario",null, values);

        return nLinhas;
    }

}
