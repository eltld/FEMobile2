package com.feunju.edu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.feunju.edu.R;
import com.feunju.edu.json.Evento;
import com.feunju.edu.util.Util;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.ArrayList;

/**
 * Created by David Garcia on 09/03/2015.
 */
public class CustomEventoAdapter  extends ArrayAdapter<Evento> {

    private ArrayList<Evento> listData;
    private LayoutInflater layoutInflater;
    private java.util.logging.Logger logger;
    private ImageLoader imageLoader;
    private String[] imageUrls;
    private Context myContext;
    private DisplayImageOptions options;




    public CustomEventoAdapter(Context context,ArrayList<Evento> listData)
    {
        super(context,0,listData);

        System.out.println("CustonEventoAdapter count : "+listData.size());
        this.listData=listData;

        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return this.listData.size();
    }



    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        System.out.println("getView");

        if (convertView == null) {

            System.out.println("convertview null");
            //se obtiene
            convertView = layoutInflater.inflate(R.layout.evento_single,null);
            holder = new ViewHolder();
            holder.eventoDia=(TextView) convertView.findViewById(R.id.evento_eventoDia);
            holder.eventoMes = (TextView) convertView.findViewById(R.id.evento_eventoMes);
            holder.eventoVolanta= (TextView) convertView.findViewById(R.id.evento_eventoVolanta);
            holder.eventoTitulo=(TextView)convertView.findViewById(R.id.evento_eventoTitulo);
             convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Evento evento = (Evento) listData.get(position);

        String fechaEvento=evento.getEvento_fecha();
        String[] parts = fechaEvento.split("\\-");
        System.out.println("fechaEvent : "+fechaEvento);
        String year= parts[0];
        //Obtengo mes
        String mes= Util.getMes(Integer.parseInt(parts[1]));
        String dia= parts[2];
        System.out.println("year : "+year + " mes :"+mes + " dia : "+dia);

        String titulo="";

        if(evento.getEvento_titulo().length()<=60)
            titulo=evento.getEvento_titulo();
        else
            titulo=evento.getEvento_titulo().substring(0, 60)+"...";

        holder.eventoTitulo.setText(titulo);
        holder.eventoVolanta.setText("volanta");
        holder.eventoMes.setText(mes);
        holder.eventoDia.setText(dia);
        //holder.eventoDetalle.setText(evento.getFechaEvento()+ " - "+ evento.getHorarioEvento());
        /*holder.eventoId.setText(evento.getIdEvento());
        holder.eventoId.setVisibility(View.GONE);
       */



        return convertView;
    }

    static class ViewHolder {
        TextView eventoMes;
        TextView eventoDia;
        TextView eventoTitulo;
        TextView eventoVolanta;

    }
}
