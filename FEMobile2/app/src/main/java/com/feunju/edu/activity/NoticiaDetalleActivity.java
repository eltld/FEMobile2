package com.feunju.edu.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;

import com.feunju.edu.R;
import com.feunju.edu.fragment.NoticiaDetalleFragment;
import com.feunju.edu.json.Noticia;

/**
 * Created by MITO on 02/03/2015.
 */
public class NoticiaDetalleActivity extends ActionBarActivity {

   //obtengo un Fragment de Detalle
    NoticiaDetalleFragment noticiaDetalleFragment;

     //shared provider
    private ShareActionProvider shareActionProvider;


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

            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_provider, menu);

        //Handle share menu item
        MenuItem shareItem = menu.findItem(R.id.menu_item_share);
        shareActionProvider = (ShareActionProvider)
                MenuItemCompat.getActionProvider(shareItem);
        //Creamos nuevo share intent
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT,"MENSAJE DE PRUEBA");
        shareActionProvider.setShareIntent(i);
        System.out.println("onCreateOptionmenu");

        return true;
    }
}
