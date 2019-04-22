package uk.co.massimocarli.customviewtest

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class DotTextView : LinearLayout {
  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    // We read the attributes values
    val typedArray = context.theme.obtainStyledAttributes(
      attrs,
      R.styleable.DotTextView,
      0,
      0
    )
    val dotPosition = typedArray.getInt(R.styleable.DotTextView_dotPosition, 0)
    val dotSize = typedArray.getDimension(R.styleable.DotTextView_dotSize, 10.0F)
    val dotColor = typedArray.getColor(R.styleable.DotTextView_dotColor, Color.BLACK)
    typedArray.recycle()
    val textView = TextView(context, attrs)
    val dotTextView = TextView(context)
    dotTextView.text = "\u2022"
    dotTextView.textSize = dotSize
    dotTextView.setTextColor(dotColor)
    orientation = LinearLayout.HORIZONTAL
    gravity = Gravity.CENTER_VERTICAL
    when (dotPosition) {
      0 -> {
        addView(dotTextView)
        addView(textView)
      }
      1 -> {
        addView(textView)
        addView(dotTextView)
      }
    }
  }
}