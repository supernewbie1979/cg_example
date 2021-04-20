package com.example.myapplication.view

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.CgSampleApplication
import com.example.myapplication.R
import com.example.myapplication.viewmodel.CgViewModelFactory
import com.example.myapplication.viewmodel.LoginActivityViewModel
import javax.inject.Inject

private const val NUM_PAGES = 3
class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginActivityViewModel
    private lateinit var viewPager: ViewPager
    @Inject lateinit var cgAppliction: Application
    @Inject lateinit var cgViewModelFactory: CgViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        (application as CgSampleApplication).getCgComponent().inject(this)
        viewPager = findViewById(R.id.pager)
        val pagerAdapter = MyFragmentPagerAdapter(
            supportFragmentManager,
            NUM_PAGES
        )

        viewPager.adapter = pagerAdapter

        viewModel = ViewModelProviders.of(this,
                                           cgViewModelFactory)
                                      .get(LoginActivityViewModel::class.java)

        viewModel.run {
            getFragIndexLiveData().observe(this@LoginActivity, Observer {
                viewPager.setCurrentItem(it, true)
            })
            getMatchedLiveData().observe(this@LoginActivity, Observer {
                if (!it) {
                    ((viewPager.adapter as MyFragmentPagerAdapter).getRegisteredFragment(1) as FragmentReEnterPassword).passwordIsMismatched()
                }
            })
        }
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
           super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }
}