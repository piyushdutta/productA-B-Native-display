package com.example.ctdemo

import android.content.Context
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnitContent
import com.github.islamkhsh.CardSliderAdapter

class CarouselAdapter(displayUnits: ArrayList<CleverTapDisplayUnitContent>, var context: Context) :
    CardSliderAdapter<CleverTapDisplayUnitContent>(displayUnits) {

    override fun bindView(
        position: Int,
        itemContentView: View,
        item: CleverTapDisplayUnitContent?
    ) {
        Glide.with(context)
            .load(item?.media)
            .fitCenter()
            .into(itemContentView.findViewById(R.id.image))

        itemContentView.findViewById<TextView>(R.id.text_image).text = item?.message
    }

    override fun getItemContentLayout(position: Int): Int {
        return R.layout.item_carousel
    }
}