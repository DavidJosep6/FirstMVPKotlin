package com.mvp.dmarmora.firstmvpkotlin.model

import com.mvp.dmarmora.firstmvpkotlin.model.database.PersonEntity
import org.json.JSONObject
import java.net.URL

class Utils {

    fun convertJsonToPerson(urlJson: String): ArrayList<PersonEntity>? {
        var listPerson: ArrayList<PersonEntity>? = ArrayList()
        //Obtener el objeto completo
        val jsonString = URL(urlJson).readText()
        val jsonObject = JSONObject(jsonString)
        //Obtener resultados
        val results = jsonObject.getJSONArray("results")
        var contador = 0
        while (contador<results.length()){
            //Obtener objeto Persona
            val personJson = results.getJSONObject(contador)
            //Obtener atributo email
            val emailPerson = personJson.get("email") as String
            //Obtener atributo nombre
            val nameJson = personJson.getJSONObject("name")
            val namePerson = "${nameJson.get("title")} ${nameJson.get("first")} ${nameJson.get("last")}"
            //Obtener atributo foto
            val photoJson = personJson.getJSONObject("picture")
            val photoPerson = photoJson.get("medium") as String
            //Obtener atributo localizacion
            val locationJson =  personJson.getJSONObject("location")
            val locationPerson =  "${locationJson.get("street")}, ${locationJson.get("city")}, ${locationJson.get("state")}, ${locationJson.get("postcode")}"
            listPerson!!.add(PersonEntity(email = emailPerson, name = namePerson, photo = photoPerson, location = locationPerson))
            contador++
        }
        return listPerson
    }
}