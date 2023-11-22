package com.example.pruebacontactosjc.data.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity (tableName = "lista_compra")
data class ListaCompra(
    @ColumnInfo(name = "lista_id") //Room database cambiará el nombre de esta variable para que sea más identificable
    @PrimaryKey val id:Int,
    val name:String
)

@Entity(tableName = "productos")
data class Producto(
    @ColumnInfo(name = "producto_id")
    @PrimaryKey(autoGenerate = true) //Las claves primarias se van a generar automáticamente
    val id:Int,
    val nombreProducto:String,
    val cantidad:Int,
    val listaIdFk:Int, //Foreign key del id de la tabla lista
    val tiendaIdFk:Int, //Foreign key del id de la tabla tienda
    val date:Date,
    val isChecked:Boolean
)

@Entity(tableName = "tiendas")
data class Tienda(
    @ColumnInfo(name = "tienda_id")
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val listaIdFk:Int //Foreign key del id de la tabla lista
)