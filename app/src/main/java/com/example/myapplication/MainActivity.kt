package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    lateinit var recyclerView : RecyclerView


    lateinit  var myAdapter :Adapter


    var dataList = arrayListOf<String>("asddaad","help","demo","hjagfs")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView =  findViewById(R.id.rv_list);


        myAdapter = Adapter(dataList);


        recyclerView.adapter = myAdapter;
    }
}

class Adapter(var list : ArrayList<String>) : RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {



        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false);

        return  ViewHolder(v);

    }

    override fun getItemCount(): Int {


        return  list.size;

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    holder.textView.text = list[position];

        holder.button.setOnClickListener {

            Toast.makeText(it.context,"I am button",Toast.LENGTH_LONG).show()

        }
    }


}

class ViewHolder(v: View) : RecyclerView.ViewHolder(v){

    lateinit var  button: Button;
    lateinit var  textView: TextView

    init {
        button =  v.findViewById(R.id.button)
        textView =  v.findViewById(R.id.textView)
    }



}