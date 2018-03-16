package com.przemyslawlusnia.mvvmexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class JobOffersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  private var list: List<JobOfferUIModel> = ArrayList()

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
    val viewItem = LayoutInflater.from(parent?.context).inflate(R.layout.item_job_offer, parent, false)
    return JobOfferViewHolder(viewItem)
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
    (holder as JobOfferViewHolder).bind(list[position])
  }

  class JobOfferViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    private val positionName: TextView = viewItem.findViewById(R.id.positionName)
    fun bind(jobOffer: JobOfferUIModel) {
      positionName.text = jobOffer.positionName
    }
  }

  fun setItems(list: List<JobOfferUIModel>) {
    this.list = list
    notifyDataSetChanged()
  }

  override fun getItemCount(): Int {
    return list.size
  }

}
