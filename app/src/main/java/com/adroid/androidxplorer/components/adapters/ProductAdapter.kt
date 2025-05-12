package com.adroid.androidxplorer.components.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adroid.androidxplorer.databinding.ItemProductBinding
import com.adroid.androidxplorer.model.Product

class ProductAdapter(
    private val products: List<Product>,
    private val onItemClick: ((Product) -> Unit)? = null
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.imgProduct.setImageResource(product.imageResId)
            binding.tvProductName.text = product.name
            binding.tvProductPrice.text = product.price

            binding.root.setOnClickListener {
                onItemClick?.invoke(product)
            }
        }
    }
}
