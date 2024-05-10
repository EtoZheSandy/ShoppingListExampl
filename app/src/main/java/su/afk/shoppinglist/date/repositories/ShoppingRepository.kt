package su.afk.shoppinglist.date.repositories

import kotlinx.coroutines.flow.Flow
import su.afk.shoppinglist.date.local.dao.ShoppingDao
import su.afk.shoppinglist.date.local.entity.ShoppingItem
import javax.inject.Inject

class ShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
) {

    suspend fun upsert(item: ShoppingItem) {
        shoppingDao.updateInsert(item)
    }

    suspend fun delete(item: ShoppingItem) {
        shoppingDao.delete(item)
    }

    fun getAllItem(): Flow<List<ShoppingItem>> {
        return shoppingDao.getAllItems()
    }
}