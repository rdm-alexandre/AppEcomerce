package com.example.appecomercemarkepro.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appecomercemarkepro.R
import com.example.appecomercemarkepro.adapters.CategoryAdapter
import com.example.appecomercemarkepro.data.model.Category
import com.example.appecomercemarkepro.data.model.Product
import com.example.appecomercemarkepro.data.model.SliderImage
import util.ExampleData
import java.util.UUID

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var rvCategories: RecyclerView
    private val productList = mutableListOf<Product>()

    private val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(8, 0, 8, 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Configuração do SearchView
        val searchView = view.findViewById<SearchView>(R.id.searchView)
        val searchPlate = searchView.findViewById<View>(androidx.appcompat.R.id.search_plate)
        val searchText = searchView.findViewById<android.widget.EditText>(androidx.appcompat.R.id.search_src_text)
        val magIcon = searchView.findViewById<android.widget.ImageView>(androidx.appcompat.R.id.search_mag_icon)
        val closeIcon = searchView.findViewById<android.widget.ImageView>(androidx.appcompat.R.id.search_close_btn)

        searchView.setBackgroundColor(resources.getColor(R.color.white, null))
        searchPlate?.setBackgroundColor(resources.getColor(R.color.white, null))
        searchText?.setTextColor(Color.BLACK)
        searchText?.setHintTextColor(Color.DKGRAY)
        magIcon?.setColorFilter(Color.DKGRAY)
        closeIcon?.setColorFilter(Color.DKGRAY)

        // Inicializa o RecyclerView principal
        rvCategories = view.findViewById(R.id.rvCategory)
        rvCategories.layoutManager = LinearLayoutManager(requireContext())

        // Obtemos os dados: banner + categorias
        val sliderImages = listOf(
            SliderImage(
                UUID.randomUUID().toString(),
                "https://res.cloudinary.com/beleza-na-web/image/upload/f_auto,fl_progressive,q_auto:eco/loucas/wordpress/prod/sites/7/2024/01/05092334/blog_a-beleza-do-seu-carnavalHUB_banner-header_1361x618-768x349.jpg"
            ),
            SliderImage(
                UUID.randomUUID().toString(),
                "https://res.cloudinary.com/beleza-na-web/image/upload/f_auto,fl_progressive,q_auto:eco/loucas/wordpress/prod/sites/7/2023/03/10152007/%E2%80%A2-1361x618_23_Banner_Carnaval-1-768x349.jpg"
            ),
            SliderImage(
                UUID.randomUUID().toString(),
                "https://marcaspelomundo.com.br/wp-content/uploads/2023/02/1210006221.jpg"
            ),
            SliderImage(
                UUID.randomUUID().toString(),
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_OGSHR7mpwXhe4I893P4zSngHxQO83d6oTOKqmC923njruQ_PbfJZ9TVwEIR32FfP-2A&usqp=CAU"
            ),
            SliderImage(
                UUID.randomUUID().toString(),
                "https://res.cloudinary.com/beleza-na-web/image/upload/f_auto,fl_progressive,q_auto:eco/blog/wordpress/prod/sites/7/2024/01/31092435/HUB_banner-blog1_1361x618.jpg"
            ),
            SliderImage(
                UUID.randomUUID().toString(),
                "https://res.cloudinary.com/beleza-na-web/image/upload/f_auto,fl_progressive,q_auto:eco/loucas/wordpress/prod/sites/7/2025/02/05160817/blog_1361x618_25_ROTINA-Carnaval-768x349.jpg"
            )
        )

        val categories = ExampleData.getCategories()

        // Adiciona os dados ao Adapter
        val categoryAdapter = CategoryAdapter(categories, sliderImages)
        rvCategories.adapter = categoryAdapter

        return view
    }
}
