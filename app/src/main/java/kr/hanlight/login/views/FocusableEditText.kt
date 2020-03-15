package kr.hanlight.login.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import kr.hanlight.R

class FocusableEditText(
    context: Context?,
    attrs: AttributeSet? = null
) : AppCompatEditText(context, attrs) {

    private var defaultColor: Int = Color.BLACK
    private var focusColor: Int = defaultColor
    private var alertColor: Int = defaultColor

    private var currentColor: Int = defaultColor

    init {
        val typedArray = context?.theme?.obtainStyledAttributes(attrs, R.styleable.FocusableEditText, 0, 0)

        typedArray?.let {
            defaultColor = it.getInteger(R.styleable.FocusableEditText_defaultColor, Color.BLACK)
            focusColor = it.getInteger(R.styleable.FocusableEditText_focusColor, Color.BLACK)
            alertColor = it.getInteger(R.styleable.FocusableEditText_alertColor, Color.BLACK)
        }
    }

    fun showAlertOutline() {
        currentColor = alertColor
    }

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        setBackground(focused)
    }

    private fun setBackground(focused: Boolean) {
        background = if (focused) {
            context.getDrawable(R.drawable.bg_user_input_focus)
        } else {
            context.getDrawable(R.drawable.bg_user_input_default)
        }
    }
}