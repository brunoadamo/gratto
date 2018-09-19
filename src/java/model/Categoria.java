/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MaickHenriquePereira
 */
public class Categoria {
    
    private int idCategoria;
    private String nomeCategoria;
    private boolean categoryActive;

    public Categoria() {
    }

    public Categoria(int idCategoria, String nomeCategoria, boolean categoryActive) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.categoryActive = categoryActive;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public boolean isCategoryActive() {
        return categoryActive;
    }

    public void setCategoryActive(boolean categoryActive) {
        this.categoryActive = categoryActive;
    }
    
    
}

    