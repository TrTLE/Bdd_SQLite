package io.c.sqlapp.model

import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.db.insert

class CourseDb (private val dbHelper : CourseDbHelper = CourseDbHelper.instance) {

    //Création de la requête SQLite qui permet de récupérer une (Course)
    fun requestCourse() = dbHelper.use {
        select(MobileCouseTable.NAME, MobileCouseTable.TITLE, MobileCouseTable.TIME)
            .parseList(classParser<MobileCouseTable>())
    }

    fun insertCourse(course:mobileCourse) = dbHelper.use {
        insert(MobileCouseTable.NAME, MobileCouseTable.TITLE to course.title, MobileCouseTable.TIME to course.time)
    }
}