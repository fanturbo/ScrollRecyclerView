package pub.war3.scrollrecyclerview

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_demo_child.view.*

/**
 * Created by turbo on 2017/6/21.
 */
class DemoChildAdapter(val data: List<String>) : RecyclerView.Adapter<DemoChildAdapter.DemoViewHolder>() {

    override fun onBindViewHolder(parent: DemoViewHolder, position: Int) {
        parent.setData(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): DemoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_demo_child, parent, false)
        return DemoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class DemoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun setData(text: String) {
            itemView.textview.text = text
            if (adapterPosition % 2 == 0)
                itemView.textview.setBackgroundColor(Color.GREEN)
            else
                itemView.textview.setBackgroundColor(Color.WHITE)
        }
    }
}