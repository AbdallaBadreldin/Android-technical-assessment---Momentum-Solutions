package com.momentum.domain.userCase

import com.momentum.domain.repository.ProductRepository

class GetProductListFromApi (private val repo: ProductRepository){
    operator fun invoke(movieID: Int) = repo.getProductsFromApi()

}