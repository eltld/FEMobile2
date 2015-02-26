package com.feunju.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.feunju.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NoticiaDetalleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NoticiaDetalleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */



public class NoticiaDetalleFragment extends Fragment {

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



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoticiaDetalleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoticiaDetalleFragment newInstance(String param1, String param2) {
        NoticiaDetalleFragment fragment = new NoticiaDetalleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public NoticiaDetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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


            text_noticiaTitulo.setText(Html.fromHtml("INSCRIPCI\\u00d3N PARA BECAS 2015"));
            text_noticiaBajada.setText(Html.fromHtml("Se trata de los programas nacionales de becas Bicentenario y Universitarias"));
            text_noticiaFecha.setText(Html.fromHtml("2015-03-02"));


            /*String text_content=
                    "<html><head></head><body style='text-align:justify;'>"+
                            noticia.getCuerpoNoticia()+
                            " </body></html>";
              */

            //text_cuerpo.setText(text);
            //text_viewEx.setText(Html.fromHtml(text_content));

            //logger.debug("noticia url : "+noticia.getUrlImageNoticia());



            /*Ion.with(getApplicationContext())
                    .load(noticia.getUrlImageNoticia())
                    .withBitmap()
                    .resizeHeight(100)
                    .resizeWidth(250)
                    .placeholder(R.drawable.ic_launcher)
                    .error(R.drawable.ic_error)
                    .intoImageView(image_noticia);

           */




        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
