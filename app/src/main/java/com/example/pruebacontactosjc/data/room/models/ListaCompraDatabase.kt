package com.example.pruebacontactosjc.data.room.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pruebacontactosjc.data.room.models.converters.DateConverter

@TypeConverters(value = arrayOf(DateConverter::class)) //En plural, ya que vamos a pasar varios converters
@Database(entities = [ListaCompra::class, Producto::class, Tienda::class],
    version = 1, exportSchema = false)
abstract class ListaCompraDatabase: RoomDatabase() {
    abstract fun listaDao():ListaDao
    abstract fun productoDao():ProductoDao
    abstract fun tiendaDao():TiendaDao

    companion object{ //Companion object que nos permitirá crear instancias de la clase sin instanciarla
        @Volatile //Para manejarlo de forma segura en los threads
        var INSTANCE:ListaCompraDatabase? = null
        fun getDatabase(context: Context):ListaCompraDatabase{ //Método que va a recoger la base de datos
            return INSTANCE?: synchronized(this){ //Devuelve una base de datos, pero si es null, creará una nueva base de datos.
                //Synchronized va a asegurar que un sólo thread de va a encargar de hacer esto
                val instance = Room.databaseBuilder( //Creamos una nueva instancia dentro de la función y construimos una nueva database
                    context,
                    ListaCompraDatabase::class.java,
                    "compra_db"
                ).build()
                INSTANCE = instance //Instance ya no es null
                return instance
            }
        }
    }
}