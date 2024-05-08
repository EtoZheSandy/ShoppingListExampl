package su.afk.shoppinglist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import su.afk.shoppinglist.R
import su.afk.shoppinglist.date.local.entity.ShoppingItem
import su.afk.shoppinglist.ui.shoppingList.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        holder.tvName.text = currentShoppingItem.name
        holder.tvAmount.text = currentShoppingItem.amount.toString()

        holder.IvDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }

        holder.IvPlus.setOnClickListener {
            viewModel.upsert(currentShoppingItem)
        }

        holder.IvMinus.setOnClickListener {
            if (currentShoppingItem.amount > 0) {
                viewModel.delete(currentShoppingItem)
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
}