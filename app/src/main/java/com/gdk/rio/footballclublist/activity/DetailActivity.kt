package com.gdk.rio.footballclublist.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.gdk.rio.footballclublist.R
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var clubName: String = ""
    private var clubDetail: String = ""
    private var clubLogo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val clubImageList = resources.obtainTypedArray(R.array.club_logo)
        val clubNameList = resources.getStringArray(R.array.club_name)
        val clubDetailList = resources.getStringArray(R.array.club_detail)

        val intent = getIntent()
        clubName = intent.getStringExtra("clubName")

        for(index in clubNameList.indices){
            if(clubNameList[index] == clubName){
                clubDetail = clubDetailList[index].toString()
                clubLogo = clubImageList.getResourceId(index, 0)
            }
        }

        DetailActivityUI().setContentView(this)
    }

    inner class DetailActivityUI: AnkoComponent<DetailActivity>{
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {

            verticalLayout {
                padding = dip(16)

                imageView(clubLogo).lparams(){
                    height = dip(70)
                    width = dip(70)
                    margin = dip(10)
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView(clubName){
                    textSize = 24f
                }.lparams(){
                    height = wrapContent
                    width = wrapContent
                    margin = dip(10)
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView(clubDetail).lparams(){
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                }
            }
        }

    }
}
