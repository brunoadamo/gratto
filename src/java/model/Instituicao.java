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
public class Instituicao {

    private int idInstituicao;
    private String razaoSocial;
    private String nomeFantasia;
    private String descricao;
    private String cnpj;
    private String enderecoInstituicao;
    private String numero;
    private String bairro;
    private String cidadeInstituicao;
    private String estadoInstituicao;
    private String paisInstituicao;
    private String cepInstituicao;
    private String telefoneInstituicao;
    private String emailInstituicao;
    private String siteInstituicao;
    private String facebookInstituicao;
    private String dataAprovacao;
    private String statusInstituicao;
    private boolean instIsActive;
    private int img;

    public Instituicao() {
    }

    public Instituicao(int idInstituicao, String razaoSocial, String nomeFantasia, String cnpj, String enderecoInstituicao, String numero, String bairro, String cidadeInstituicao, String estadoInstituicao, String paisInstituicao, String cepInstituicao, String telefoneInstituicao, String emailInstituicao, String siteInstituicao, String facebookInstituicao, String dataAprovacao, String statusInstituicao, boolean instIsActive) {
        this.idInstituicao = idInstituicao;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.enderecoInstituicao = enderecoInstituicao;
        this.numero = numero;
        this.bairro = bairro;
        this.cidadeInstituicao = cidadeInstituicao;
        this.estadoInstituicao = estadoInstituicao;
        this.paisInstituicao = paisInstituicao;
        this.cepInstituicao = cepInstituicao;
        this.telefoneInstituicao = telefoneInstituicao;
        this.emailInstituicao = emailInstituicao;
        this.siteInstituicao = siteInstituicao;
        this.facebookInstituicao = facebookInstituicao;
        this.dataAprovacao = dataAprovacao;
        this.statusInstituicao = statusInstituicao;
        this.instIsActive = instIsActive;
    }

    public int getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEnderecoInstituicao() {
        return enderecoInstituicao;
    }

    public void setEnderecoInstituicao(String enderecoInstituicao) {
        this.enderecoInstituicao = enderecoInstituicao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidadeInstituicao() {
        return cidadeInstituicao;
    }

    public void setCidadeInstituicao(String cidadeInstituicao) {
        this.cidadeInstituicao = cidadeInstituicao;
    }

    public String getEstadoInstituicao() {
        return estadoInstituicao;
    }

    public void setEstadoInstituicao(String estadoInstituicao) {
        this.estadoInstituicao = estadoInstituicao;
    }

    public String getPaisInstituicao() {
        return paisInstituicao;
    }

    public void setPaisInstituicao(String paisInstituicao) {
        this.paisInstituicao = paisInstituicao;
    }

    public String getCepInstituicao() {
        return cepInstituicao;
    }

    public void setCepInstituicao(String cepInstituicao) {
        this.cepInstituicao = cepInstituicao;
    }

    public String getTelefoneInstituicao() {
        return telefoneInstituicao;
    }

    public void setTelefoneInstituicao(String telefoneInstituicao) {
        this.telefoneInstituicao = telefoneInstituicao;
    }

    public String getEmailInstituicao() {
        return emailInstituicao;
    }

    public void setEmailInstituicao(String emailInstituicao) {
        this.emailInstituicao = emailInstituicao;
    }

    public String getSiteInstituicao() {
        return siteInstituicao;
    }

    public void setSiteInstituicao(String siteInstituicao) {
        this.siteInstituicao = siteInstituicao;
    }

    public String getFacebookInstituicao() {
        return facebookInstituicao;
    }

    public void setFacebookInstituicao(String facebookInstituicao) {
        this.facebookInstituicao = facebookInstituicao;
    }

    public String getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(String dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public String getStatusInstituicao() {
        return statusInstituicao;
    }

    public void setStatusInstituicao(String statusInstituicao) {
        this.statusInstituicao = statusInstituicao;
    }

    public boolean isInstIsActive() {
        return instIsActive;
    }

    public void setInstIsActive(boolean instIsActive) {
        this.instIsActive = instIsActive;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the img
     */
    public int getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(int img) {
        this.img = img;
    }

}
