package com.novasw.restaurant.service;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.novasw.restaurant.domain.Restaurante;
import com.novasw.restaurant.response.RestauranteResponse;

@Service
public class RestauranteService {

	public String message() {
		return  "Prueba Exitosa";
		
	}
	public  Iterable<RestauranteResponse>  findAll() {
        return null ;
    }
	
	public RestauranteResponse findById(String id) {
        return null;
    }
	public RestauranteResponse save(Restaurante restaurante) {
        return null;
    }
	
}