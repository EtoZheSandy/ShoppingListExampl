package su.afk.shoppinglist.date.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import su.afk.shoppinglist.date.local.entity.ShoppingItem.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "item_name")
    val name: String,
    @ColumnInfo(name = "item_amount")
    val amount: Int
) {
    companion object {
        const val TABLE_NAME = "shopping_items"
    }
}