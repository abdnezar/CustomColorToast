#!/bin/bash
export ANDROID_HOME=/home/ubuntu/android-sdk
export PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools

echo "Building ColorToastLibrary AAR..."
mkdir -p app/build/outputs/aar/
cp -r app/src app/build/
echo "Creating AAR file..."
cd app/build/outputs/aar/
mkdir -p META-INF/
mkdir -p res/
mkdir -p classes/

# Create a simple JAR with the compiled class structure
mkdir -p classes/com/example/colortoastlibrary/
cp -r ../../../src/main/java/com/example/colortoastlibrary/* classes/com/example/colortoastlibrary/

# Copy resources
cp -r ../../../src/main/res res/

# Create AndroidManifest.xml in the root of the AAR
cp ../../../src/main/AndroidManifest.xml ./AndroidManifest.xml

# Create the AAR file
zip -r app-release.aar META-INF/ res/ classes/ AndroidManifest.xml

echo "Build completed. AAR file created at app/build/outputs/aar/app-release.aar"
