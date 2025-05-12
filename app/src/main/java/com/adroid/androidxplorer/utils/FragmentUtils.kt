package com.adroid.androidxplorer.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.adroid.androidxplorer.R

fun AppCompatActivity.replaceFragment(fragment: Fragment, containerId: Int = R.id.fragment_container) {
    supportFragmentManager.beginTransaction()
        .replace(containerId, fragment)
        .commit()
}

fun Fragment.replaceFragment(fragment: Fragment, containerId: Int = R.id.fragment_container) {
    (requireActivity() as? AppCompatActivity)?.replaceFragment(fragment, containerId)
}