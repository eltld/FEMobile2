package com.feunju.domain;

import android.widget.ImageView;

/**
 * Created by David Garcia on 03/03/2015.
 */
public class Autoridad
{

    private String idAutoridad;
private String tituloAutoridad;
private String nombreAutoridad;
private String emailAutoridad;
private String telefonoAutoridad;
private ImageView imageAutoridad;
private String imageUrlAutoridad;

        public String getIdAutoridad() {
            return idAutoridad;
        }
        public void setIdAutoridad(String idAutoridad) {
            this.idAutoridad = idAutoridad;
        }
        public String getTituloAutoridad() {
            return tituloAutoridad;
        }
        public void setTituloAutoridad(String tituloAutoridad) {
            this.tituloAutoridad = tituloAutoridad;
        }
        public String getNombreAutoridad() {
            return nombreAutoridad;
        }
        public void setNombreAutoridad(String nombreAutoridad) {
            this.nombreAutoridad = nombreAutoridad;
        }
        public String getEmailAutoridad() {
            return emailAutoridad;
        }
        public void setEmailAutoridad(String emailAutoridad) {
            this.emailAutoridad = emailAutoridad;
        }
        public String getTelefonoAutoridad() {
            return telefonoAutoridad;
        }
        public void setTelefonoAutoridad(String telefonoAutoridad) {
            this.telefonoAutoridad = telefonoAutoridad;
        }
        public ImageView getImageAutoridad() {
            return imageAutoridad;
        }
        public void setImageAutoridad(ImageView imageAutoridad) {
            this.imageAutoridad = imageAutoridad;
        }


        public String getImageUrlAutoridad() {
            return imageUrlAutoridad;
        }
        public void setImageUrlAutoridad(String imageUrlAutoridad) {
            this.imageUrlAutoridad = imageUrlAutoridad;
        }


        @Override
        public String toString() {
            return "Autoridad{" +
                    "idAutoridad='" + idAutoridad + '\'' +
                    ", tituloAutoridad='" + tituloAutoridad + '\'' +
                    ", nombreAutoridad='" + nombreAutoridad + '\'' +
                    ", emailAutoridad='" + emailAutoridad + '\'' +
                    ", telefonoAutoridad='" + telefonoAutoridad + '\'' +
                    ", imageAutoridad=" + imageAutoridad +
                    ", imageUrlAutoridad='" + imageUrlAutoridad + '\'' +
                    '}';
        }
}
