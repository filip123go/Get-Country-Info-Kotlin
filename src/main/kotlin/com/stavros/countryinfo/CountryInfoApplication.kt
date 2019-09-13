package com.stavros.countryinfo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CountryInfoApplication

fun main(args: Array<String>) {
    runApplication<CountryInfoApplication>(*args)
}
