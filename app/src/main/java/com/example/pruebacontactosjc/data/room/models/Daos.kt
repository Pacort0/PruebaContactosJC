package com.example.pruebacontactosjc.data.room.models

import android.security.identity.AccessControlProfileId
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (producto: Producto)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(producto: Producto)

    @Delete
    suspend fun delete(producto: Producto)

    @Query("SELECT * FROM productos")
    fun getAllProductos():Flow<List<Producto>>

    @Query("SELECT * FROM productos WHERE producto_id=:productoId")
    fun getItem(productoId:Int):Flow<Producto>
}