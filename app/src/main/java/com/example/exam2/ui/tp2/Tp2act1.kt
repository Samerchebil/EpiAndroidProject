package com.example.exam2.ui.tp2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.exam2.databinding.FragmentTp2act1Binding
import com.example.exam2.databinding.FragmentTp4act1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tp2act1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tp2act1 : Fragment() {

    private lateinit var binding: FragmentTp2act1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTp2act1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dteur.setOnClickListener {
            convertDinarToEuro()
        }

        binding.eurdt.setOnClickListener {
            convertEuroToDinar()
        }
    }

    private fun convertDinarToEuro() {
        val dt = binding.montant.text.toString().toInt()
        val eur = dt * 3
        val eurString = eur.toString() + " euro"
        try {
            binding.result.text = eurString
            Toast.makeText(requireContext(), "Done", Toast.LENGTH_LONG).show()
            val intent = Intent(requireContext(), ConverssionActivity::class.java)
            intent.putExtra("montant", dt.toString())
            intent.putExtra("type", "dinar to euro")
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Exception", Toast.LENGTH_LONG).show()
        }
    }

    private fun convertEuroToDinar() {
        val eur = binding.montant.text.toString().toInt()
        val dt = eur / 3
        val dtString = dt.toString() + " Dinar"
        try {
            binding.result.text = dtString
            Toast.makeText(requireContext(), "Done", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Exception", Toast.LENGTH_LONG).show()
        }
    }
}