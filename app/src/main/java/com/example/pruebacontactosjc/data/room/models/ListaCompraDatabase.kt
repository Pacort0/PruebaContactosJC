package com.example.pruebacontactosjc.data.room.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ListaCompra::class, Producto::class, Tienda::class],
    version = 1)
abstract class ListaCompraDatabase: RoomDatabase() {
    abstract fun listaDao():ListaDao
    abstract fun productoDao():ProductoDao
    abstract fun tiendaDao():TiendaDao

    companion object{
        @Volatile
        var INSTANCE:ListaCompraDatabase? = null
        fun getDatabase(context: Context):ListaCompraDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    ListaCompraDatabase::class.java,
                    "compra_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}