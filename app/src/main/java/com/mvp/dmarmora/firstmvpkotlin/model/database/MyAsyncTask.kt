package com.mvp.dmarmora.firstmvpkotlin.model.database

import android.os.AsyncTask
import android.widget.ProgressBar
import com.mvp.dmarmora.firstmvpkotlin.model.Utils
import com.mvp.dmarmora.firstmvpkotlin.view.MainActivity

class MyAsyncTask: AsyncTask<Any, Void, ProgressBar>() {
    override fun doInBackground(vararg params: Any?): ProgressBar {
        val listaPersonas = Utils().convertJsonToPerson(params[0] as String)
9
        for (persona in listaPersonas!!) MainActivity().myDataBase.personDao().insert(persona)
        return params[1] as ProgressBar
    }

    override fun onPostExecute(result: ProgressBar?) {
        result  !!.visibility = ProgressBar.GONE
    }

}