package com.adroid.androidxplorer.components.fragments.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adroid.androidxplorer.R
import com.adroid.androidxplorer.components.fragments.login.LoginFragment
import com.adroid.androidxplorer.databinding.FragmentSignupBinding
import com.adroid.androidxplorer.utils.replaceFragment

class SignupFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignup.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnSignup -> {
                replaceFragment(LoginFragment())
            }
        }
    }

}