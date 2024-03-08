package com.momentum.domain.userCase

data class GetProductListUseCase(
    val getProductListFromApi: GetProductListFromApi,
    val getProductsFromDB: GetProductsFromDB,
)
