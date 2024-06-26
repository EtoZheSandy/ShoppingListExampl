package su.afk.shoppinglist.date.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import su.afk.shoppinglist.date.local.dao.ShoppingDao
import su.afk.shoppinglist.date.local.entity.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

//    //в Hilt application Singleton
//    companion object {
//        @Volatile
//        private var instance: ShoppingDatabase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
//            instance ?: createDatabase(context).also { instance = it }
//        }
//
//        private fun createDatabase(context: Context): ShoppingDatabase {
//            return Room.databaseBuilder(
//                context = context,
//                ShoppingDatabase::class.java,
//                name = "ShoppingDb.db")
//                .build()
//        }
//    }
}