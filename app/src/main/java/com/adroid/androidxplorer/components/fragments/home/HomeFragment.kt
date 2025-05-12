package com.adroid.androidxplorer.components.fragments.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.adroid.androidxplorer.R
import com.adroid.androidxplorer.components.adapters.CategoryAdapter
import com.adroid.androidxplorer.components.adapters.ProductAdapter
import com.adroid.androidxplorer.databinding.FragmentHomeBinding
import com.adroid.androidxplorer.model.Category
import com.adroid.androidxplorer.model.Product

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCategoryRecycler()
        setupProductRecycler()
        Log.d("TAG", "onViewCreated: Addin the log statement")
    }

    /**
     * Sets up the horizontal RecyclerView for categories
     */
    private fun setupCategoryRecycler() {
        val categoryList = listOf(
            Category("Shirts", R.drawable.shirt),
            Category("Jeans", R.drawable.shirt),
            Category("Shoes", R.drawable.shirt),
            Category("Jackets", R.drawable.shirt),
            Category("Accessories", R.drawable.shirt)
        )

        categoryAdapter = CategoryAdapter(categoryList)

        binding.rvCategories.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }
    }

    /**
     * Sets up the grid RecyclerView for featured products
     */
    private fun setupProductRecycler() {
        val productList = listOf(
            Product("Denim Jacket", "₹1999", R.drawable.jacket),
            Product("Casual Shirt", "₹999", R.drawable.jacket),
            Product("White Sneakers", "₹2499", R.drawable.jacket),
            Product("Blue Jeans", "₹1799", R.drawable.jacket)
        )

        productAdapter = ProductAdapter(productList)

        binding.rvFeatured.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = productAdapter
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnLogin -> {

            }
        }
    }
}