package com.novasw.restaurant.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.novasw.restaurant.domain.Restaurante;
import com.novasw.restaurant.exception.RestauranteNotFoundException;
import com.novasw.restaurant.repository.RestauranteRepository;
import com.novasw.restaurant.request.RestauranteRegistration;
import com.novasw.restaurant.response.RestauranteResponse;

@Service
public class RestauranteService {
	
	private RestauranteRepository restauranteRepository;
	private ModelMapper modelMapper;

	public RestauranteService(RestauranteRepository restauranteRepository, ModelMapper modelMapper) {
		this.restauranteRepository = restauranteRepository;
		this.modelMapper = modelMapper;
	}
	
	public String message() {
		return  "Prueba Exitosa";
		
	}
	public  Iterable<RestauranteResponse>  findAll() {
		List<RestauranteResponse> restaurantes = restauranteRepository.findAll()
				.stream()
				.sorted(Comparator.comparing(Restaurante::getNombre))
				.map(restaurante -> {
					RestauranteResponse response = modelMapper.map(restaurante, RestauranteResponse.class);
					return response;
				})
				.collect(Collectors.toList());
        return restaurantes;
    }
	
	public RestauranteResponse findById(int id) {
		Restaurante restaurante = restauranteRepository.findById(id).orElse(null);
		if (restaurante == null) {
			String message = "El restaurante con ID=%s no fue encontrado";
			throw new RestauranteNotFoundException(String.format(message, id));
		}
		RestauranteResponse response = modelMapper.map(restaurante, RestauranteResponse.class);
        return response;
    }
	
	public RestauranteResponse save(RestauranteRegistration restauranteRequest) {
		Restaurante restaurante = modelMapper.map(restauranteRequest, Restaurante.class);
		
		restaurante = restauranteRepository.save(restaurante);
		RestauranteResponse response = modelMapper.map(restaurante, RestauranteResponse.class);
		
        return response;
    }
	
}