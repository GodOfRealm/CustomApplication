package com.example.dev.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.example.dev.myapplication.R
import kotlinx.android.synthetic.main.meet_view_end_with_icon.view.*
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.TextView
import com.example.dev.myapplication.R.mipmap.ic_launcher
import android.graphics.drawable.Drawable
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import com.blankj.utilcode.util.SizeUtils


class EndWithIconView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var itemTextSize: Float = context.getResources().getDimension(R.dimen.bdp_10);
    private var itemTextColor: Int = Color.BLACK
    private var lineSpace: Float = 0f
    private var itemMaxLines: Int = 100

    init {
        View.inflate(context, R.layout.meet_view_end_with_icon, this)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.EndWithIconView)
        setBaseAttributes(typedArray)
        initView()
        initData()
    }

    //设置基础属性
    private fun setBaseAttributes(typedArray: TypedArray?) {
        typedArray?.let { typed ->
            itemTextSize = typed.getDimension(R.styleable.EndWithIconView_content_text_size, context.getResources().getDimension(R.dimen.bdp_10))
            itemTextColor = typed.getColor(R.styleable.EndWithIconView_content_text_color, Color.BLACK)
            lineSpace = typed.getDimension(R.styleable.EndWithIconView_content_text_line_space, 0f)
            itemMaxLines = typed.getInt(R.styleable.EndWithIconView_content_text_max_lines, 100)
        }
    }

    private fun initData() {

    }

    private fun initView() {
        meet_tv_end_with_icon_message.textSize = itemTextSize
    }

    private fun setDataWithIcon(text: String?, icon: String) {
        if (!TextUtils.isEmpty(text)) {
            meet_tv_end_with_icon_message.setText(text)
            val vto = meet_tv_end_with_icon_message.getViewTreeObserver()
            vto.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {

                override fun onGlobalLayout() {
                    var addFlag = false;
                    val obs = meet_tv_end_with_icon_message.getViewTreeObserver()
                    obs.removeGlobalOnLayoutListener(this)
                    val layout = meet_tv_end_with_icon_message.getLayout()
                    meet_tv_end_with_icon_message.visibility = View.GONE
                    var start = 0
                    var end: Int
                    val count = meet_tv_end_with_icon_message.getLineCount()
                    for (i in 0 until count) {
                        end = layout.getLineEnd(i)
                        val lineContent = text!!.substring(start, end) //指定行的内容
                        start = end
                        val itemView = getItemView(i)
                        itemView.setText(lineContent)

                        if (count == 1 && getLineMaxNumber(text, meet_tv_end_with_icon_message.paint, meet_tv_end_with_icon_message.maxWidth) == text.length) {
                            itemView.setText(lineContent.substring(0, lineContent.length - 2))
                            val textView = getItemView(2)
                            textView.setText(lineContent.substring(lineContent.length - 1))
                            drawEndWithIcon(textView)
                            meet_tv_end_with_icon_content.addView(itemView)
                            meet_tv_end_with_icon_content.addView(textView)
                            addFlag = true
                        }
                        if (!addFlag) {
                            meet_tv_end_with_icon_content.addView(itemView)
                            if (i == itemMaxLines - 1 || i == meet_tv_end_with_icon_message.getLineCount() - 1) {
                                drawEndWithIcon(itemView)
                                break
                            }
                        }

                    }

                }
            })
        }
    }

    fun setData(text: String, icon: String) {
        if (!TextUtils.isEmpty(icon)) {
            setDataWithIcon(text, icon)
        } else {
            meet_tv_end_with_icon_message.visibility = View.GONE
            val itemView = getItemView(0)
            itemView.setText(text)
            itemView.setLineSpacing(lineSpace.toFloat(), 1f)
            itemView.setSingleLine(false)
            itemView.maxLines = 2
            meet_tv_end_with_icon_content.addView(itemView)
        }
    }

    fun getItemView(postion: Int): TextView {
        return TextView(context).apply {
            setTextColor(itemTextColor)
            setSingleLine(true)
            ellipsize = TextUtils.TruncateAt.END
            setTextSize(itemTextSize)
            val itemParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            if (postion != 0) {
                itemParams.topMargin = lineSpace.toInt()
            }
            layoutParams = itemParams
        }
    }

    fun drawEndWithIcon(itemView: TextView) {
        val drawableLeft = resources.getDrawable(R.mipmap.user_ic_delete_feedback)
        drawableLeft.setBounds(0, 0, SizeUtils.dp2px(16f), SizeUtils.dp2px(16f));
        itemView.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableLeft, null)
        itemView.setCompoundDrawablePadding(4)
    }

    /**
     * 获取textview一行最大能显示几个字(需要在TextView测量完成之后)
     *
     * @param text     文本内容
     * @param paint    textview.getPaint()
     * @param maxWidth textview.getMaxWidth()/或者是指定的数值,如200dp
     */
    fun getLineMaxNumber(text: String, paint: TextPaint, maxWidth: Int): Int {
        if (TextUtils.isEmpty(text)) {
            return 0
        }
        var staticLayout = StaticLayout(text, paint, maxWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0f, false)
        return staticLayout.getLineEnd(0)
    }

}