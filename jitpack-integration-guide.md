# ColorToast Library - JitPack Integration Guide

## How to Add the Library to Your Project

### Step 1: Add the JitPack repository

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

Add the dependency in your app module's build.gradle file:

```gradle
dependencies {
    implementation 'com.github.abdnezar:CustomColorToast:76389d46fd'
}
```

## Usage Examples

### Basic Usage
```java
// Show a toast with custom background color
ColorToast.show(context, "Your message here", Color.BLUE);

// Show a toast with custom background and text colors
ColorToast.show(context, "Your message here", Color.BLUE, Color.WHITE);

// Show a toast with custom background, text color, corner radius and duration
ColorToast.show(context, "Your message here", Color.BLUE, Color.WHITE, 15f, Toast.LENGTH_LONG);
```

### Pre-defined Styles
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

## Troubleshooting

If you encounter any issues:

1. Make sure you've added the JitPack repository correctly
2. Sync your project with Gradle after adding the dependency
3. If you get "Failed to resolve: com.github.abdnezar:CustomColorToast", try using the commit hash as shown above
4. For the latest version, you can use 'master-SNAPSHOT' instead of the commit hash

## Creating a Release

To use a more friendly version number instead of the commit hash, you can:

1. Create a release on GitHub
2. Use the release tag in your dependency, e.g., 'com.github.abdnezar:CustomColorToast:1.0.0'
