package com.example.appnotimesportsfinal.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appnotimesportsfinal.ConexaoSQlite;
import com.example.appnotimesportsfinal.Usuario;

public class UsuarioDAO {

    private final ConexaoSQlite conexaoSQlite;

    public UsuarioDAO(ConexaoSQlite conexaoSQlite) {
        this.conexaoSQlite = conexaoSQlite;
    }

    public long salvarUsuarioDAO(Usuario pUsuario) {

        SQLiteDatabase db = conexaoSQlite.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put("email", pUsuario.getEmail());
            values.put("senha", pUsuario.getSenha());
            long idUsuarioInserido = db.insert("usuario", null, values);

            return idUsuarioInserido;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }

        return 0;
    }



}
