package com.iav.submission1

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout
import com.iav.submission1.helper.Config
import kotlinx.android.synthetic.main.activity_detail_football.*
import org.jetbrains.anko.*

class DetailFootballActivity : AppCompatActivity() {
    var desc: String? = null
    var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scrollView {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                //tools:context = .DetailFootballActivity //not support attribute
                imageView {
                    imageResource = R.drawable.img_acm
                    id = R.id.iv_football
                }.lparams(width = matchParent, height = dip(200))
                textView {
                    id = R.id.tv_fottball_name
                    text = "Name Football"
                    gravity = Gravity.CENTER
                    textColor = Color.BLACK
                    textSize = dip(12).toFloat()
                }.lparams(width = matchParent) {
                    topMargin = dip(8)
                    bottomMargin = dip(8)
                }
                textView {
                    id = R.id.tv_fottball_desc
                    text = "Desc Football"
                    gravity = Gravity.CENTER
                    textColor = Color.BLACK
                    textSize = dip(8).toFloat()
                }.lparams(width = matchParent) {
                    topMargin = dip(8)
                    bottomMargin = dip(8)
                }
            }
        }
        var gambar = intent.getIntExtra(Config.BUNDLE_FOOTBALL_IMAGE, 0)
        name = intent.getStringExtra(Config.BUNDLE_FOOTBALL_NAME)
        desc = intent.getStringExtra(Config.BUNDLE_FOOTBALL_DESC)
        iv_football.setImageResource(gambar)
        tv_fottball_name.setText(name)
        tv_fottball_desc.setText(desc)


    }
}
