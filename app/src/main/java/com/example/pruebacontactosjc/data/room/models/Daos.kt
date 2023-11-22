package com.example.pruebacontactosjc.data.room.models

import android.security.identity.AccessControlProfileId
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
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

@Dao
interface TiendaDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (tienda: Tienda)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(tienda: Tienda)

    @Delete
    suspend fun delete(tienda: Tienda)

    @Query("SELECT * FROM tiendas")
    fun getAllTiendas():Flow<List<Tienda>>

    @Query("SELECT * FROM tiendas WHERE tienda_id=:tiendaId")
    fun getTienda(tiendaId:Int):Flow<Tienda>
}

@Dao
interface ListaDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListaCompra(listaCompra: ListaCompra)

    @Query("""
       SELECT * FROM productos AS P INNER JOIN lista_compra AS LC 
        ON P.listaIdFk = LC.lista_id INNER JOIN tiendas AS T
        ON P.tiendaIdFk = T.tienda_id
    """)
    fun getProductosConTiendaYLista(listaId:Int):Flow<List<ProductosConTiendaYLista>>

    @Query("""
       SELECT * FROM productos AS P INNER JOIN lista_compra AS LC 
        ON P.listaIdFk = LC.lista_id INNER JOIN tiendas AS T
        ON P.tiendaIdFk = T.tienda_id WHERE P.producto_id = :productoId
    """)
    fun getProductoConTiendaYListaFiltradosPorId(productoId:Int):Flow<List<ProductosConTiendaYLista>>

    @Query("""
       SELECT * FROM productos AS P INNER JOIN lista_compra AS LC 
        ON P.listaIdFk = LC.lista_id INNER JOIN tiendas AS T
        ON P.tiendaIdFk = T.tienda_id WHERE LC.lista_id= :listaId
    """)
    fun getProductosConTiendaYListaFiltradosPorId(listaId:Int):Flow<List<ProductosConTiendaYLista>>
}

data class ProductosConTiendaYLista(
    @Embedded val producto:Producto,
    @Embedded val listaCompra: ListaCompra,
    @Embedded val tienda: Tienda
)