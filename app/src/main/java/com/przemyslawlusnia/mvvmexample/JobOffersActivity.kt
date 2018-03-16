package com.przemyslawlusnia.mvvmexample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_job_offers.*

class JobOffersActivity : AppCompatActivity() {

  private lateinit var jobOffersViewModel: JobOffersViewModel
  private lateinit var adapter: JobOffersAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_job_offers)
    init()
  }

  private fun init() {
    adapter = JobOffersAdapter()
    jobOffersRV.layoutManager = LinearLayoutManager(this)
    jobOffersRV.adapter = adapter
    jobOffersViewModel = ViewModelProviders.of(this).get(JobOffersViewModel::class.java)
  }

  override fun onResume() {
    super.onResume()
    jobOffersViewModel.jobOffers.observe(this, Observer<List<JobOfferUIModel>> {
      it?.let {
        progressBar.visibility = View.GONE
        adapter.setItems(it)
      }
    })

    jobOffersViewModel.updateJobOffers()
  }
}