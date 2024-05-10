package su.afk.shoppinglist.presentation.DialogScreen

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import su.afk.shoppinglist.R
import su.afk.shoppinglist.date.local.entity.ShoppingItem

//не держать кликеры в Rv adapter
class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shoping_item)

        val tvAdd = findViewById<TextView>(R.id.tvAdd)
        val tvCancel = findViewById<TextView>(R.id.tvCancel)

        tvAdd?.setOnClickListener {
            val name = findViewById<EditText>(R.id.edName)?.text.toString()
            val amount = findViewById<EditText>(R.id.edAmount)?.text.toString()

            if(name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Введи все данные", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(
                name = name,
                amount = amount.toInt()
            )
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel?.setOnClickListener {
            cancel()
        }

    }
}