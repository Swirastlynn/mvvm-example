package com.przemyslawlusnia.mvvmexample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class JobOffersViewModel : ViewModel() {

  var jobOffers: MutableLiveData<List<JobOfferUIModel>> = MutableLiveData()

  init {
    this.jobOffers.value = DummyDataProvider.getJobOffers()
  }

  fun updateJobOffers() {
    this.jobOffers.value = DummyDataProvider.getAnotherJobOffers()
  }

}