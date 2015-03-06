package com.feunju.edu.domain;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by David Garcia on 24/02/2015.
 */
public class Noticia2 implements Serializable{



    private String idNoticia;
    private String tituloNoticia;
    private String bajadaNoticia;
    private String dateNoticia;
    private String urlImageNoticia;
    private String cuerpoNoticia;
    private Drawable imageNoticia;


    public String getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(String idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getTituloNoticia() {
        return tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia) {
        this.tituloNoticia = tituloNoticia;
    }

    public String getBajadaNoticia() {
        return bajadaNoticia;
    }

    public void setBajadaNoticia(String bajadaNoticia) {
        this.bajadaNoticia = bajadaNoticia;
    }

    public String getDateNoticia() {
        return dateNoticia;
    }

    public void setDateNoticia(String dateNoticia) {
        this.dateNoticia = dateNoticia;
    }

    public String getUrlImageNoticia() {
        return urlImageNoticia;
    }

    public void setUrlImageNoticia(String urlImageNoticia) {
        this.urlImageNoticia = urlImageNoticia;
    }

    public String getCuerpoNoticia() {
        return cuerpoNoticia;
    }

    public void setCuerpoNoticia(String cuerpoNoticia) {
        this.cuerpoNoticia = cuerpoNoticia;
    }

    public Drawable getImageNoticia() {
        return imageNoticia;
    }

    public void setImageNoticia(Drawable imageNoticia) {
        this.imageNoticia = imageNoticia;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "idNoticia='" + idNoticia + '\'' +
                ", tituloNoticia='" + tituloNoticia + '\'' +
                ", bajadaNoticia='" + bajadaNoticia + '\'' +
                ", dateNoticia='" + dateNoticia + '\'' +
                ", urlImageNoticia='" + urlImageNoticia + '\'' +
                ", cuerpoNoticia='" + cuerpoNoticia + '\'' +
                ", imageNoticia=" + imageNoticia +
                '}';
    }
}

