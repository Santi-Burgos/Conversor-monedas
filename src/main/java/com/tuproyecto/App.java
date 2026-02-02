package com.tuproyecto;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ){
      int iniciador = 1;
      Conversor conversor = new Conversor();
      
      Scanner lectura = new Scanner(System.in);

      while(iniciador != 0){
        System.out.println("----------------------------------");
        System.out.println("Monedas");
        System.out.println("1. USD - Dolar" );
        System.out.println("2. ARS - Peso argentino");
        System.out.println("3. EUR - Euro");
        System.out.println("4. BRL - Real");
        System.out.println("5. MXN - Peso mexicano");
        System.out.println("0. Salir");
        System.out.println("----------------------------------");

        try{
          System.out.println("Elija la moneda de origen");
          int origen = lectura.nextInt();
          if(origen == 0) break;

          System.out.println("Elija la moneda de destino");
          int destino = lectura.nextInt();
          if(destino == 0) break;

          System.out.println("Elija el monto para hacer el cambio");
          double monto = lectura.nextInt();
          if(monto == 0) break;

          String resultado = conversor.convertir(origen, destino, monto);
          System.out.println(resultado);
        }catch(Exception e){
          System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
      }
      System.out.println("...Saliendo del conversor");
      lectura.close();
    }
}
