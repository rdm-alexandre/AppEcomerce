package util

import com.example.appecomercemarkepro.data.model.Category
import com.example.appecomercemarkepro.data.model.Product

object ExampleData {
    fun getCategories(): List<Category> {
            val product1 = Product.create(
                brand = "Carolina Herrera",
                title = "Good Girl Eau de Parfum 80ml",
                description = "Perfume feminino oriental floral",
                descriptionValue = "Em 10x de R$19,99",
                price = 199.99,
                rating = 4.5,
                imageUrl = arrayListOf("good_girl_1")
            )

            val product2 = Product.create(
                    brand = "Dior",
                    title = "Sauvage Eau de Toilette 100ml",
                    description = "Perfume masculino amadeirado aromático",
                    descriptionValue = "Ou R$429,90 à vista",
                    price = 429.90,
                    rating = 4.8,
                    imageUrl = arrayListOf("sauvage_1.png")
                )

            val product3 = Product.create(
                    brand = "Lancôme",
                    title = "La Vie Est Belle Eau de Parfum 75ml",
                    description = "Perfume feminino floral gourmand",
                    descriptionValue = "Em até 6x de R$74,98",
                    price = 449.90,
                    rating = 4.7,
                    imageUrl = arrayListOf("lavie_1", "lavie_2")
                )

            val product4 = Product.create(
                    brand = "Paco Rabanne",
                    title = "1 Million Eau de Toilette 100ml",
                    description = "Perfume masculino especiado fresco",
                    descriptionValue = "R$379,99 no Pix",
                    price = 399.99,
                    rating = 4.6,
                    imageUrl = arrayListOf("one_million_1", "one_million_2")
                )

            val product5 = Product.create(
                    brand = "Chanel",
                    title = "Coco Mademoiselle Eau de Parfum 50ml",
                    description = "Perfume feminino cítrico oriental",
                    descriptionValue = "Em 5x de R$119,98",
                    price = 599.90,
                    rating = 4.9,
                    imageUrl = arrayListOf("coco_maidemoiselle_1")
                )

            val product6 = Product.create(
                    brand = "Maybelline",
                    title = "Base Fit Me Matte + Poreless",
                    description = "Base líquida para pele mista a oleosa",
                    descriptionValue = "A partir de R$49,90",
                    price = 49.90,
                    rating = 4.4,
                    imageUrl = arrayListOf("fit_me_1")
                )

            val product7 = Product.create(
                    brand = "MAC",
                    title = "Batom Retro Matte Ruby Woo",
                    description = "Batom vermelho intenso com acabamento matte",
                    descriptionValue = "R$109,90 à vista",
                    price = 109.90,
                    rating = 4.9,
                    imageUrl = arrayListOf("battom_retro_1")
                )

            val product8 = Product.create(
                    brand = "Neutrogena",
                    title = "Hidratante Hydro Boost Water Gel",
                    description = "Hidratante facial oil-free com ácido hialurônico",
                    descriptionValue = "R$69,90 em até 2x sem juros",
                    price = 69.90,
                    rating = 4.7,
                    imageUrl = arrayListOf("hydro_boost_1")
                )

            val product9 = Product.create(
                    brand = "Ruby Rose",
                    title = "Paleta Be Fabulous",
                    description = "Paleta de sombras com tons neutros e cintilantes",
                    descriptionValue = "Apenas R$34,90",
                    price = 34.90,
                    rating = 4.3,
                    imageUrl = arrayListOf("paleta_be_fabulous_1")
                )

            val category1 = Category.create(
                    name = "Recomendados",
                    products = listOf(product1, product2, product6, product7, product8)
            )

            val category2 = Category.create(
                    name = "Perfumes que encantam",
                    products = listOf(product1, product2, product3, product4, product5)
            )

            val category3 = Category.create(
                    name = "Maquiagem",
                    products = listOf(product6, product7, product9)
            )

            val category4 = Category.create(
                    name = "Cuidados com a pele",
                    products = listOf(product8)
            )

            return listOf(category1, category2, category3, category4)

    }
}