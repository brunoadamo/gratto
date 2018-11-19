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
public class Log {

    private int idLog;
    private int codUsuario;
    private String dataHora;
    private String modulo;
    private String acao;
    private String parametros;

    public Log() {
    }

    public Log(int idLog, int codUsuario, String dataHora, String modulo, String acao, String parametros) {
        this.idLog = idLog;
        this.codUsuario = codUsuario;
        this.dataHora = dataHora;
        this.modulo = modulo;
        this.acao = acao;
        this.parametros = parametros;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

}
