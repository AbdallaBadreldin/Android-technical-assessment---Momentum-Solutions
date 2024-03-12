package com.minly.domain.userCase

import com.minly.domain.repository.ProductRepository
import javax.inject.Inject

data class GetProductListUseCase @Inject constructor(
    val productsRepository: ProductRepository
) {
    suspend operator fun invoke() = productsRepository.getProductsFromApi()

}
