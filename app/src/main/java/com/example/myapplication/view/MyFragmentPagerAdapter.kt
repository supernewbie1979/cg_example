package com.example.myapplication.view

import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


private const val TAG = "MyFragmentPagerAdapter"
class MyFragmentPagerAdapter(private val fm: FragmentManager,
                             private val numberOfPage: Int): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var registeredFragments =
        SparseArray<Fragment>()
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FragmentEnterPassword()
            1 -> FragmentReEnterPassword()
            2 -> FragmentEnterUsername()
            else -> {
                throw Exception("cannot find fragment")
            }
        }
    }

    override fun getCount(): Int {
        return numberOfPage
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment =
            super.instantiateItem(container, position) as Fragment
        registeredFragments.put(position, fragment)
        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        registeredFragments.remove(position)
        super.destroyItem(container, position, `object`)
    }

    fun getRegisteredFragment(position: Int): Fragment? {
        return registeredFragments[position]
    }

}