package com.adroid.androidxplorer.components.fragments.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adroid.androidxplorer.R
import com.adroid.androidxplorer.components.fragments.signup.SignupFragment
import com.adroid.androidxplorer.components.screens.home.HomeScreen
import com.adroid.androidxplorer.databinding.FragmentLoginBinding
import com.adroid.androidxplorer.utils.replaceFragment

class LoginFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtSignUp.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.txtSignUp -> {
                replaceFragment(SignupFragment())
            }

            R.id.btnLogin -> {
                startActivity(Intent(requireContext(), HomeScreen::class.java))
            }
        }
    }

}