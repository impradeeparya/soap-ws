package com.soap.repository;

import io.spring.soap.ws.Country;
import io.spring.soap.ws.Currency;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 17/2/17
 * Time: 9:28 PM
 */

@Repository
public class CountryRepository {

    private Map<String, Country> countryMap = new HashMap<>();


    @PostConstruct
    public void initData() {
        Country country = new Country();
        country.setName("India");
        country.setCapital("Delhi");
        country.setCurrency(Currency.RUPEE);
        country.setPopulation(10);

        countryMap.put(country.getName(), country);

        country = new Country();
        country.setName("Malaysia");
        country.setCapital("Kuala Lumpur");
        country.setCurrency(Currency.RINGGIT);
        country.setPopulation(10);

        countryMap.put(country.getName(), country);
    }

    public Country findCountry(String countryName) {
        return countryMap.get(countryName);
    }
}
