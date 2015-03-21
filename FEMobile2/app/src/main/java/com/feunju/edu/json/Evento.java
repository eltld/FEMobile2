package com.feunju.edu.json;

import java.io.Serializable;

/**
 * Created by MITO on 09/03/2015.
 */
public class Evento implements Serializable {


    private String evento_id;
    private String evento_titulo;
    private String evento_bajada;
    private String evento_fecha;
    private String evento_horario;
    private String evento_cuerpo;
    private String evento_url_web;

    public String getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(String evento_id) {
        this.evento_id = evento_id;
    }

    public String getEvento_titulo() {
        return evento_titulo;
    }

    public void setEvento_titulo(String evento_titulo) {
        this.evento_titulo = evento_titulo;
    }

    public String getEvento_bajada() {
        return evento_bajada;
    }

    public void setEvento_bajada(String evento_bajada) {
        this.evento_bajada = evento_bajada;
    }

    public String getEvento_fecha() {
        return evento_fecha;
    }

    public void setEvento_fecha(String evento_fecha) {
        this.evento_fecha = evento_fecha;
    }

    public String getEvento_horario() {
        return evento_horario;
    }

    public void setEvento_horario(String evento_horario) {
        this.evento_horario = evento_horario;
    }

    public String getEvento_cuerpo() {
        return evento_cuerpo;
    }

    public void setEvento_cuerpo(String evento_cuerpo) {
        this.evento_cuerpo = evento_cuerpo;
    }

    public String getEvento_url_web() {
        return evento_url_web;
    }

    public void setEvento_url_web(String evento_url_web) {
        this.evento_url_web = evento_url_web;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "evento_id='" + evento_id + '\'' +
                ", evento_titulo='" + evento_titulo + '\'' +
                ", evento_bajada='" + evento_bajada + '\'' +
                ", evento_fecha='" + evento_fecha + '\'' +
                ", evento_horario='" + evento_horario + '\'' +
                ", evento_cuerpo='" + evento_cuerpo + '\'' +
                ", evento_url_web='" + evento_url_web + '\'' +
                '}';
    }
}
