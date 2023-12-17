package com.example.exam2.ui.tp1Act3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.exam2.databinding.FragmentTp1Act3Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tp1Act3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tp1Act3 : Fragment() {

    lateinit var binding: FragmentTp1Act3Binding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTp1Act3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listCountry = arrayOf("Sousse", "Teboulba", "Sfax", "Tunis", "Gasrine")
        val arrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1, listCountry
        )
        binding.list1.adapter = arrayAdapter

        binding.list1.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                binding.input.text = listCountry[position]

                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://www.google.fr/search?q=" + listCountry[position])
                startActivity(intent)
            }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tp1Act3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tp1Act3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}