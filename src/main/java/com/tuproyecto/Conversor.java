package com.tuproyecto;
import java.util.Map;

import com.google.gson.Gson;

import java.util.HashMap;

public class Conversor {
  int monedaOrigen;
  int monedaDestino;
  double monto;
  public String result;
  public double conversion_result;

  Map<Integer, String> opcionesMoneda;
  
  public Conversor() {
    opcionesMoneda = new HashMap<>();
      opcionesMoneda.put(1, "USD");
      opcionesMoneda.put(2, "ARS");
      opcionesMoneda.put(3, "EUR");
      opcionesMoneda.put(4, "BRL");
      opcionesMoneda.put(5, "MXN");
    }


  public String convertir(int monedaOrigen, int monedaDestino, double monto) throws Exception{



    if(!opcionesMoneda.containsKey(monedaOrigen) || !opcionesMoneda.containsKey(monedaDestino)){
      throw new RuntimeException("Opcion de moneda no valida");
    }
    
    if(monedaOrigen == monedaDestino){
      throw new RuntimeException("Las monedas no pueden ser iguales");
    }
    
    String valueOrigen = opcionesMoneda.get(monedaOrigen);
    String valueDestino = opcionesMoneda.get(monedaDestino);

    String result = Request.execute(valueOrigen, valueDestino, monto);

    Gson gson = new Gson();
    
    RespuestaConversion datos = gson.fromJson(result, RespuestaConversion.class);

    String mensajeFinal = ("La conversion de " + monto + valueOrigen + " a " + valueDestino + " es " + datos.conversion_result + valueDestino);

    return mensajeFinal;
  }
}
