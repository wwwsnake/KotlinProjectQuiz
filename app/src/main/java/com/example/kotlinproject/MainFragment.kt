package com.example.kotlinproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainFragment : Fragment(), View.OnClickListener {

    lateinit var btn_yes: Button   //val - неизменяемая переменная, var - изменяемая, lateinit = инициализируем позже
    lateinit var btn_no: Button
    lateinit var btn_fwd: Button
    lateinit var btn_back: Button
    lateinit var txt: TextView
    val array = arrayOf(Question(true, "Амазонка - самая длинная река в мире?"),
    Question(false, "Франция - самая большая страна в мире?"),
    Question(true, "Столица Италии - Рим?"))
    var count: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.main_fragment, container, false)
        initialize(view)

        return view
    }
    private fun initialize(view: View){   //инициализация кнопок и текстового поля
        btn_yes = view.findViewById(R.id.btn_yes)
        btn_no = view.findViewById(R.id.btn_no)
        btn_fwd = view.findViewById(R.id.btn_fwd)
        btn_back = view.findViewById(R.id.btn_back)
        txt = view.findViewById(R.id.txt_question)

        txt.setText(array[0].question)

        btn_yes.setOnClickListener(this)
        btn_no.setOnClickListener(this)
        btn_fwd.setOnClickListener(this)
        btn_back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var id = v!!.id;
        if (id == R.id.btn_yes){
                           if (array[count].answer== true){
                               Toast.makeText(activity, "Правильно!", Toast.LENGTH_LONG).show()
                           } else  {
                               Toast.makeText(activity, "Не правильно!", Toast.LENGTH_LONG).show()
                           }
        } else if (id == R.id.btn_no){
            if (array[count].answer == false){
                Toast.makeText(activity, "Правильно!", Toast.LENGTH_LONG).show()
            } else  {
                Toast.makeText(activity, "Не правильно!", Toast.LENGTH_LONG).show()
            }
        }
        if (id == R.id.btn_fwd) {
            count++
            if (count == array.size){
                count = array.size-1
                Toast.makeText(activity, "Вопросов больше нет!", Toast.LENGTH_LONG).show()
            }
            txt.setText(array.get(count).question)
        }
        if (id == R.id.btn_back) {
            count--
            if (count == -1){
                count = 0
                Toast.makeText(activity, "Это первый вопрос!", Toast.LENGTH_LONG).show()
            }
            txt.setText(array.get(count).question)
        }

    }
}