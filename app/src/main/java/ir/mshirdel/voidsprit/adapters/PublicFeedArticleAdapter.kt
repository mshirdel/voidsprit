package ir.mshirdel.voidsprit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.mshirdel.voidsprit.R

class PublicFeedArticleAdapter(private val myDataset: List<String>):
    RecyclerView.Adapter<PublicFeedArticleAdapter.ViewHolder>()
{
    class ViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView

        init {
            textView = v.findViewById(R.id.tvArticleTitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_text_view, parent, false)

        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = myDataset[position]
    }

    override fun getItemCount() = myDataset.size


}