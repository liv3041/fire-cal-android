package com.toonandtools.auth

import AuthViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.toonandtools.auth.adapter.ViewPagerAdapter
import com.toonandtools.auth.databinding.FragmentLoginBinding
import com.toonandtools.auth.domain.LoginOptions
import com.toonandtools.auth.presentation.AuthViewModelFactory


class LoginFragment : Fragment() {

private lateinit var binding: FragmentLoginBinding
private lateinit var viewModel: AuthViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, AuthViewModelFactory()).get(AuthViewModel::class.java)
        val currentUserId = ""
        viewModel.fetchLoginOptions(currentUserId)
        viewModel.loginOptions.observe(requireActivity()){options->
            setupUI(options)
        }

    }

    @SuppressLint("SuspiciousIndentation")
    private fun setupUI(options: LoginOptions) {
    val fragments = mutableListOf<Pair<String, Fragment>>()
        if (options.hasEmail){
            fragments.add("Email" to EmailLoginFragment())
        }
        if (options.hasPhone){
            fragments.add("Phone" to PhoneLoginFragment())

        }
       if (!options.hasEmail && !options.hasPhone){
           fragments.add("Register" to RegisterFragment())
        }
        val adapter = object : FragmentStateAdapter(childFragmentManager,viewLifecycleOwner.lifecycle) {
            override fun getItemCount() = fragments.size
            override fun createFragment(position: Int) = fragments[position].second
        }
        binding.viewPager.adapter = adapter

        if (fragments.size > 1) {
            binding.tabLayout.visibility = View.VISIBLE
            TabLayoutMediator(binding.tabLayout,binding.viewPager) { tab, position ->
                tab.text = fragments[position].first
            }.attach()
        } else {
           binding.tabLayout.visibility = View.GONE
        }


    }




}