package pub.war3.scrollrecyclerview

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private var amountAxisY = 0
    private lateinit var excelPanelAdapter: DemoAdapter
    /**
     * vertical listener
     */
    private val leftScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            amountAxisY += dy
            val count = recyclerView?.getChildCount()
            if (count != null)
                for (i in 0..count) {
                    val view = recyclerView?.getChildAt(i)
                    if (view is RecyclerView) {
                        fastScrollVertical(amountAxisY, view)
                    }
                }
        }
    }

    internal fun fastScrollVertical(amountAxis: Int, recyclerView: RecyclerView) {
        val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
        //call this method the OnScrollListener's onScrolled will be called，but dx and dy always be zero.
        linearLayoutManager.scrollToPositionWithOffset(0, -amountAxis)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val layoutManager = LinearLayoutManager(this)
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL)
        recyclerView.layoutManager = layoutManager
        var list: MutableList<String> = mutableListOf<String>()
        for (i in 1..20) {
            list.add("i = " + i)
        }
        excelPanelAdapter = DemoAdapter(list,leftScrollListener)
        recyclerView.adapter = excelPanelAdapter
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
