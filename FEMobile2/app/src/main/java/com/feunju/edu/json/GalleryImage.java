package com.feunju.edu.json;

import java.io.Serializable;

/**
 * Created by David Garcia on 20/03/2015.
 */
public class GalleryImage implements Serializable {

   private String GALERIA_ID;
   private String GALERIA_URL ;

    public String getGALERIA_ID() {
        return GALERIA_ID;
    }

    public void setGALERIA_ID(String GALERIA_ID) {
        this.GALERIA_ID = GALERIA_ID;
    }

    public String getGALERIA_URL() {
        return GALERIA_URL;
    }

    public void setGALERIA_URL(String GALERIA_URL) {
        this.GALERIA_URL = GALERIA_URL;
    }

    @Override
    public String toString() {
        return "GalleryImage{" +
                "GALERIA_ID='" + GALERIA_ID + '\'' +
                ", GALERIA_URL='" + GALERIA_URL + '\'' +
                '}';
    }
}
