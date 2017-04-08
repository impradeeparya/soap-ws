package com.soap.ws.repository;

import com.soap.ws.xjc.Country;
import com.soap.ws.xjc.Currency;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 17/2/17
 * Time: 9:28 PM
 */


public class CountryRepository {

    private Map<String, Country> countryMap = new HashMap<>();

    public void initData() {
        Country country = new Country();
        country.setName("INDIA");
        country.setCapital("Delhi");
        country.setCurrency(Currency.RUPEE);
        country.setPopulation(10);

        countryMap.put(country.getName(), country);

        country = new Country();
        country.setName("MALAYSIA");
        country.setCapital("Kuala Lumpur");
        country.setCurrency(Currency.RINGGIT);
        country.setPopulation(10);

        countryMap.put(country.getName(), country);
    }

    public Country findCountry(String countryName) {
        return countryMap.get(countryName.toUpperCase());
    }
}
