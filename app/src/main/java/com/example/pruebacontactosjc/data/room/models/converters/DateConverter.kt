package com.example.pruebacontactosjc.data.room.models.converters

import androidx.room.TypeConverter
import java.util.Date

open class DateConverter{
    @TypeConverter //Indicamos a Room que esta función va a convertir datos
    fun toDate(date: Long?): Date? { //Transformamos el long de entrada en un Date
        return date?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate (date: Date?): Long?{
        return date?.time
    }
}