package com.feunju.edu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.feunju.edu.activity.EventoListadoActivity;
import com.feunju.edu.activity.GalleryImageActivity;
import com.feunju.edu.activity.NoticiaListadoActivity;


public class MainActivity extends ActionBarActivity {

    private Button btn_noticia;
    private Button btn_evento;
    private Button btn_galeria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn_noticia=(Button) findViewById(R.id.btn_noticia);
         btn_evento=(Button)findViewById(R.id.btn_evento);
         btn_galeria=(Button)findViewById(R.id.btn_galeria);

      btn_galeria.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(MainActivity.this,GalleryImageActivity.class);
              startActivity(intent);
          }
      });

      btn_noticia.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent intent=new Intent(MainActivity.this,NoticiaListadoActivity.class);
              startActivity(intent);
          }
      });


     btn_evento.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             Intent intent=new Intent(MainActivity.this,EventoListadoActivity.class);
             startActivity(intent);
         }
     });


}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
