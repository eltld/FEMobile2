package com.feunju.edu.constant;

/**
 * Created by dgarcia on 10/03/2015.
 * Contiene las constantes Rest de los
 * servicios JSON
 */

public abstract  class ConstantRest {


    //private final static String URL_NOTICIAS="http://10.2.2.245/WebRest/noticias.json.txt";
    //public final static String URL_NOTICIAS="http://10.2.2.245/projects/www/noticias.php";
    //public final static String URL_IMAGES="http://10.2.2.245/WebRest//fotos.php";
    //ip 170.210.240.251 - 10.2.0.66
    //10.2.0.66
    public final static String IP_LOCAL="10.2.0.3";
    public final static String IP_REMOTE="200.45.224.18";
    public final static String URL_BASE="http://"+IP_LOCAL+"/php/";
    public final static String URL_BASE_NOTICIAS="http://"+IP_LOCAL+"/noticias/imgnotis/";
    public final static String  URL_WEB="http://www.unju.edu.ar";
    public final static String URL_NOTICIAS=URL_BASE+"noticias.php";
    public final static String URL_AUTORIDADES=URL_BASE+"autoridad.php";
    public final static String URL_IMAGES=URL_BASE+"fotos.php";
    public final static String URL_EVENTO=URL_BASE+"evento.php";
    public final static String URL_CONTACTO=URL_BASE+"contacto.php";
    //IMAGES
    public final static String URL_IMAGE_UNJU="http://manuonda.netau.net/unju.jpg";

    //Connection
    public final static String CONNECTION_ERROR="Verifique conexion de Internet";


    //Version file
    public final static String URL_VERSION_FILE=URL_BASE+"versionInfo.php";
    public final static String URL_APK_FILE=URL_BASE+"UnjuMobile.apk";
    public final static String URL_APK_PLAY="market://details?id=com.feunju";

}