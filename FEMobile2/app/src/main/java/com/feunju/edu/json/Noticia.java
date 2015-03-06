package com.feunju.edu.json;

import java.io.Serializable;

/**
 * Created by MITO on 25/02/2015.
 */
public final class Noticia implements Serializable{

    private String noticia_id;
    private String noticia_titulo;
    private String noticia_bajada;
    private String noticia_fecha;
    private String noticia_url_image;
    private String noticia_cuerpo;

    public String getNoticia_id() {
        return noticia_id;
    }

    public void setNoticia_id(String noticia_id) {
        this.noticia_id = noticia_id;
    }

    public String getNoticia_titulo() {
        return noticia_titulo;
    }

    public void setNoticia_titulo(String noticia_titulo) {
        this.noticia_titulo = noticia_titulo;
    }

    public String getNoticia_bajada() {
        return noticia_bajada;
    }

    public void setNoticia_bajada(String noticia_bajada) {
        this.noticia_bajada = noticia_bajada;
    }

    public String getNoticia_fecha() {
        return noticia_fecha;
    }

    public void setNoticia_fecha(String noticia_fecha) {
        this.noticia_fecha = noticia_fecha;
    }

    public String getNoticia_url_image() {
        return noticia_url_image;
    }

    public void setNoticia_url_image(String noticia_url_image) {
        this.noticia_url_image = noticia_url_image;
    }

    public String getNoticia_cuerpo() {
        return noticia_cuerpo;
    }

    public void setNoticia_cuerpo(String noticia_cuerpo) {
        this.noticia_cuerpo = noticia_cuerpo;
    }

    @Override
    public String toString() {
        return "NoticiaTag{" +
                "noticia_id='" + noticia_id + '\'' +
                ", noticia_titulo='" + noticia_titulo + '\'' +
                ", noticia_bajada='" + noticia_bajada + '\'' +
                ", noticia_fecha='" + noticia_fecha + '\'' +
                ", noticia_url_image='" + noticia_url_image + '\'' +
                ", noticia_cuerpo='" + noticia_cuerpo + '\'' +
                '}';
    }
}
