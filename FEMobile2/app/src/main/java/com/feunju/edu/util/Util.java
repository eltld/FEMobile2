package com.feunju.edu.util;

/**
 * Created by MITO on 19/03/2015.
 */
public final class Util {



  public static String getMes(int mes)
  {
      if(mes==01)
          return "ENE";
      else if(mes==02)
          return "FEB";
      else if(mes==03)
          return "MAR";
      else if(mes==04)
          return "ABR";
      else if(mes==05)
          return "MAY";
      else if(mes==06)
          return "JUN";
      else if(mes==07)
          return "JUL";
      else if(mes==8)
          return "AGO";
      else if(mes==9)
          return "SET";
      else if(mes==10)
          return "OCT";
      else if(mes==11)
          return "NOV";
      else if(mes==12)
          return "DIC";


      return null;

  }

}
