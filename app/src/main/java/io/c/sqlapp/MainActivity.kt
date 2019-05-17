package io.c.sqlapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.c.sqlapp.model.CourseDb
import io.c.sqlapp.model.CourseDbHelper
import io.c.sqlapp.model.MobileCouseTable
import io.c.sqlapp.model.mobileCourse
import org.jetbrains.anko.doAsync




//DOC MACHA

//                      https://www.chillcoding.com/blog/2018/01/17/creer-bdd-sqlite-kotlin-android/


class MainActivity : AppCompatActivity() {

    //Création de l'outil d'intérrogation de la BDD
    val courseDb by lazy { CourseDb(CourseDbHelper(applicationContext)) }


    val list = listOf<mobileCourse>()


    companion object{

        //nom dynamique de la Classe MainACtivity
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doAsync {

            //insérer un course dans la BDD

            //Quelle type de MobileCourse utiliser ... ????
            //      MobileCourseTable    ou    mobileCourse ...???????
            courseDb.insertCourse(mobileCourse("SQLite Data Base", 60))
        }
    }


    override fun onResume() {
        super.onResume()

        doAsync {

            //dojvzeoij
            showList()

        }
    }

    fun showList(){
        Log.i(TAG, "UN ELT : ${list}")
    }
}
