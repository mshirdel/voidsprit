package ir.mshirdel.voidsprit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.mshirdel.voidsprit.R
import ir.mshirdel.voidsprit.models.Article

class PublicFeedArticleAdapter(private val myDataset: List<Article>):
    RecyclerView.Adapter<PublicFeedArticleAdapter.ViewHolder>()
{
    class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        val tvTitle: TextView = v.findViewById(R.id.tvArticleTitle)
        val tvAuthor: TextView = v.findViewById(R.id.tvArticleAuthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_text_view, parent, false)

        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = myDataset.get(position).title
        holder.tvAuthor.text = myDataset.get(position).author.username
    }

    override fun getItemCount() = myDataset.size


}