package com.yourtravel.controller;

import com.yourtravel.entity.City;
import com.yourtravel.entity.Country;
import com.yourtravel.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для работы с объектом {@link City}
 */
@RestController
public class CityController {

    private final CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * Получение города по идентификтору
     *
     * @param cityId идентификатор города
     * @return объект {@link City} или null
     */
    @GetMapping(value = "/city/{cityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public City findById(@PathVariable Long cityId){
        return cityRepository.findById(cityId).orElse(null);
    }

}
