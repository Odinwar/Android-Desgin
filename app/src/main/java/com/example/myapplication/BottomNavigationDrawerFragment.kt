package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navigation_view.setNavigationItemSelectedListener { item: MenuItem ->
            var currentActivity = activity as AppCompatActivity
            when (item.itemId) {
                R.id.home ->
                    currentActivity.replaceFragment(R.id.fragment_layout,HomeFragment())
                R.id.message ->
                    currentActivity.replaceFragment(R.id.fragment_layout, MessageFragment())
                R.id.notification ->
                    currentActivity.replaceFragment(R.id.fragment_layout, NotificationFragment())
                R.id.account ->
                    currentActivity.replaceFragment(R.id.fragment_layout, AccountFragment())
            }
            onStop()
            true
        }
    }

}