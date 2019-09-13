package com.stavros.countryinfo.httpRequests

import com.google.gson.GsonBuilder
import com.stavros.countryinfo.model.CountryReturnedModel
import okhttp3.*
import org.springframework.stereotype.Component
import java.io.IOException

var responseJson: Array<CountryReturnedModel?>? = null

val baseUrl = "https://restcountries-v1.p.rapidapi.com/"

@Component
class CountryRequest {

    fun fetchCurrentCountry(countryName: String): Array<CountryReturnedModel?>? {
        val url = baseUrl+countryName

        val request = Request.Builder()
                .addHeader("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "f7c952bedfmsh155a47f836bd456p167e87jsn9c611ae79742")
                .url(url)
                .get()
                .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {
                var body = response.body?.string()

                val gson = GsonBuilder().create()
                responseJson = gson.fromJson(body, Array<CountryReturnedModel?>::class.java)
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
        Thread.sleep(1000)
        return responseJson
    }
}