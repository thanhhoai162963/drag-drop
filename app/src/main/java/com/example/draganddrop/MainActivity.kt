package com.example.draganddrop

import android.content.ClipData
import android.content.ClipDescription
import android.os.Build
import android.os.Bundle
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imgView: ImageView
    private lateinit var layoutTop: LinearLayout
    private lateinit var layoutBottom: LinearLayout
    private var x: Float? = null
    private var y: Float? = null
    private var dx: Float? = null
    private var dy: Float? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgView = findViewById(R.id.imgView)
       /* layoutTop = findViewById(R.id.layout_top)
        layoutBottom = findViewById(R.id.layout_bottom)*/
    }


    override fun onStart() {
        super.onStart()
     /*   imgView.setOnLongClickListener { view ->
            val item = ClipData.Item(view.tag as? CharSequence)
            val dragData = ClipData(
                "abc",
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                view.startDragAndDrop(dragData, View.DragShadowBuilder(view), view, 0)
            } else {
                view.startDrag(dragData, View.DragShadowBuilder(view), view, 0)
            }
            imgView.visibility = View.INVISIBLE
            true
        }

        val dragListener = View.OnDragListener { view, dragEvent ->
            when (dragEvent.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    true
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DRAG_LOCATION -> {
                    true
                }
                DragEvent.ACTION_DRAG_EXITED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DROP -> {
                    val v = dragEvent.localState as View
                    val owner = v.parent as ViewGroup
                    owner.removeView(v)
                    val destination = view as LinearLayout
                    destination.addView(v)
                    v.visibility = View.VISIBLE
                    true
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    view.invalidate()
                    true
                }
                else -> {
                    false
                }
            }
        }
        layoutTop.setOnDragListener(dragListener)
        layoutBottom.setOnDragListener(dragListener)*/
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            x = event.x
            y = event.y
        }
        if (event?.action == MotionEvent.ACTION_MOVE) {
            dx = event.x - x!!
            dy = event.y - y!!

            imgView.x = imgView.x + dx!!
            imgView.y = imgView.y + dy!!

            x = event.x
            y = event.y
        }
        return super.onTouchEvent(event)
    }
}