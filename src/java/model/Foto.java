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
public class Foto {
    
    private int idFoto;
    private String nomeFoto;
    private String descricaoFoto;
    private String caminho;
    private String dataPublicacao;
    private boolean photoActive;

    public Foto() {
    }

    public Foto(int idFoto, String nomeFoto, String descricaoFoto, String caminho, String dataPublicacao, boolean photoIsActive) {
        this.idFoto = idFoto;
        this.nomeFoto = nomeFoto;
        this.descricaoFoto = descricaoFoto;
        this.caminho = caminho;
        this.dataPublicacao = dataPublicacao;
        this.photoActive = photoActive;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public String getNomeFoto() {
        return nomeFoto;
    }

    public void setNomeFoto(String nomeFoto) {
        this.nomeFoto = nomeFoto;
    }

    public String getDescricaoFoto() {
        return descricaoFoto;
    }

    public void setDescricaoFoto(String descricaoFoto) {
        this.descricaoFoto = descricaoFoto;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public boolean isPhotoActive() {
        return photoActive;
    }

    public void setPhotoActive(boolean photoActive) {
        this.photoActive = photoActive;
    }

    
}
