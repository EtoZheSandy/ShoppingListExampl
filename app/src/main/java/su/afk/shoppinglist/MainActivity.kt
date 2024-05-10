package su.afk.shoppinglist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import su.afk.shoppinglist.date.local.entity.ShoppingItem
import su.afk.shoppinglist.date.repositories.ShoppingRepository
import su.afk.shoppinglist.presentation.DialogScreen.AddDialogListener
import su.afk.shoppinglist.presentation.DialogScreen.AddShoppingItemDialog
import su.afk.shoppinglist.presentation.MainScreen.adapter.ShoppingItemAdapter
//import su.afk.shoppinglist.presentation.MainScreen.ShoppingViewModel
import dagger.hilt.android.AndroidEntryPoint
import su.afk.shoppinglist.presentation.MainScreen.ShoppingViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ShoppingItemAdapter.Listener {

    private val viewModel: ShoppingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = ShoppingItemAdapter(this)

        val rv = findViewById<RecyclerView>(R.id.recyclerView)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter


        viewModel.getAllItem().observe(this) { items ->
            adapter.setItems(items)
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener {
            AddShoppingItemDialog(this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }

                }).show()
        }


    }

    override fun ivDelete(item: ShoppingItem) {
        viewModel.delete(item)
    }

    override fun ivUpdate(item: ShoppingItem) {
        viewModel.upsert(item)
    }
}