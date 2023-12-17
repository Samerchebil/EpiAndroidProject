package com.example.exam2.ui.tp1Act2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.exam2.R
import com.example.exam2.databinding.FragmentTp2Act2Binding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [tp2Act2.newInstance] factory method to
 * create an instance of this fragment.
 */class tp2Act2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentTp2Act2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using view binding
        binding = FragmentTp2Act2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            // Get the current local time
            binding.textView3.text = getCurrentDateTime()
            Log.i("pressed", "press date")
            Toast.makeText(requireContext(), "btn pressed", Toast.LENGTH_LONG).show()
        }

        binding.signin.setOnClickListener {
            val log: String = binding.login.text.toString()
            val pass: String = binding.password.text.toString()

            if (("pw" + binding.login.text.toString()).equals(binding.password.text.toString())) {
                Toast.makeText(
                    requireContext(),
                    "your login and password are correct, thanks",
                    Toast.LENGTH_LONG
                ).show()

                val intent = Intent(getActivity(), ComputeActivity::class.java)
               this@tp2Act2.startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "incorrect !!", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun getCurrentDateTime(): String {
        val DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.FRANCE)
        val date = Date()
        return DateFormat.format(date)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment tp2Act2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            tp2Act2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}