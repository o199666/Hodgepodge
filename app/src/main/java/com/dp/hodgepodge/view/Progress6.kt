package com.dp.hodgepodge.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.SeekBar
import com.dp.hodgepodge.R
import kotlinx.android.synthetic.main.animateview.view.*

/**
 *  author : ChenWenJie
 *  email  : 1181620038@qq.com
 *  date   : 2020/10/23
 *  desc   :
 */
class Progress6(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    var duration = 300
    var translationState = 0

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        durationSb.max = 10
        durationSb.progress = 1
        durationValueTv.text = "${duration}%"
        durationSb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("StringFormatInvalid")
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                duration = p1 * 300
                durationValueTv.text = context.getString(R.string.ms_with_value, duration)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        animateBt.setOnClickListener {
            durationSb.animate().translationX(100f).setDuration(duration.toLong()).start()
        }
    }

}

 