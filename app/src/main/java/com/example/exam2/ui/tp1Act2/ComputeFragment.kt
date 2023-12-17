package com.example.exam2.ui.tp1Act2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.exam2.R
import com.example.exam2.databinding.FragmentComputeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ComputeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ComputeFragment : Fragment() {

    lateinit var radioG: RadioGroup
    lateinit var sum: RadioButton
    lateinit var square: RadioButton
    lateinit var value1: TextView
    lateinit var value2: TextView
    lateinit var txtresultat: TextView
    lateinit var calculate: Button
    private lateinit var binding: FragmentComputeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding variable
        binding = FragmentComputeBinding.inflate(layoutInflater)

        // Set the content view using the binding

        // Access views using the binding
        binding.sum
        binding.square
        binding.value1
        binding.value2
        binding.txtresultat
        binding.calculate

        var valueButton: String
        var res: Int = 0

        binding.calculate.setOnClickListener {

            val selectedOption: Int = binding.radioG.checkedRadioButtonId
            val selectedRadioButton: RadioButton = binding.root.findViewById(selectedOption)
            valueButton = selectedRadioButton.text.toString()
            val num1: String = binding.value1.text.toString()
            val num2: String = binding.value2.text.toString()
            val n1: Int = num1.toInt()
            val n2: Int = num2.toInt()

            if (binding.value1.text.isNotEmpty() && binding.value2.text.isNotEmpty()) {
                if (valueButton == "sum") {
                    res = n2 + n1
                } else if (valueButton == "square") {
                    res = n2 * n1
                }
                valueButton = res.toString()
                binding.txtresultat.text = valueButton

            } else {
                Toast.makeText(context, "Veuillez remplir les champs", Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compute, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ComputeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ComputeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}