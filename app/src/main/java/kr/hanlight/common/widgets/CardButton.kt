package kr.hanlight.common.widgets

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.view_card_button.view.*
import kr.hanlight.R

class CardButton(
    context: Context,
    attrs: AttributeSet? = null
) : CardView(context, attrs) {

    private var text: String? = null
    private var textSize: Float = -1f
    private var textColor: Int = Color.BLACK

    private var paddingTop: Int? = 0
    private var paddingBottom: Int? = 0
    private var paddingLeft: Int? = 0
    private var paddingRight: Int? = 0

    private val buttonTxt: TextView by lazy { findViewById<TextView>(R.id.buttonTxt) }

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.view_card_button, this, true)

        val typedArray = context.theme?.obtainStyledAttributes(attrs, R.styleable.CardButton, 0, 0)
        typedArray?.let {
            text = it.getString(R.styleable.CardButton_buttonText)
            textSize = it.getDimension(R.styleable.CardButton_buttonTextSize, 0f)
            textColor = it.getInteger(R.styleable.CardButton_buttonTextColor, Color.BLACK)
        }

        buttonTxt.setTextColor(textColor)
        text?.let { buttonTxt.text = it }
        if (textSize > -1) {
            Log.d("CardButton", "textSize: $textSize")
            buttonTxt.textSize = 12f
        }

        typedArray?.recycle()

//        Log.d("CardButton", "paddingTop: $paddingTop")
//        buttonTxt.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
    }

    fun activateButton() {

    }

    fun inactiveButton() {

    }

}