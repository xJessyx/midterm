package com.jessy.publishermidterm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jessy.publishermidterm.databinding.ItemHomefragmentBinding

class HomeAdapter(val viewModel: HomeViewModel) : ListAdapter<Data,
        HomeAdapter.HomeViewHolder>(SiylishDiffCallback()) {

    class HomeViewHolder private constructor(var binding: ItemHomefragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data, viewModel: HomeViewModel) {
            binding.itemTvArticleTitle.text = viewModel.articleTitle
            binding.itemTvAuthorName.text = viewModel.authorName
            binding.itemTvCreatedTime.text = viewModel.createdTime.toString()
            binding.itemTvArticleContent.text = viewModel.articleContent
            binding.itemTvArticleTitle.text = viewModel.articleTitle

            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): HomeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemHomefragmentBinding.inflate(layoutInflater, parent, false)
                return HomeViewHolder(binding)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind((item), viewModel)

    }

    class SiylishDiffCallback : DiffUtil.ItemCallback<Data>() {

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return    oldItem == newItem
        }
    }


}