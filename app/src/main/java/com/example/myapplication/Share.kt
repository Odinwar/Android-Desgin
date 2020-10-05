package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.setCustomAnimations(R.anim.slide_in,R.anim.slide_out,R.anim.fade_in,R.anim.slide_out)
    fragmentTransaction.func().commit()
}

fun AppCompatActivity.addFragment(frameId: Int, fragment: Fragment) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun AppCompatActivity.replaceFragment(frameId: Int, fragment: Fragment) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun AppCompatActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.inTransaction { remove(fragment) }
}
