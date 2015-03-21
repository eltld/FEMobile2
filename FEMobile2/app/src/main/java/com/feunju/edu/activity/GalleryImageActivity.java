package com.feunju.edu.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.feunju.edu.R;
import com.feunju.edu.adapter.CustomGalleryImageAdapter;
import com.feunju.edu.constant.ConstantRest;
import com.feunju.edu.json.GalleryImage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Garcia on 19/03/2015.
 */
public class GalleryImageActivity extends ActionBarActivity{

    private ProgressDialog pd;
    private CustomGalleryImageAdapter adapter;
    ArrayList<GalleryImage> listData;
    private GridView gridGalleryImage;
    DisplayImageOptions options;
    protected ImageLoader imageLoader;

    public GalleryImageActivity() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_image);

        gridGalleryImage=(GridView)findViewById(R.id.galleryImage);
        //configuration image loader
        listData=new ArrayList<GalleryImage>();


        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_launcher)
                .showImageForEmptyUri(R.drawable.ic_launcher)
                .showImageOnFail(R.drawable.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(50 * 1024 * 1024) // 50 Mb
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
        imageLoader=ImageLoader.getInstance();

        RequestQueue queue= Volley.newRequestQueue(this);



        //Creamos una instancia de un ProgressDialog para que el usuario observe que los datos se estan obteniendo
        pd = new ProgressDialog(this);
        pd.setMessage("Espere cargando...");
        pd.setCancelable(false);
        //Configuramos nuestro request, al intanciar JsonArrayRequest recibe la URL y un Listener de JSON Array, el cual
        //contiene una serie de metodos a implelentar, practicamente si resulto bien o existio un error, ademas
        // sirve como un singleton para mandarlo a llamar cuando sea necesario hacer de nuevo el request.
        // Recordar que este solo construye el llamado HTTP, se ejecuta mas adelante cuando lo agregamos como parametro del metodo add
        //de RequestQueue

        pd.show();

        Log.e("ingreso", "informacion");
        JsonArrayRequest req = new JsonArrayRequest(ConstantRest.URL_IMAGES, new Response.Listener<JSONArray> () {

            @Override
            public void onResponse(JSONArray response) {
                hidePDialog();

                //Un textview antes de la vista nos permite ver los datos crudos dentro de la misma app
                //TextView textView = (TextView) findViewById(R.id.datos_crudos);
                //textView.setText(response.toString());
                //dejamos en el Log un pequeño mensaje con el response como string para ver un preview de lo que recibimos
                Log.e("respeusta", response.toString());

                Gson gson=new Gson();
                //toJson
                Type tipoListGaleria = new TypeToken<List<GalleryImage>>(){}.getType();

                listData = gson.fromJson(response.toString(),tipoListGaleria);

                System.out.println("listData "+listData.size());
                for(int i=0;i<listData.size();i++)
                {
                    System.out.println(" info : "+listData.get(i).getGALERIA_URL());
                }

                //Si vemos el CustomAdapter debemos pasar un contexto y un ArrayList de objetos Noticias
                //dicho ArrayList es parseao de la respuesta por medio de la funcion parser
                System.out.println("listDataNoticia : "+listData.size());

                adapter = new CustomGalleryImageAdapter(GalleryImageActivity.this,imageLoader,options,listData);
                //pasamos el adapter para que la lista se muestre en el UI
                //setListAdapter(adapter);
                System.out.println("gridGalleryImage : "+gridGalleryImage + " adapter : "+adapter);
                gridGalleryImage.setAdapter(adapter);

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

     //gridGalleryImage.setAdapter(adapter);


    }


    private void hidePDialog() {
        if (pd != null) {
            pd.hide();
            pd = null;
        }
    }

    /*private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                AppConstant.GRID_PADDING, r.getDisplayMetrics());

        columnWidth = (int) ((utils.getScreenWidth() - ((AppConstant.NUM_OF_COLUMNS + 1) * padding)) / AppConstant.NUM_OF_COLUMNS);

        gridView.setNumColumns(AppConstant.NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding((int) padding, (int) padding, (int) padding,
                (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }*/


}
