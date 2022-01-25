package com.example.appnotimesportsfinal.controller;

import com.example.appnotimesportsfinal.ConexaoSQlite;
import com.example.appnotimesportsfinal.DAO.ProdutoDAO;
import com.example.appnotimesportsfinal.Produto;

import java.util.List;

public class ProdutoController {

    private final ProdutoDAO produtoDAO;

    public ProdutoController(ConexaoSQlite pConexaoSQLite){
        produtoDAO = new ProdutoDAO(pConexaoSQLite);
    }

    public long salvarProdutoController(Produto pProduto){
        return this.produtoDAO.salvarProdutoDAO(pProduto);
    }
    public List<Produto> getListaProdutoCtrl() {

        return this.produtoDAO.getListaProdutoCtrlDAO();

    }

}
