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
public class Usuario {

    private int idUsuario;
    private String nomeUsuario;
    private String dataNascimento;
    private String telefoneUsuario;
    private String emailUsuario;
    private String senha;
    private String sexo;
    private String cidadeUsuario;
    private boolean userActive;
    private String dataCriacaoUsuario;
    private String estadoUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nomeUsuario, String dataNascimento, String telefoneUsuario, String sexo, String cidadeUsuario, boolean userActive, String emailUsuario, String dataCriacaoUsuario, String estadoUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.telefoneUsuario = telefoneUsuario;
        this.sexo = sexo;
        this.cidadeUsuario = cidadeUsuario;
        this.userActive = userActive;
        this.emailUsuario = emailUsuario;
        this.dataCriacaoUsuario = dataCriacaoUsuario;
        this.estadoUsuario = estadoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCidadeUsuario() {
        return cidadeUsuario;
    }

    public void setCidadeUsuario(String cidadeUsuario) {
        this.cidadeUsuario = cidadeUsuario;
    }

    public boolean isUserActive() {
        return userActive;
    }

    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getDataCriacaoUsuario() {
        return dataCriacaoUsuario;
    }

    public void setDataCriacaoUsuario(String dataCriacaoUsuario) {
        this.dataCriacaoUsuario = dataCriacaoUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
