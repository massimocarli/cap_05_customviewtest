package uk.co.massimocarli.customviewtest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleView : View {

  var fillColor: Int
  var circleWidth: Int = 0
  var circleHeight: Int = 0
  val paint: Paint

  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    // We read the attributes values
    val typedArray = context.theme.obtainStyledAttributes(
      attrs,
      R.styleable.CircleView,
      0,
      0
    )
    fillColor = typedArray.getColor(R.styleable.CircleView_fillColor, Color.BLACK)
    typedArray.recycle()
    paint = Paint().apply {
      color = fillColor
    }
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    // The current dimension of the widget are into the measuredWidth and measuredHeight variables
    circleWidth = measuredWidth
    circleHeight = measuredHeight
    setMeasuredDimension(measuredWidth, measuredHeight)
  }


  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    canvas.drawRoundRect(
      0F,
      0F,
      circleWidth.toFloat(),
      circleHeight.toFloat(),
      circleHeight.toFloat() / 2.0F,
      circleWidth.toFloat() / 2.0F,
      paint
    )
  }
}