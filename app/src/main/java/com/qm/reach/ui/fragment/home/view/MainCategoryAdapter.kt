package com.qm.reach.ui.fragment.home.view

import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.qm.reach.base.view.BaseItemCallback
import com.qm.reach.ui.fragment.home.model.CategoryUIItem
import com.qm.reach.ui.fragment.home.view.MainCategoryAdapter.ViewHolder

//MARK:- Main Category Adapter
class MainCategoryAdapter :
  ListAdapter<CategoryUIItem, ViewHolder>(BaseItemCallback<CategoryUIItem>()), Filterable {

 private var dataSrc = ArrayList<CategoryUIItem>()
 private var filterDataSrc = dataSrc
  private var position: Int = 0

  class ViewHolder(private val bind: CustomCell) : RecyclerView.ViewHolder(bind.rootView) {
    fun bindView(data: CategoryUIItem) {
      bind.populate(dataSrc = data)
    }
  }

  override fun getItemId(position: Int): Long
  {
    return filterDataSrc[position].id.toLong()
  }
  // Create Adapter
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ViewHolder {
    val view = CustomCell(parent.context)
    val vm = ViewHolder(view)
    return vm
  }

  // MARK: populate View
  override fun onBindViewHolder(
    holder: ViewHolder,
    position: Int
  ) {
    holder.bindView(data = filterDataSrc[position])
  }

  //MARK:- get list item count
  override fun getItemCount(): Int {
    return filterDataSrc.size
  }

  //MARK:- set adapter list
  fun setList(newList: List<CategoryUIItem>) {
    dataSrc.clear()
    dataSrc.addAll(newList)
    filterDataSrc = ArrayList(dataSrc)
    submitList(filterDataSrc.toMutableList())
  }

  //MARK:- clear current list
  fun clearCurrentList() {
    dataSrc.clear()
    filterDataSrc = ArrayList(dataSrc)
    submitList(filterDataSrc.toMutableList())
  }

  override fun getFilter(): Filter {
    return object : Filter() {
      override fun publishResults(
        charSequence: CharSequence?,
        filterResults: FilterResults
      ) {
        filterDataSrc = ArrayList(filterResults.values as List<CategoryUIItem>).toCollection(ArrayList())
        this@MainCategoryAdapter.submitList(filterDataSrc)
      }

      override fun performFiltering(charSequence: CharSequence?): FilterResults {
        val queryString = charSequence?.toString()?.toLowerCase()

        val filterResults = FilterResults()
        filterResults.values = if (queryString == null || queryString.isEmpty())
          dataSrc
        else
          dataSrc.filter { item ->
           val res = item.mainTitle.toLowerCase().contains(queryString)
            res
          }
        return filterResults
      }
    }
  }//MARK:- filter
}


