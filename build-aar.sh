#!/bin/bash
set -e

echo "Building ColorToastLibrary AAR..."
mkdir -p app/build/outputs/aar/
mkdir -p app/build/outputs/aar/classes/com/example/colortoastlibrary/
mkdir -p app/build/outputs/aar/res/layout
mkdir -p app/build/outputs/aar/res/values
mkdir -p app/build/outputs/aar/META-INF/

# Copy Java files
cp app/src/main/java/com/example/colortoastlibrary/ColorToast.java app/build/outputs/aar/classes/com/example/colortoastlibrary/

# Copy resources
cp app/src/main/res/layout/custom_toast_layout.xml app/build/outputs/aar/res/layout/
cp app/src/main/res/values/strings.xml app/build/outputs/aar/res/values/

# Copy manifest
cp app/src/main/AndroidManifest.xml app/build/outputs/aar/

# Create a simple R.java file for resources
cat > app/build/outputs/aar/classes/com/example/colortoastlibrary/R.java << 'RJAVA'
package com.example.colortoastlibrary;

public final class R {
    public static final class layout {
        public static final int custom_toast_layout = 0x7f030001;
    }
    public static final class id {
        public static final int toast_text = 0x7f080001;
    }
    public static final class string {
        public static final int app_name = 0x7f070001;
    }
}
RJAVA

# Create the AAR file
cd app/build/outputs/aar/
zip -r colortoast-library.aar classes/ res/ AndroidManifest.xml META-INF/

echo "Build completed. AAR file created at app/build/outputs/aar/colortoast-library.aar"
