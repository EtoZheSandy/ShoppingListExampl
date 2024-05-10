package su.afk.shoppinglist.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import su.afk.shoppinglist.app.App
import su.afk.shoppinglist.date.local.ShoppingDatabase
import su.afk.shoppinglist.date.local.dao.ShoppingDao
import su.afk.shoppinglist.date.repositories.ShoppingRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesDataBase(@ApplicationContext app: Context): ShoppingDatabase {
        return Room.databaseBuilder(
            context = app,
            ShoppingDatabase::class.java,
            name = "ShoppingDb.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideDao(db: ShoppingDatabase): ShoppingDao {
        return db.getShoppingDao()
    }

    @Singleton
    @Provides
    fun provideShoppingRepository(shoppingDao: ShoppingDao): ShoppingRepository {
        return ShoppingRepository(shoppingDao)
    }


}