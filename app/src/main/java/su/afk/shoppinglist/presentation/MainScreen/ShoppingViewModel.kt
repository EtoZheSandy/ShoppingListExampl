package su.afk.shoppinglist.presentation.MainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import su.afk.shoppinglist.date.local.entity.ShoppingItem
import su.afk.shoppinglist.date.repositories.ShoppingRepository
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(
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

    fun getAllItem(): LiveData<List<ShoppingItem>> {
        return repository.getAllItem().asLiveData()
    }

}