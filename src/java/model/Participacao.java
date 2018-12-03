/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Participacao {

    private int idParticipacao;
    private String dataInsc;
    private int cod_evento;
    private int cod_usuario;
    private int cod_instituicao;

    public Participacao() {
    }

    public Participacao(int idParticipacao, String dataInsc, int cod_evento, int cod_usuario, int cod_instituicao) {
        this.idParticipacao = idParticipacao;
        this.dataInsc = dataInsc;
        this.cod_evento = cod_evento;
        this.cod_usuario = cod_usuario;
        this.cod_instituicao = cod_instituicao;
    }

    public int getIdParticipacao() {
        return idParticipacao;
    }

    public void setIdParticipacao(int idParticipacao) {
        this.idParticipacao = idParticipacao;
    }

    public String getDataInsc() {
        return dataInsc;
    }

    public void setDataInsc(String dataInsc) {
        this.dataInsc = dataInsc;
    }

    public int getCod_evento() {
        return cod_evento;
    }

    public void setCod_evento(int cod_evento) {
        this.cod_evento = cod_evento;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public int getCod_instituicao() {
        return cod_instituicao;
    }

    public void setCod_instituicao(int cod_instituicao) {
        this.cod_instituicao = cod_instituicao;
    }

}
