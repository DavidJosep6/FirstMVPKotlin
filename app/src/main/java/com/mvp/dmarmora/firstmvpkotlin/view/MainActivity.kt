package com.mvp.dmarmora.firstmvpkotlin.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mvp.dmarmora.firstmvpkotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import android.arch.persistence.room.Room
import android.widget.ProgressBar
import com.mvp.dmarmora.firstmvpkotlin.model.database.MyAsyncTask
import com.mvp.dmarmora.firstmvpkotlin.model.database.PersonDataBase


//"https://randomuser.me/api/?results=2"

@Suppress("CAST_NEVER_SUCCEEDS")
class MainActivity : AppCompatActivity(){

    lateinit var myDataBase: PersonDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myDataBase = Room.databaseBuilder(this, PersonDataBase::class.java, "person-db").build()
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.pb_progressBar)

        b_actualizar.setOnClickListener {
            progressBar.visibility = ProgressBar.VISIBLE
            val url = "https://randomuser.me/api/?results=2"
            MyAsyncTask().execute(url, progressBar)
            /*doAsync {
                val listaUsuarios = Utils().convertJsonToPerson("https://randomuser.me/api/?results=2")
                var contador = 0
                if (listaUsuarios != null) {
                    while (contador<listaUsuarios.size){
          //              myDataBase.personDao().insert(listaUsuarios[contador])
                        contador++
                    }
                }
                progressBar.visibility = ProgressBar.INVISIBLE
            }*/
        }
    }



}
