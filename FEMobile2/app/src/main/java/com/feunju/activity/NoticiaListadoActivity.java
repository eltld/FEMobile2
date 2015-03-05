package com.feunju.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.FrameLayout;

import com.feunju.R;
import com.feunju.fragment.NoticiaDetalleFragment;
import com.feunju.fragment.NoticiaListadoFragment;
import com.feunju.json.Noticia;

/**
 * Created by David Garcia on 24/02/2015.
 */
public class NoticiaListadoActivity extends FragmentActivity implements NoticiaListadoFragment.ListItemNoticiaFragmentItemClickListener {

    private boolean isTwoPane=false;
    private ProgressDialog pd;


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticia_listado_activity);
        //determinate layout
        determinatePanelLayout();


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



