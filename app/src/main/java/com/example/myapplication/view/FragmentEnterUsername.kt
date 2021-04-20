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
import kotlinx.android.synthetic.main.fragment_enter_username.*

class FragmentEnterUsername : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_enter_username, container, false)
        view.run {

            this.findViewById<View>(R.id.btn_login).setOnClickListener {
                val input = this.findViewById<EditText>(R.id.edit_text_username).text.toString()

                //MyServiceImpl().getUserDetail(input)
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edit_text_username.addTextChangedListener {
            btn_login.isEnabled = !it.isNullOrBlank()
        }

        btn_login.setOnClickListener {
            viewModel.enterUsername(edit_text_username.text.toString())
        }
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is LoginActivityObserver) {
//            observer = context
//        } else {
//            throw IllegalArgumentException("Wrong type, expecting LoginActivityObserver")
//        }
//    }
}