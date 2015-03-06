package com.feunju.edu.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.feunju.edu.R;
import com.feunju.edu.json.Noticia;
import com.feunju.edu.singleton.SingletonVolley;

import java.util.ArrayList;


/**
 * Created by David Garcia on 24/02/2015.
 */
public class CustomNoticiaAdapter extends ArrayAdapter<Noticia> {

    private ArrayList<Noticia> listData;
    private LayoutInflater layoutInflater;
    private java.util.logging.Logger logger;
    private String[] imageUrls;
    ImageLoader imageLoader;
    NetworkImageView networkImageView;




    public CustomNoticiaAdapter(Context context,ArrayList<Noticia> listData)
    {


        super(context,0,listData);
        int i=0;
        imageUrls=new String[listData.size()];
        String IP_LOCAL="10.2.0.3";
        String URL_BASE_NOTICIAS="http://"+IP_LOCAL+"/noticias/imgnotis/";
        String tmp="";

        for(Noticia noticia : listData)
        {
            tmp=noticia.getNoticia_url_image();
            imageUrls[i]=URL_BASE_NOTICIAS+tmp.replace("./imgnotis/","");
            i++;
        }
        System.out.println("CustonNewsAdapter count : "+listData.size());
        this.listData=listData;

        //singleton instance
        imageLoader= SingletonVolley.getInstance(getContext()).getImageLoader(); //singleton imageLoader

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


            if(imageLoader==null)
                imageLoader= SingletonVolley.getInstance(getContext()).getImageLoader(); //singleton imageLoader


            holder = new ViewHolder();
            holder.noticiaImageView=(NetworkImageView) convertView.findViewById(R.id.noticia_noticiaImage);
            holder.noticiaHead = (TextView) convertView.findViewById(R.id.noticia_noticiaTitulo);
            holder.noticiaBajada = (TextView) convertView.findViewById(R.id.noticia_noticiaBajada);
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

        System.out.println("url "+imageUrls[position]);
        //load image
        holder.noticiaImageView.setDefaultImageResId(R.drawable.ic_launcher);
        holder.noticiaImageView.setErrorImageResId(R.drawable.ic_launcher);
        holder.noticiaImageView.setAdjustViewBounds(true);
        holder.noticiaImageView.setImageUrl(imageUrls[position], imageLoader);


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
        NetworkImageView noticiaImageView;

    }
}
