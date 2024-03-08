package com.momentum.domain.userCase

import com.momentum.domain.repository.ProductRepository

data class GetProductListUseCase(
    val productsRepository: ProductRepository
){
    suspend operator fun invoke() = productsRepository.getProductsFromApi()

}
