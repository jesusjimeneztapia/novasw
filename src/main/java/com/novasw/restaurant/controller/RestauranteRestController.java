package com.novasw.restaurant.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novasw.restaurant.domain.Restaurante;
import com.novasw.restaurant.exception.RestauranteNotFoundException;
import com.novasw.restaurant.request.RestauranteRegistration;
import com.novasw.restaurant.response.RestauranteResponse;
import com.novasw.restaurant.service.RestauranteService;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteRestController {

	private RestauranteService restauranteService;
	
	public RestauranteRestController(RestauranteService restauranteService) {
		this.restauranteService=restauranteService;
	}
	
	@GetMapping("/message")
	
	public String message() {
		return restauranteService.message();
		
	}
    @GetMapping("/findAll")
    public ResponseEntity<Iterable<RestauranteResponse>> findAll() {
        Iterable<RestauranteResponse> restaurantesResponse = restauranteService.findAll();
        return ResponseEntity.ok(restaurantesResponse);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<RestauranteResponse> findById(@PathVariable("id") int id) {
        RestauranteResponse restauranteResponse =restauranteService.findById(id);
        return ResponseEntity.ok(restauranteResponse);
    }

    
    @PostMapping("/save")
    public ResponseEntity<RestauranteResponse> save(@Valid @RequestBody final RestauranteRegistration restaurante) {

        RestauranteResponse persistedRestaurante = restauranteService.save(restaurante);
        return ResponseEntity.status(HttpStatus.CREATED).body(persistedRestaurante);
    }

    
    



}