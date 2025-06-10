package com.example.appecomercemarkepro.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.appecomercemarkepro.R
import com.example.appecomercemarkepro.adapters.ImageAdapter
import com.example.appecomercemarkepro.data.model.ImageItem
import java.util.UUID

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var viewPager2: ViewPager2
    private lateinit var pageChangeListener: OnPageChangeCallback

    private val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(8, 0, 8, 0)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchView = view.findViewById<androidx.appcompat.widget.SearchView>(R.id.searchView)

        // Cor de fundo da barra
        searchView.setBackgroundColor(resources.getColor(R.color.pink_200, null))

        // Cor da área interna (onde se digita o texto)
        val searchPlate = searchView.findViewById<View>(androidx.appcompat.R.id.search_plate)
        searchPlate?.setBackgroundColor(resources.getColor(R.color.pink_200, null))

        // Texto e dica de busca
        val searchText = searchView.findViewById<android.widget.EditText>(androidx.appcompat.R.id.search_src_text)
        searchText?.setTextColor(android.graphics.Color.BLACK)
        searchText?.setHintTextColor(android.graphics.Color.DKGRAY)

        // Ícones (lupa, botão limpar, etc.)
        val magIcon = searchView.findViewById<android.widget.ImageView>(androidx.appcompat.R.id.search_mag_icon)
        val closeIcon = searchView.findViewById<android.widget.ImageView>(androidx.appcompat.R.id.search_close_btn)
        magIcon?.setColorFilter(android.graphics.Color.DKGRAY)
        closeIcon?.setColorFilter(android.graphics.Color.DKGRAY)


        viewPager2 = view.findViewById<ViewPager2>(R.id.viewPager2)

        val imageList = arrayListOf(
            ImageItem(
                UUID.randomUUID().toString(),
                "https://res.cloudinary.com/beleza-na-web/image/upload/f_auto,fl_progressive,q_auto:eco/loucas/wordpress/prod/sites/7/2024/01/05092334/blog_a-beleza-do-seu-carnavalHUB_banner-header_1361x618-768x349.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://res.cloudinary.com/beleza-na-web/image/upload/f_auto,fl_progressive,q_auto:eco/loucas/wordpress/prod/sites/7/2023/03/10152007/%E2%80%A2-1361x618_23_Banner_Carnaval-1-768x349.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://marcaspelomundo.com.br/wp-content/uploads/2023/02/1210006221.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_OGSHR7mpwXhe4I893P4zSngHxQO83d6oTOKqmC923njruQ_PbfJZ9TVwEIR32FfP-2A&usqp=CAU"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://res.cloudinary.com/beleza-na-web/image/upload/f_auto,fl_progressive,q_auto:eco/blog/wordpress/prod/sites/7/2024/01/31092435/HUB_banner-blog1_1361x618.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://res.cloudinary.com/beleza-na-web/image/upload/f_auto,fl_progressive,q_auto:eco/loucas/wordpress/prod/sites/7/2025/02/05160817/blog_1361x618_25_ROTINA-Carnaval-768x349.jpg"
            )
        )

        val imageAdapter = ImageAdapter()
        viewPager2.adapter = imageAdapter
        imageAdapter.submitList(imageList)

        pageChangeListener = object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewPager2.registerOnPageChangeCallback(pageChangeListener)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewPager2.unregisterOnPageChangeCallback(pageChangeListener)
    }

}