package com.example.appecomercemarkepro.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.appecomercemarkepro.R
import com.example.appecomercemarkepro.ui.favorite.FavoriteFragment
import com.example.appecomercemarkepro.ui.favorite.FavoriteViewModel

//import com.example.appecomercemarkepro.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {

    //private var _binding: FragmentNotificationBinding? = null

    companion object {
        fun newInstance() = NotificationFragment()
    }


    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!
    private val viewModel: NotificationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }
}