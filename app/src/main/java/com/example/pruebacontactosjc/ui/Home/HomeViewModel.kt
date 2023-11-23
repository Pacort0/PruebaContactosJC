package com.example.pruebacontactosjc.ui.Home

import android.icu.util.ULocale
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pruebacontactosjc.data.room.models.ProductosConTiendaYLista
import java.util.Locale.Category

class HomeViewModel():ViewModel() {
    var state by mutableStateOf(HomeState())
        private set
}

data class HomeState(
    val items:List<ProductosConTiendaYLista> = emptyList(),
    val category: Category,
    val productoChecked:Boolean = false
){

}