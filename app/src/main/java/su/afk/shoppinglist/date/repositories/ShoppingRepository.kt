package su.afk.shoppinglist.date.repositories

import androidx.lifecycle.LiveData
import su.afk.shoppinglist.date.local.ShoppingDatabase
import su.afk.shoppinglist.date.local.entity.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase,
) {

    suspend fun upsert(item: ShoppingItem) {
        db.getShoppingDao().updateInsert(item)
    }

    suspend fun delete(item: ShoppingItem) {
        db.getShoppingDao().delete(item)
    }

    suspend fun getAllItem(): LiveData<List<ShoppingItem>> {
        return db.getShoppingDao().getAllItems()
    }
}