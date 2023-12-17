package com.example.exam2.ui.tp1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.exam2.R
import com.example.exam2.databinding.FragmentGalleryBinding
import com.example.exam2.databinding.FragmentTp1Binding
import com.example.exam2.ui.gallery.GalleryViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tp1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tp1Fragment : Fragment() {

    private var _binding: FragmentTp1Binding? = null

    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTp1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        Toast.makeText(context, "This app developed by samer", Toast.LENGTH_LONG).show()




        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
