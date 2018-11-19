/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Participacao {
    
    private int idParticipacao;
    private String dataInsc;

    public Participacao() {
    }

    public Participacao(int idParticipacao, String dataInsc) {
        this.idParticipacao = idParticipacao;
        this.dataInsc = dataInsc;
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

}
