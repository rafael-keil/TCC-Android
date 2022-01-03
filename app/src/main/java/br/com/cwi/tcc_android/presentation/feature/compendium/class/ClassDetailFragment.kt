package br.com.cwi.tcc_android.presentation.feature.compendium.`class`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.tcc_android.databinding.FragmentClassBinding
import br.com.cwi.tcc_android.databinding.FragmentClassDetailBinding
import br.com.cwi.tcc_android.domain.entity.Class
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ClassDetailFragment : Fragment() {

    private lateinit var binding: FragmentClassDetailBinding

    private val itemId by lazy {
        arguments?.getString("name")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClassDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.teste.text = itemId
    }
}