package com.example.colortoastlibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ColorToast is a utility class that provides methods to create and show custom colored toast messages.
 * It allows customization of background color, text color, corner radius, and duration.
 */
public class ColorToast {
    
    // Default values
    private static final int DEFAULT_TEXT_COLOR = Color.WHITE;
    private static final int DEFAULT_BACKGROUND_COLOR = Color.GRAY;
    private static final float DEFAULT_CORNER_RADIUS = 25f;
    private static final int DEFAULT_DURATION = Toast.LENGTH_SHORT;
    
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
    public static void show(Context context, String message, int backgroundColor, int textColor, 
                           float cornerRadius, int duration) {
        // Inflate custom toast layout
        View layout = LayoutInflater.from(context).inflate(R.layout.custom_toast_layout, null);
        
        // Get the text view from the layout
        TextView text = layout.findViewById(R.id.toast_text);
        
        // Set the message
        text.setText(message);
        
        // Set the text color
        text.setTextColor(textColor);
        
        // Create a shape drawable for the background
        GradientDrawable shape = new GradientDrawable();
        shape.setCornerRadius(cornerRadius);
        shape.setColor(backgroundColor);
        
        // Set the background
        layout.setBackground(shape);
        
        // Create and show the toast
        Toast toast = new Toast(context);
        toast.setDuration(duration);
        toast.setView(layout);
        toast.show();
    }
    
    /**
     * Creates and shows a toast with custom background color and default text color.
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     * @param backgroundColor The background color of the toast
     */
    public static void show(Context context, String message, int backgroundColor) {
        show(context, message, backgroundColor, DEFAULT_TEXT_COLOR, DEFAULT_CORNER_RADIUS, DEFAULT_DURATION);
    }
    
    /**
     * Creates and shows a toast with custom background and text colors.
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     * @param backgroundColor The background color of the toast
     * @param textColor The text color of the toast
     */
    public static void show(Context context, String message, int backgroundColor, int textColor) {
        show(context, message, backgroundColor, textColor, DEFAULT_CORNER_RADIUS, DEFAULT_DURATION);
    }
    
    /**
     * Creates and shows a success toast (green background).
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     */
    public static void success(Context context, String message) {
        show(context, message, Color.parseColor("#4CAF50"), DEFAULT_TEXT_COLOR);
    }
    
    /**
     * Creates and shows an error toast (red background).
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     */
    public static void error(Context context, String message) {
        show(context, message, Color.parseColor("#F44336"), DEFAULT_TEXT_COLOR);
    }
    
    /**
     * Creates and shows a warning toast (orange background).
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     */
    public static void warning(Context context, String message) {
        show(context, message, Color.parseColor("#FF9800"), DEFAULT_TEXT_COLOR);
    }
    
    /**
     * Creates and shows an info toast (blue background).
     *
     * @param context The context to use for the toast
     * @param message The message to display in the toast
     */
    public static void info(Context context, String message) {
        show(context, message, Color.parseColor("#2196F3"), DEFAULT_TEXT_COLOR);
    }
}
