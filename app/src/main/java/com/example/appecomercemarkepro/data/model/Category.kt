package com.example.appecomercemarkepro.data.model

data class Category public constructor(
    val id: Int,
    val name: String,
    val products: List<Product>
) {
    companion object {
        private var lastId = 0

        fun create(
            name: String = "",
            products: List<Product> = emptyList()
        ): Category {
        return Category(
            id = ++lastId,
            name = name,
            products = products
        )
    }
}
}
