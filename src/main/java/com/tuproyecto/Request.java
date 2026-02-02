package com.tuproyecto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import io.github.cdimascio.dotenv.Dotenv;


public class Request {
  private static final Dotenv dotenv = Dotenv.load();
  private static final String API_KEY = dotenv.get("API_KEY");


  public static String execute(String valueOrigen, String valueDestino, double monto) throws Exception{
    String url = "https://v6.exchangerate-api.com/v6/"+ API_KEY +"/pair/"+ valueOrigen +  "/" + valueDestino + "/" + monto;
    
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create(url))
    .GET()
    .build();

    HttpResponse<String>  response = client.send(request, HttpResponse.BodyHandlers.ofString());
  
    if(response.statusCode() != 200){
      throw new RuntimeException("Error al conectar a la api: " + response.statusCode());
    }

    return response.body();
  } 
}
