package com.yourtravel.controller;

import com.yourtravel.entity.Country;
import com.yourtravel.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для работы с объектом {@link Country}
 */
@RestController
public class CountryController {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /**
     * Получение страны по идентификтору
     *
     * @param countryId идентификатор страны
     * @return объект {@link Country} или null
     */
    @GetMapping(value = "/country/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Country findById(@PathVariable Long countryId){
        return countryRepository.findById(countryId).orElse(null);
    }

}
