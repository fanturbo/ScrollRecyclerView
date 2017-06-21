package pub.war3.scrollrecyclerview

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_demo.view.*

/**
 * Created by turbo on 2017/6/21.
 */
class DemoAdapter(val data: List<String>, val listener: RecyclerView.OnScrollListener) : RecyclerView.Adapter<DemoAdapter.DemoViewHolder>() {

    override fun onBindViewHolder(parent: DemoViewHolder, position: Int) {
        parent.setData(listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): DemoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_demo, parent, false)
        return DemoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class DemoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun setData(listener: RecyclerView.OnScrollListener) {
            val layoutManager = LinearLayoutManager(itemView.context)
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL)
            itemView.recyclerView.layoutManager = layoutManager
            itemView.recyclerView.addOnScrollListener(listener)
            var list: MutableList<String> = mutableListOf<String>()
            for (j in 1..30) {
                list.add("j = " + j)
            }
            itemView.recyclerView.adapter = DemoChildAdapter(list)
        }
    }
}