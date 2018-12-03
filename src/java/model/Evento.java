/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Evento {

    private int idEvento;
    private String nome;
    private String desc;
    private String dataIni;
    private String dataFim;
    private String horaIni;
    private String horaFim;
    private int ativo;
    private int limit;
    private int cod_inst;
    private int cod_usuario;

    public Evento() {
    }

    public Evento(int idEvento, String nome, String desc, String dataIni, String dataFim, String horaIni, String horaFim, int limit, int cod_inst, int ativo, int cod_usuario) {
        this.idEvento = idEvento;
        this.nome = nome;
        this.desc = desc;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
        this.horaIni = horaIni;
        this.horaFim = horaFim;
        this.cod_inst = cod_inst;
        this.limit = limit;
        this.ativo = ativo;
        this.ativo = cod_usuario;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCod_inst() {
        return cod_inst;
    }

    public void setCod_inst(int cod_inst) {
        this.cod_inst = cod_inst;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

}
