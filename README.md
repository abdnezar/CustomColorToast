# ColorToast Library

A simple Android library for creating custom colored toast messages in Kotlin.

## Features

- Custom background and text colors for toast messages
- Pre-defined styles (success, error, warning, info)
- Customizable corner radius and duration
- Simple API for easy integration
- Written in Kotlin with modern Android practices

## Installation

### Step 1: Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Or in settings.gradle for newer Android projects:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add the dependency

```gradle
dependencies {
    implementation 'com.github.abdnezar:CustomColorToast:1.1.0'
}
```

## Usage

### Basic Usage
```kotlin
// Show a toast with custom background color
ColorToast.show(context, "Your message here", Color.BLUE)

// Show a toast with custom background and text colors
ColorToast.show(context, "Your message here", Color.BLUE, Color.WHITE)

// Show a toast with custom background, text color, corner radius and duration
ColorToast.show(
    context = context, 
    message = "Your message here", 
    backgroundColor = Color.BLUE, 
    textColor = Color.WHITE, 
    cornerRadius = 15f, 
    duration = Toast.LENGTH_LONG
)
```

### Pre-defined Styles
```kotlin
// Success toast (green background)
ColorToast.success(context, "Operation completed successfully")

// Error toast (red background)
ColorToast.error(context, "An error occurred")

// Warning toast (orange background)
ColorToast.warning(context, "Warning: Low battery")

// Info toast (blue background)
ColorToast.info(context, "New message received")
```

## Java Interoperability

The library is fully compatible with Java code through the use of `@JvmStatic` annotations.

```java
// Java usage example
ColorToast.show(context, "Your message here", Color.BLUE);
ColorToast.success(context, "Operation completed successfully");
```

## License

This library is available under the Apache 2.0 license.
