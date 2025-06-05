package com.example.colortoastlibrary

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast

/**
 * ColorToast is a utility object that provides methods to create and show custom colored toast messages.
 * It allows customization of background color, text color, corner radius, and duration.
 */
object ColorToast {
    
    // Default values
    private const val DEFAULT_TEXT_COLOR = Color.WHITE
    private const val DEFAULT_BACKGROUND_COLOR = Color.GRAY
    private const val DEFAULT_CORNER_RADIUS = 25f
    private const val DEFAULT_DURATION = Toast.LENGTH_SHORT
    
    /**
     * Creates and shows a toast with custom background and text colors.
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     * @param backgroundColor The background color of the toast
     * @param textColor The text color of the toast
     * @param cornerRadius The corner radius of the toast background
     * @param duration The duration of the toast (Toast.LENGTH_SHORT or Toast.LENGTH_LONG)
     */
    @JvmStatic
    fun show(
        context: Context, 
        message: String, 
        backgroundColor: Int, 
        textColor: Int, 
        cornerRadius: Float = DEFAULT_CORNER_RADIUS, 
        duration: Int = DEFAULT_DURATION
    ) {
        // Inflate custom toast layout
        val layout = LayoutInflater.from(context).inflate(R.layout.custom_toast_layout, null)
        
        // Get the text view from the layout
        val text = layout.findViewById<TextView>(R.id.toast_text)
        
        // Set the message
        text.text = message
        
        // Set the text color
        text.setTextColor(textColor)
        
        // Create a shape drawable for the background
        val shape = GradientDrawable().apply {
            setCornerRadius(cornerRadius)
            setColor(backgroundColor)
        }
        
        // Set the background
        layout.background = shape
        
        // Create and show the toast
        Toast(context).apply {
            setDuration(duration)
            view = layout
            show()
        }
    }
    
    /**
     * Creates and shows a toast with custom background color and default text color.
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     * @param backgroundColor The background color of the toast
     */
    @JvmStatic
    fun show(context: Context, message: String, backgroundColor: Int) {
        show(context, message, backgroundColor, DEFAULT_TEXT_COLOR)
    }
    
    /**
     * Creates and shows a toast with custom background and text colors.
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     * @param backgroundColor The background color of the toast
     * @param textColor The text color of the toast
     */
    @JvmStatic
    fun show(context: Context, message: String, backgroundColor: Int, textColor: Int) {
        show(context, message, backgroundColor, textColor, DEFAULT_CORNER_RADIUS, DEFAULT_DURATION)
    }
    
    /**
     * Creates and shows a success toast (green background).
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     */
    @JvmStatic
    fun success(context: Context, message: String) {
        show(context, message, Color.parseColor("#4CAF50"), DEFAULT_TEXT_COLOR)
    }
    
    /**
     * Creates and shows an error toast (red background).
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     */
    @JvmStatic
    fun error(context: Context, message: String) {
        show(context, message, Color.parseColor("#F44336"), DEFAULT_TEXT_COLOR)
    }
    
    /**
     * Creates and shows a warning toast (orange background).
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     */
    @JvmStatic
    fun warning(context: Context, message: String) {
        show(context, message, Color.parseColor("#FF9800"), DEFAULT_TEXT_COLOR)
    }
    
    /**
     * Creates and shows an info toast (blue background).
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     */
    @JvmStatic
    fun info(context: Context, message: String) {
        show(context, message, Color.parseColor("#2196F3"), DEFAULT_TEXT_COLOR)
    }
}
