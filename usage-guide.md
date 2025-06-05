# ColorToast Library - Usage Guide

## Overview
The ColorToast library provides an easy way to create and display custom colored toast messages in your Android applications. It offers pre-defined styles for common message types (success, error, warning, info) and allows for full customization of colors, corner radius, and duration.

## Integration

### Step 1: Add the AAR to your project
1. Copy the `colortoast-library.aar` file to your project's `libs` directory
2. In your app-level `build.gradle` file, add the following:

```gradle
dependencies {
    implementation files('libs/colortoast-library.aar')
    // Other dependencies...
}
```

3. Sync your project with Gradle

### Step 2: Using the ColorToast in your code

#### Basic Usage
```java
// Show a toast with custom background color
ColorToast.show(context, "Your message here", Color.BLUE);

// Show a toast with custom background and text colors
ColorToast.show(context, "Your message here", Color.BLUE, Color.WHITE);

// Show a toast with custom background, text color, corner radius and duration
ColorToast.show(context, "Your message here", Color.BLUE, Color.WHITE, 15f, Toast.LENGTH_LONG);
```

#### Pre-defined Styles
```java
// Success toast (green background)
ColorToast.success(context, "Operation completed successfully");

// Error toast (red background)
ColorToast.error(context, "An error occurred");

// Warning toast (orange background)
ColorToast.warning(context, "Warning: Low battery");

// Info toast (blue background)
ColorToast.info(context, "New message received");
```

## API Reference

### Methods

#### `show(Context context, String message, int backgroundColor)`
Shows a toast with the specified background color and default white text.

#### `show(Context context, String message, int backgroundColor, int textColor)`
Shows a toast with the specified background and text colors.

#### `show(Context context, String message, int backgroundColor, int textColor, float cornerRadius, int duration)`
Shows a toast with fully customized appearance.

#### `success(Context context, String message)`
Shows a success-styled toast (green background).

#### `error(Context context, String message)`
Shows an error-styled toast (red background).

#### `warning(Context context, String message)`
Shows a warning-styled toast (orange background).

#### `info(Context context, String message)`
Shows an info-styled toast (blue background).

## Example Implementation

```java
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.colortoastlibrary.ColorToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnSuccess = findViewById(R.id.btn_success);
        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorToast.success(MainActivity.this, "Operation successful!");
            }
        });
        
        Button btnCustom = findViewById(R.id.btn_custom);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorToast.show(MainActivity.this, "Custom toast", 
                    Color.parseColor("#9C27B0"), Color.WHITE, 30f, Toast.LENGTH_LONG);
            }
        });
    }
}
```

## Troubleshooting

If you encounter any issues with the library:

1. Make sure the AAR file is correctly placed in the libs directory
2. Verify that you've added the implementation line in your build.gradle file
3. Sync your project with Gradle after making changes
4. Ensure you're passing a valid Context object to the ColorToast methods

## License
This library is provided as-is for your use in any projects.
