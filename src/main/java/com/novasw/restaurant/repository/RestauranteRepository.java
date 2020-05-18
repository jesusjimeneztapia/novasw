package com.novasw.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novasw.restaurant.domain.Restaurante;

public interface RestauranteRepository  extends JpaRepository<Restaurante,Integer>{

}
