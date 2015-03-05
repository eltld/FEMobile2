package com.feunju.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.feunju.R;
import com.feunju.fragment.NoticiaDetalleFragment;
import com.feunju.json.Noticia;

/**
 * Created by MITO on 02/03/2015.
 */
public class NoticiaDetalleActivity extends FragmentActivity {

   //obtengo un Fragment de Detalle
    NoticiaDetalleFragment noticiaDetalleFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticia_detalle_activity);

        //obtenemos los datos para displary el bundel
        Noticia noticia=(Noticia)getIntent().getSerializableExtra("noticia");
        System.out.println("noticia detalle activity : "+noticia);
        if(savedInstanceState==null)
        {
            //insert item detail para display el bundle
            noticiaDetalleFragment=NoticiaDetalleFragment.newInstance(noticia);
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            //reemplao el fragment container con el de noticia detalle
            ft.replace(R.id.flDetailContainer,noticiaDetalleFragment);
            ft.commit();
        }




    }


}
