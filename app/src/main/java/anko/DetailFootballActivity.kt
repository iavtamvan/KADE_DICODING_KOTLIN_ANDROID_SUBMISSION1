package anko

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.recyclerview.v7.*
import org.jetbrains.anko.appcompat.v7.*
import android.widget.*
import android.view.*
import android.graphics.*
import org.jetbrains.anko.*

import com.iav.submission1.R

/**
 * Generate with Plugin
 * @plugin Kotlin Anko Converter For Xml
 * @version 1.3.4
 */
class DetailFootballActivity : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
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
				textSize = dip(20).toFloat()
			}.lparams(width = matchParent) {
				topMargin = dip(8)
				bottomMargin = dip(8)
			}
			textView {
				id = R.id.tv_fottball_desc
				text = "Desc Football"
				gravity = Gravity.CENTER
				textColor = Color.BLACK
				textSize = dip(18).toFloat()
			}.lparams(width = matchParent) {
				topMargin = dip(8)
				bottomMargin = dip(8)
			}
		}
	}
}
