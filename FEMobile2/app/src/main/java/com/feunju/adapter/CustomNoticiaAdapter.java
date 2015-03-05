package com.feunju.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.feunju.R;
import com.feunju.json.Noticia;

import java.util.ArrayList;


/**
 * Created by David Garcia on 24/02/2015.
 */
public class CustomNoticiaAdapter extends ArrayAdapter<Noticia> {

    private ArrayList<Noticia> listData;
    private LayoutInflater layoutInflater;
    private java.util.logging.Logger logger;
    private String[] imageUrls;
    private Context myContext;



    public CustomNoticiaAdapter(Context context,ArrayList<Noticia> listData)
    {
         super(context,0,listData);
        int i=0;
        imageUrls=new String[listData.size()];
        for(Noticia noticia : listData)
        {
            imageUrls[i]=noticia.getNoticia_url_image();
            i++;
        }
        System.out.println("CustonNewsAdapter count : "+listData.size());
        this.listData=listData;


        layoutInflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return listData.size();
    }



    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        System.out.println("getView");

        if (convertView == null) {

            System.out.println("convertview null");
            //se obtiene
            convertView = layoutInflater.inflate(R.layout.noticia_single,null);
            holder = new ViewHolder();
            holder.noticiaHead = (TextView) convertView.findViewById(R.id.noticia_noticiaTitulo);
            holder.noticiaBajada = (TextView) convertView.findViewById(R.id.noticia_noticiaBajada);
            holder.noticiaImageView = (ImageView) convertView.findViewById(R.id.noticia_noticiaImage);
            holder.noticiaId=(TextView)convertView.findViewById(R.id.noticia_noticiaId);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Noticia noticia = (Noticia) listData.get(position);

        String titulo="";
        String bajada="";
        if(noticia.getNoticia_titulo().length()<=60)
            titulo=noticia.getNoticia_titulo();
        else
            titulo=noticia.getNoticia_titulo().substring(0, 60)+"...";

        if(noticia.getNoticia_bajada().length()<=60)
            bajada=noticia.getNoticia_bajada();
        else
            bajada=noticia.getNoticia_bajada().substring(0,60)+"...";


        holder.noticiaHead.setText(Html.fromHtml(titulo));
        holder.noticiaBajada.setText(Html.fromHtml(bajada));
        holder.noticiaId.setText(noticia.getNoticia_id());
        holder.noticiaId.setVisibility(View.GONE);



        //envio a cargar asyncTask la image
       /* if (holder.noticiaImageView != null) {

            imageLoader.displayImage(imageUrls[position], holder.noticiaImageView, options);

            //new ImageDownloaderTask(holder.noticiaImageView).execute(noticias.getUrlImageNoticia());
        }*/

        System.out.println("customlistnoticiaadapter");
        return convertView;
    }

    //representa
    static class ViewHolder {
        TextView noticiaHead;
        TextView noticiaBajada;
        TextView noticiaId;
        ImageView noticiaImageView;
    }
}
