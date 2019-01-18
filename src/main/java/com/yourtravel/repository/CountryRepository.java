package com.yourtravel.repository;

import com.yourtravel.entity.City;
import com.yourtravel.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
