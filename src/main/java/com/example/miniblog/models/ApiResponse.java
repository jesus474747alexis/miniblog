package com.example.miniblog.models;
import java.util.Date;

public class ApiResponse {
	  private Date tiempo = new Date();
	    private String mensaje;
	    private String url;

	    public ApiResponse(String mensaje, String url) {
	        this.mensaje = mensaje;
	        this.url = url.replace("uri=","");
	    }
}