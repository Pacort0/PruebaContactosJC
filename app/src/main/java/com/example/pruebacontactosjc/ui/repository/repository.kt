package com.example.pruebacontactosjc.ui.repository

import com.example.pruebacontactosjc.data.room.models.ListaCompra
import com.example.pruebacontactosjc.data.room.models.ListaDao
import com.example.pruebacontactosjc.data.room.models.Producto
import com.example.pruebacontactosjc.data.room.models.ProductoDao
import com.example.pruebacontactosjc.data.room.models.Tienda
import com.example.pruebacontactosjc.data.room.models.TiendaDao

class repository (
    private val listaDao: ListaDao,
    private val productoDao: ProductoDao,
    private val tiendaDao: TiendaDao,
) {
    val tienda = tiendaDao.getAllTiendas()
    val getProductosConTiendaYLista = listaDao.getProductosConTiendaYLista()

    fun getProductoConTiendaYListaFiltradosPorId(id:Int) = listaDao.getProductoConTiendaYListaFiltradosPorId(id)
    suspend fun insertaLista(listaCompra: ListaCompra){
        listaDao.insertListaCompra(listaCompra)
    }

    suspend fun insertaTienda(tienda:Tienda){
        tiendaDao.insert(tienda)
    }

    suspend fun insertaProducto(producto: Producto){
        productoDao.insert(producto)
    }

    suspend fun eliminaProducto(producto: Producto){
        productoDao.delete(producto)
    }

    suspend fun actualizaProducto(producto: Producto){
        productoDao.update(producto)
    }
}