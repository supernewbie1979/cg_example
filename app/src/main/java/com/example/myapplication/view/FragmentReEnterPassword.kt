package com.example.myapplication.view

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.viewmodel.LoginActivityViewModel
import kotlinx.android.synthetic.main.fragment_reenter_password.*

class FragmentReEnterPassword : Fragment() {
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
       return inflater.inflate(R.layout.fragment_reenter_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edit_text_reenter_password.addTextChangedListener {
            btn_confirm.isEnabled = !it.isNullOrBlank()
        }

        btn_confirm.setOnClickListener {
            viewModel.reenterPassword(edit_text_reenter_password.text.toString())
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

    fun passwordIsMismatched() {
        activity?.run {
            findViewById<TextView>(R.id.tv_inline_error).run {
                visibility = View.VISIBLE
                text = "Password mismatched"
                setTextColor(Color.parseColor("#bdbdbd"))
            }
        }
    }


}