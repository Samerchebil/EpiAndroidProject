package com.example.exam2.ui.tp4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.exam2.R
import com.example.exam2.databinding.FragmentTp4act2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tp4act2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tp4act2 : Fragment() {
    private lateinit var binding: FragmentTp4act2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTp4act2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val continentSpinner: Spinner = binding.continent
        val citiesSpinner: Spinner = binding.countries

        val adapterForSpinnerOne = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.continents_array)
        )
        continentSpinner.adapter = adapterForSpinnerOne

        val adapterPaysAfr = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.pays_africains_array)
        )
        val adapterPaysAsie = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.pays_asiatiques_array)
        )
        val adapterPaysEuropean = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.pays_europeens_array)
        )
        val adapterPaysAmerican = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.pays_americains_array)
        )
        val adapterPaysOcean = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.pays_oceaniens_array)
        )
        var selectedList = arrayOf<String>()

        continentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (resources.getStringArray(R.array.continents_array)[position]) {
                    "Afrique" -> {
                        citiesSpinner.adapter = adapterPaysAfr
                        selectedList = resources.getStringArray(R.array.pays_africains_array)
                    }

                    "Europe" -> {
                        citiesSpinner.adapter = adapterPaysEuropean
                        selectedList = resources.getStringArray(R.array.pays_europeens_array)
                    }

                    "Asie" -> {
                        citiesSpinner.adapter = adapterPaysAsie
                        selectedList = resources.getStringArray(R.array.pays_asiatiques_array)
                    }

                    "Océanie" -> {
                        citiesSpinner.adapter = adapterPaysOcean
                        selectedList = resources.getStringArray(R.array.pays_oceaniens_array)
                    }

                    "Amérique" -> {
                        citiesSpinner.adapter = adapterPaysAmerican
                        selectedList = resources.getStringArray(R.array.pays_americains_array)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle when nothing is selected
            }
        }
    }
}