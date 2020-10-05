package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.shape.MaterialShapeDrawable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        customBottomAppBar()
        binding.bottomAppBar.setNavigationOnClickListener(clickListener)
        addFragment(R.id.fragment_layout,HomeFragment())
    }

    fun replaceFragment1(){
        replaceFragment(R.id.fragment_layout,HomeFragment())
    }
    private val clickListener = View.OnClickListener { item ->
        when (item.id) {
            else -> {
                val bottomNavigationDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavigationDrawerFragment.show(
                    supportFragmentManager,
                    bottomNavigationDrawerFragment.tag
                )
            }
        }
    }

    private fun toast(s: String): Boolean {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
        return true
    }

    private fun customBottomAppBar() {
        val topEdge = BottomAppBarCutCornersTopEdge(
            binding.bottomAppBar.fabCradleMargin,
            binding.bottomAppBar.fabCradleRoundedCornerRadius,
            binding.bottomAppBar.cradleVerticalOffset
        )
        val background = binding.bottomAppBar.background as MaterialShapeDrawable
        background.shapeAppearanceModel =
            background.shapeAppearanceModel.toBuilder().setTopEdge(topEdge).build()
    }
}


