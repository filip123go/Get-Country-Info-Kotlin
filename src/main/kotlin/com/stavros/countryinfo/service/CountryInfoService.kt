package com.stavros.countryinfo.service

import com.stavros.countryinfo.httpRequests.CountryRequest
import com.stavros.countryinfo.model.CountryReturnedModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/countryInfo")
class CountryInfoService {

    @GetMapping("/{countryName}")
    fun getCountryByName(@PathVariable countryName: String): Array<CountryReturnedModel?>? {
        return CountryRequest().fetchCurrentCountry("name/$countryName")
    }

    @GetMapping("/all")
    fun getAllCountries(): Array<CountryReturnedModel?>? {
        return CountryRequest().fetchCurrentCountry("all")
    }

    @GetMapping("code/{countryCode}")
    fun getCountryByCode(@PathVariable countryCode: String): Array<CountryReturnedModel?>? {
        return CountryRequest().fetchCurrentCountry("alpha/?codes=$countryCode")
    }

    @GetMapping("capital/{countryCapital}")
    fun getCountryByCapital(@PathVariable countryCapital: String): Array<CountryReturnedModel?>? {
        return CountryRequest().fetchCurrentCountry("capital/$countryCapital")
    }

    @GetMapping("currency/{currency}")
    fun getCountryByCurrency(@PathVariable currency: String): Array<CountryReturnedModel?>? {
        return CountryRequest().fetchCurrentCountry("currency/$currency")
    }

    @GetMapping("language/{language}")
    fun getCountryByLanguage(@PathVariable language: String): Array<CountryReturnedModel?>? {
        return CountryRequest().fetchCurrentCountry("lang/$language")
    }
}