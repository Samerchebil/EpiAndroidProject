package com.example.exam2.ui.tp5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.exam2.R
import com.example.exam2.databinding.FragmentTp5Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tp5.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tp5 : Fragment() {

    private var _binding: FragmentTp5Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTp5Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), getString(R.string.choose_activity), Toast.LENGTH_LONG).show()

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioConcat -> {
                    startActivity(Intent(requireContext(), ConcatActivity::class.java))
                }
                R.id.radioCalcul -> {
                    startActivity(Intent(requireContext(), CalculActivity::class.java))
                }
                R.id.radioMoyenne -> {
                    startActivity(Intent(requireContext(), MoyenneActivity::class.java))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}