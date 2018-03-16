package com.przemyslawlusnia.mvvmexample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.przemyslawlusnia.mvvmexample.extensions.plusAssign
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class JobOffersViewModel : ViewModel() {

  val jobOffers: MutableLiveData<List<JobOfferUIModel>> = MutableLiveData()

  private val compositeDisposable = CompositeDisposable()

  fun updateJobOffers() {
    compositeDisposable += mapDomainToUI(Repository.getAnotherJobOffers())
        .subscribe(
            { jobOffers -> this.jobOffers.value = jobOffers },
            { e -> Log.e(JobOffersViewModel::javaClass.toString(), e.toString()) })
  }

  private fun mapDomainToUI(domainModel: Observable<List<JobOfferDomainModel>>): Observable<List<JobOfferUIModel>> {
    return domainModel
        .subscribeOn(Schedulers.computation())
        .delay(2, TimeUnit.SECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .map { domainList: List<JobOfferDomainModel> ->
          domainList.map { JobOfferUIModel(it.positionName) }
        }
  }

  override fun onCleared() {
    compositeDisposable.dispose()
    super.onCleared()
  }
}