package io.c.sqlapp.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import io.c.sqlapp.App
import org.jetbrains.anko.db.*


//null !!!! type de DBB que l'on créé
class CourseDbHelper (ctx : Context  = App.instance) : ManagedSQLiteOpenHelper (ctx, DB_NAME, null, DB_VERSION){

    companion object {
        val DB_NAME = "course.db"
        val DB_VERSION = 1
        //Mise en place du Desing Singleton
        val instance by lazy { CourseDbHelper() }
    }

    //Création de la table dans la BDD ou
    //                              Table  ???
    //!!!!!! enlever le ? sur le premier paramtère !!!!
    override fun onCreate(db: SQLiteDatabase) {

        //true si ç n'existe pas
        //Utiliser le type INTERGER de ANKO

        //ID PRimarary KEY
        db.createTable(MobileCouseTable.NAME, true,
            MobileCouseTable.ID to INTEGER + PRIMARY_KEY,
            MobileCouseTable.TITLE to TEXT,
            MobileCouseTable.TITLE to INTEGER)
    }

    //!!!!!! enlever le ? sur le premier paramtère !!!!
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //qsfqs
        db.dropTable(MobileCouseTable.NAME)
        onCreate(db)
    }
}