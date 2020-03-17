package com.example.retrofit1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit1.Model.Post
import com.example.retrofit1.R
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter(var postList:List<Post>,context:Context): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    inner class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(post:Post){
            itemView.txt_Title.text=post.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }
}