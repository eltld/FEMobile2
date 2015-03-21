package com.feunju.edu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.feunju.edu.R;
import com.feunju.edu.json.Evento;


public class EventoDetalleFragment extends Fragment {

    private Evento evento;
    private TextView text_noticiaTitulo;
    private TextView text_noticiaBajada;
    private TextView text_noticiaFecha;
    private TextView text_noticiaCuerpo;
    private ImageView image_noticia;
    private TextView textHeader;
    private TextView text_cuerpo;
    private TextView text_viewEx;
    static float density;
    public static final int FinallwidthDp  = 320 ;
    public static final int widthJustify  = 223 ;
    final String[] choices = { "Android", "iOS", "RIM" };
    private ImageView image_facebook;


    public static EventoDetalleFragment newInstance(Evento evento)
    {
        EventoDetalleFragment eventoDetalleFragment=new EventoDetalleFragment();
        Bundle args=new Bundle();
        args.putSerializable("evento",evento);
        eventoDetalleFragment.setArguments(args);
        return eventoDetalleFragment;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        evento=new Evento();
        evento=(Evento)getArguments().getSerializable("evento");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.noticia_detalle_fragment, container, false);


        text_noticiaTitulo=(TextView)view.findViewById(R.id.text_noticiaContentTitulo);
        text_noticiaBajada=(TextView)view.findViewById(R.id.text_noticiaContentBajada);
        text_noticiaFecha=(TextView)view.findViewById(R.id.text_noticiaContentFecha);
        text_viewEx=(TextView)view.findViewById(R.id.text_noticiaContentCuerpo);
        image_noticia=(ImageView)view.findViewById(R.id.image_noticiaContentImage);
        //textHeader=(TextView)findViewById(R.id.text_newsHeader);


        //asigno los valores

         /*
            text_noticiaTitulo.setText(Html.fromHtml(noticia.getNoticia_titulo()));
            text_noticiaBajada.setText(Html.fromHtml(noticia.getNoticia_bajada()));
            text_noticiaFecha.setText(Html.fromHtml(noticia.getNoticia_fecha()));

         */
        return view;
    }



}
