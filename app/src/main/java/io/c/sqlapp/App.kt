package io.c.sqlapp

import android.app.Application

class App : Application(){

    //Mise en place du Desing Singleton


    companion object{
        //Constante parce que companion
        lateinit var instance : App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}