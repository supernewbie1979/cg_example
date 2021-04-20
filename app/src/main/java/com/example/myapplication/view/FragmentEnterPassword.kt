package com.example.myapplication.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.viewmodel.LoginActivityViewModel
import kotlinx.android.synthetic.main.fragment_enter_password.*
import kotlinx.android.synthetic.main.fragment_enter_username.*
import kotlinx.android.synthetic.main.fragment_reenter_password.*

class FragmentEnterPassword : Fragment() {
    private lateinit var viewModel: LoginActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(LoginActivityViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_enter_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edit_text_password.addTextChangedListener {
            btn_next.isEnabled = !it.isNullOrBlank()
        }

        btn_next.setOnClickListener {
            viewModel.setPassword(edit_text_password.text.toString())
        }
    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is LoginActivityObserver) {
//            observer = context
//        } else {
//            throw IllegalArgumentException("Wrong type, expecting LoginActivityObserver")
//        }
//    }
}