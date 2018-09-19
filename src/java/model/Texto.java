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
public class Texto {
    
    private int idTexto;
    private String descricao;
    private String dataPublicacao;
    private boolean textActive;

    public Texto() {
    }

    public Texto(int idTexto, String descricao, String dataPublicacao, boolean textActive) {
        this.idTexto = idTexto;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.textActive = textActive;
    }

    public int getIdTexto() {
        return idTexto;
    }

    public void setIdTexto(int idTexto) {
        this.idTexto = idTexto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public boolean isTextActive() {
        return textActive;
    }

    public void setTextActive(boolean textActive) {
        this.textActive = textActive;
    }
    
    
}
