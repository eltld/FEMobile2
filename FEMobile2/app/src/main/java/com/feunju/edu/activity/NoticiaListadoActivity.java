package com.feunju.edu.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.FrameLayout;

import com.feunju.edu.R;
import com.feunju.edu.fragment.NoticiaDetalleFragment;
import com.feunju.edu.fragment.NoticiaListadoFragment;
import com.feunju.edu.json.Noticia;

/**
 * Created by David Garcia on 24/02/2015.
 */
public class NoticiaListadoActivity extends ActionBarActivity implements NoticiaListadoFragment.ListItemNoticiaFragmentItemClickListener {

    private boolean isTwoPane=false;
    private ProgressDialog pd;


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticia_listado_activity);
        //determinate layout
        determinatePanelLayout();

       getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public void onListFragmentItemClick(Noticia noticia) {
        if(isTwoPane)
        {
            // single activity with list and detail
            // Replace framelayout with new detail fragment
            NoticiaDetalleFragment fragmentItem = NoticiaDetalleFragment.newInstance(noticia);
            android.app.FragmentTransaction ft=getFragmentManager().beginTransaction();
            //reemplao el fragment container con el de noticia detalle
            ft.replace(R.id.flDetailContainer, fragmentItem);
            ft.commit();
        }else {
            Intent intent = new Intent(this, NoticiaDetalleActivity.class);
            intent.putExtra("noticia", noticia);
            startActivity(intent);
        }
    }

    private void determinatePanelLayout()
    {
        FrameLayout fragmentItemDetail = (FrameLayout) findViewById(R.id.flDetailContainer);
        // If there is a second pane for details
        if (fragmentItemDetail != null) {
            isTwoPane = true;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_main,menu);
        super.onCreateOptionsMenu(menu);

        return true;
    }
}



