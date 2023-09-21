package com.ujangwahyu.posttest.features.search.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ujangwahyu.posttest.common.loadImage
import com.ujangwahyu.posttest.databinding.AdapterSearchBinding
import com.ujangwahyu.posttest.features.search.domain.model.SearchItem

class SearchAdapter(
    private val action: (SearchItem) -> Unit
) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var data = ArrayList<SearchItem>()

    fun setData(itemList: List<SearchItem>?) {
        data.clear()
        itemList?.let { data.addAll(it) }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.view) {
            val item = data[position]
            tvName.text = item.strMeal
            tvDes.text = item.strCategory
            ivThumbnail.loadImage(item.strMealThumb)
            root.setOnClickListener {
                action(item)
            }
        }
    }


    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        AdapterSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    class ViewHolder(val view: AdapterSearchBinding) : RecyclerView.ViewHolder(view.root)

}