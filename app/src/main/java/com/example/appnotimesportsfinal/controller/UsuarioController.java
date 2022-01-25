package com.example.appnotimesportsfinal.controller;

import com.example.appnotimesportsfinal.ConexaoSQlite;
import com.example.appnotimesportsfinal.DAO.UsuarioDAO;
import com.example.appnotimesportsfinal.Usuario;

public class UsuarioController {

    private final UsuarioDAO usuarioDAO;

    public UsuarioController(ConexaoSQlite pConexaoSQLite){
        usuarioDAO = new UsuarioDAO(pConexaoSQLite);
    }

    public long salvarUsuarioController(Usuario pUsuario){
        return this.usuarioDAO.salvarUsuarioDAO(pUsuario);
    }


}
