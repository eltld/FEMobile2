package com.feunju.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.feunju.R;
import com.feunju.adapter.CustomNoticiaAdapter;
import com.feunju.json.NoticiaTag;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Garcia on 24/02/2015.
 */
public class ActivityNoticia extends ActionBarActivity {

    private ProgressDialog pd;


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticia);
        //Creamos instancia de RequestQueue que solo recibe del contexto
        RequestQueue   queue= Volley.newRequestQueue(this);

        //String Url
         String IP_LOCAL="10.2.0.3";
         String URL_BASE="http://"+IP_LOCAL+"/php/";
         String URL_BASE_NOTICIAS="http://"+IP_LOCAL+"/noticias/imgnotis/";
         String URL_NOTICIAS=URL_BASE+"noticias.php";


        //Creamos una instancia de un ProgressDialog para que el usuario observe que los datos se estan obteniendo
        pd = new ProgressDialog(this);
        pd.setMessage("Please wait...");
        pd.setCancelable(false);
        //Configuramos nuestro request, al intanciar JsonArrayRequest recibe la URL y un Listener de JSON Array, el cual
        //contiene una serie de metodos a implelentar, practicamente si resulto bien o existio un error, ademas
        // sirve como un singleton para mandarlo a llamar cuando sea necesario hacer de nuevo el request.
        // Recordar que este solo construye el llamado HTTP, se ejecuta mas adelante cuando lo agregamos como parametro del metodo add
        //de RequestQueue
        pd.show();

        Log.e("ingreso","informacion");
        JsonArrayRequest req = new JsonArrayRequest(URL_NOTICIAS, new Response.Listener<JSONArray> () {

            @Override
            public void onResponse(JSONArray response) {

                //Un textview antes de la vista nos permite ver los datos crudos dentro de la misma app
                //TextView textView = (TextView) findViewById(R.id.datos_crudos);
                //textView.setText(response.toString());
                  //dejamos en el Log un pequeño mensaje con el response como string para ver un preview de lo que recibimos
                Log.e("respeusta", response.toString());

                Gson gson=new Gson();
                //toJson
              Type tipoListaNoticia = new TypeToken<List<NoticiaTag>>(){}.getType();

                ArrayList<NoticiaTag> listNoticia= gson.fromJson(response.toString(),tipoListaNoticia);

                System.out.println("listNoticia : "+listNoticia.size());

                //buscamos el listview de main_activity
                ListView list = (ListView) findViewById(R.id.custom_list_noticia);

                //Si vemos el CustomAdapter debemos pasar un contexto y un ArrayList de objetos Noticias
                //dicho ArrayList es parseao de la respuesta por medio de la funcion parser

                CustomNoticiaAdapter adapter;
                adapter = new CustomNoticiaAdapter(getApplicationContext(),listNoticia);
                //pasamos el adapter para que la lista se muestre en el UI
                System.out.println("adapter  :"+adapter + " list :"+list);
                list.setAdapter(adapter);

                pd.hide();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                pd.hide();

            }
        });

        // Ejecutamos Volley, con el request preparado
        queue.add(req);
    }




    }



