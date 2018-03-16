package com.przemyslawlusnia.mvvmexample

object DummyDataProvider {

  fun getJobOffers() = listOf(
      JobOfferUIModel("Clear Energy App Developer"),
      JobOfferUIModel("Clear Energy App Tester"))

  fun getAnotherJobOffers() = listOf(
      JobOfferUIModel("Energy Usage Optimization App Developer"),
      JobOfferUIModel("Energy Usage Optimization App Tester"))
}