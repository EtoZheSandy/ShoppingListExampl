package su.afk.shoppinglist.presentation.DialogScreen

import su.afk.shoppinglist.date.local.entity.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item: ShoppingItem)
}