package su.afk.shoppinglist.presentation.MainScreen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import su.afk.shoppinglist.R
import su.afk.shoppinglist.date.local.entity.ShoppingItem


class ShoppingItemAdapter(
    private val listener: Listener
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    private var items: List<ShoppingItem> = listOf()

    // Метод для установки списка элементов и обновления RecyclerView
    fun setItems(newItems: List<ShoppingItem>) {
        items = newItems
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        holder.tvName.text = currentShoppingItem.name
        holder.tvAmount.text = currentShoppingItem.amount.toString()


        holder.IvDelete.setOnClickListener {
            listener.ivDelete(currentShoppingItem)
        }

        holder.IvPlus.setOnClickListener {
            currentShoppingItem.amount++
            listener.ivUpdate(currentShoppingItem)
        }

        holder.IvMinus.setOnClickListener {
            currentShoppingItem.amount--
            if (currentShoppingItem.amount > 0) {
                listener.ivUpdate(currentShoppingItem)
            }
        }
    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvAmount = itemView.findViewById<TextView>(R.id.tvAmount)
        val IvPlus = itemView.findViewById<ImageView>(R.id.IvPlus)
        val IvMinus = itemView.findViewById<ImageView>(R.id.IvMinus)
        val IvDelete = itemView.findViewById<ImageView>(R.id.IvDelete)

    }

    interface Listener{
        fun ivDelete(item: ShoppingItem)
        fun ivUpdate(item: ShoppingItem)
    }
}