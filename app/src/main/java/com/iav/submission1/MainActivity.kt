package com.iav.submission1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.iav.submission1.adapter.FootBallAdapter
import com.iav.submission1.helper.Config
import com.iav.submission1.model.Item
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        textView("Hello World!") {
//            app:layout_constraintBottom_toBottomOf = parent
//            app:layout_constraintLeft_toLeftOf = parent
//            app:layout_constraintRight_toRightOf = parent
//            app:layout_constraintTop_toTopOf = parent
//        }.lparams(width = wrapContent, height = wrapContent)
//    }
        linearLayout {
            orientation = LinearLayout.VERTICAL
            recyclerView {
                id = R.id.rv_football
            }.lparams(width = matchParent, height = matchParent)
        }
        initDatas()

        rv_football.layoutManager = LinearLayoutManager(this)
        rv_football.adapter = FootBallAdapter(this, items) {

            val images = it.image
            val imagaseting = images.toString()
//            val toast = Toast.makeText(applicationContext, imagaseting, Toast.LENGTH_SHORT)
//            toast?.show()
//            val intent = Intent(this, DetailFootballActivity::class.java)
//            intent.putExtra(Config.BUNDLE_FOOTBALL_NAME, it.name)
//            intent.putExtra(Config.BUNDLE_FOOTBALL_IMAGE, imagaseting)
//            intent.putExtra(Config.BUNDLE_FOOTBALL_DESC, it.des)
//            startActivity(intent)
            startActivity(intentFor<DetailFootballActivity>(Config.BUNDLE_FOOTBALL_NAME to it.name,
                    Config.BUNDLE_FOOTBALL_IMAGE to it.image,
                    Config.BUNDLE_FOOTBALL_DESC to it.des))
        }


    }

    private fun initDatas() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_description)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0),
                    desc[i]))
        }
        image.recycle()
    }
}
