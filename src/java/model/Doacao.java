/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bruno
 */
public class Doacao {    
      
    private int codigo, cod_usuario, cod_inst;
    private String data;
    private double valor;

    public Doacao() {
    }

    public Doacao(int codigo, int cod_usuario, int cod_inst, String data, double valor) {
        this.codigo = codigo;
        this.cod_usuario = cod_usuario;
        this.cod_inst = cod_inst;
        this.data = data;
        this.valor = valor;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cod_usuario
     */
    public int getCod_usuario() {
        return cod_usuario;
    }

    /**
     * @param cod_usuario the cod_usuario to set
     */
    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    /**
     * @return the cod_inst
     */
    public int getCod_inst() {
        return cod_inst;
    }

    /**
     * @param cod_inst the cod_inst to set
     */
    public void setCod_inst(int cod_inst) {
        this.cod_inst = cod_inst;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
