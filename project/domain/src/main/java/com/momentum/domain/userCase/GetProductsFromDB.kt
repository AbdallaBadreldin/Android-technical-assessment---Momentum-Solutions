package com.momentum.domain.userCase

import com.momentum.domain.repository.ProductRepository

class GetProductsFromDB(private val repo: ProductRepository) {
    operator fun invoke() = repo.getProductsFromDB()

}