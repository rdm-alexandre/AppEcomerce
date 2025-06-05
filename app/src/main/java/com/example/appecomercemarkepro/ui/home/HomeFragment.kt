package com.example.appecomercemarkepro.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.appecomercemarkepro.R
import com.example.appecomercemarkepro.adapters.ImageAdapter
import com.example.appecomercemarkepro.data.model.ImageItem
import com.example.appecomercemarkepro.databinding.FragmentHomeBinding
import com.example.appecomercemarkepro.ui.favorite.FavoriteFragment
import com.example.appecomercemarkepro.ui.favorite.FavoriteViewModel
import java.util.UUID

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModels()

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

        val rvCarousel = view.findViewById<RecyclerView>(R.id.recyclerViewCarousel)
        val imageAdapter = ImageAdapter()
        rvCarousel.adapter = imageAdapter

        val imageList = arrayListOf(
            ImageItem(
                UUID.randomUUID().toString(),
                "https://i.pinimg.com/736x/c3/08/57/c308573a4f1c776630b05befbe5934d4.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://i.pinimg.com/736x/c3/08/57/c308573a4f1c776630b05befbe5934d4.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://i.pinimg.com/736x/c3/08/57/c308573a4f1c776630b05befbe5934d4.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://i.pinimg.com/736x/c3/08/57/c308573a4f1c776630b05befbe5934d4.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://i.pinimg.com/736x/c3/08/57/c308573a4f1c776630b05befbe5934d4.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://i.pinimg.com/736x/c3/08/57/c308573a4f1c776630b05befbe5934d4.jpg"
            )
        )

        imageAdapter.submitList(imageList)
    }

}