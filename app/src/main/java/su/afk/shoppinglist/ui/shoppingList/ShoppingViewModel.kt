package su.afk.shoppinglist.ui.shoppingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import su.afk.shoppinglist.date.local.entity.ShoppingItem
import su.afk.shoppinglist.date.repositories.ShoppingRepository

class ShoppingViewModel(
    private val repository: ShoppingRepository
): ViewModel() {

    fun upsert(item: ShoppingItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.upsert(item)
        }
    }

    fun delete(item: ShoppingItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(item)
        }
    }

    fun getAllItem() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllItem()
        }
    }

}