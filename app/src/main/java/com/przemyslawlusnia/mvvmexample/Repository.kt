package com.przemyslawlusnia.mvvmexample

import io.reactivex.Observable

object Repository {

  fun getJobOffers() : Observable<List<JobOfferDomainModel>> = Observable.just(listOf(
      JobOfferDomainModel("Clear Energy App Developer"),
      JobOfferDomainModel("Clear Energy App Tester")))

  fun getAnotherJobOffers(): Observable<List<JobOfferDomainModel>> = Observable.just(listOf(
      JobOfferDomainModel("Energy Usage Optimization App Developer"),
      JobOfferDomainModel("Energy Usage Optimization App Tester")))
}