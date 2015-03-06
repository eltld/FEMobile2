package com.feunju.edu.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.feunju.edu.R;
import com.feunju.edu.adapter.CustomNoticiaAdapter;
import com.feunju.edu.json.Noticia;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class NoticiaListadoFragment extends ListFragment {


    ListItemNoticiaFragmentItemClickListener  ifaceItemClickListener;
    /**interface para definir el callback del metodo**/
    public interface ListItemNoticiaFragmentItemClickListener
    {  /** This method will be invoked when an item in the ListFragment is clicked */
    void onListFragmentItemClick(Noticia noticia);
    }


    private Button btn_noticia;
    private ProgressDialog pd;
    ArrayList<Noticia> listDataNoticia;
    ListView listView;
    CustomNoticiaAdapter adapter;
    public NoticiaListadoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Creamos instancia de RequestQueue que solo recibe del contexto
       final View view= inflater.inflate(R.layout.noticia_listado_fragment, container, false);


        RequestQueue queue= Volley.newRequestQueue(getActivity());

        //String Url
        String IP_LOCAL="10.2.0.3";
        String IP_REMOTE="200.45.224.18";
        String URL_BASE="http://"+IP_LOCAL+"/php/";
        String URL_NOTICIAS=URL_BASE+"noticias.php";



        //Creamos una instancia de un ProgressDialog para que el usuario observe que los datos se estan obteniendo
        pd = new ProgressDialog(getActivity());
        pd.setMessage("Espere cargando...");
        pd.setCancelable(false);
        //Configuramos nuestro request, al intanciar JsonArrayRequest recibe la URL y un Listener de JSON Array, el cual
        //contiene una serie de metodos a implelentar, practicamente si resulto bien o existio un error, ademas
        // sirve como un singleton para mandarlo a llamar cuando sea necesario hacer de nuevo el request.
        // Recordar que este solo construye el llamado HTTP, se ejecuta mas adelante cuando lo agregamos como parametro del metodo add
        //de RequestQueue

        pd.show();

        Log.e("ingreso", "informacion");
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
                Type tipoListaNoticia = new TypeToken<List<Noticia>>(){}.getType();

                listDataNoticia = gson.fromJson(response.toString(),tipoListaNoticia);

                System.out.println("listData "+listDataNoticia.size());

                //Si vemos el CustomAdapter debemos pasar un contexto y un ArrayList de objetos Noticias
                //dicho ArrayList es parseao de la respuesta por medio de la funcion parser
                System.out.println("listDataNoticia : "+listDataNoticia.size());

                adapter = new CustomNoticiaAdapter(view.getContext(), listDataNoticia);
                //pasamos el adapter para que la lista se muestre en el UI
                //setListAdapter(adapter);

                setListAdapter(adapter);
               //oculto el progress bar
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


        setHasOptionsMenu(true);
        return view;
    }

    /** A callback function, executed when this fragment is attached to an activity */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            /** This statement ensures that the hosting activity implements ListFragmentItemClickListener */
            ifaceItemClickListener = (ListItemNoticiaFragmentItemClickListener) activity;
        }catch(Exception e){
            Toast.makeText(activity.getBaseContext(), "Exception", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       System.out.println("onListItemClick noticia : "+position);
        System.out.println("adapter : "+adapter);
       Noticia noticia= (Noticia) adapter.getItem(position);
       ifaceItemClickListener.onListFragmentItemClick(noticia);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       // inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }
}
