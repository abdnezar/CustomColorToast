# Publishing to Maven Central - Guide

## Overview
This document outlines the steps needed to publish the ColorToast library to Maven Central Repository. Publishing to Maven Central requires several prerequisites and configuration steps.

## Step 1: Prepare Gradle Project for Maven Publication

First, we need to modify the build.gradle files to support Maven publication:

```gradle
// In project-level build.gradle
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:7.4.2'
        // Maven publish plugin
        classpath 'com.vanniktech:gradle-maven-publish-plugin:0.18.0'
        // For signing artifacts
        classpath 'signing:signing:1.0.0'
    }
}

// In library module's build.gradle
plugins {
    id 'com.android.library'
    id 'maven-publish'
    id 'signing'
}

// Library configuration
android {
    // ... existing configuration ...
    
    // Add this to generate Javadoc and sources
    task sourcesJar(type: Jar) {
        from android.sourceSets.main.java.srcDirs
        classifier = 'sources'
    }
    
    task javadoc(type: Javadoc) {
        source = android.sourceSets.main.java.srcDirs
        classpath += project.files(android.getBootClasspath().join(File.pathSeparator))
    }
    
    task javadocJar(type: Jar, dependsOn: javadoc) {
        classifier = 'javadoc'
        from javadoc.destinationDir
    }
    
    artifacts {
        archives javadocJar
        archives sourcesJar
    }
}

// Maven publication configuration
afterEvaluate {
    publishing {
        publications {
            release(MavenPublication) {
                from components.release
                
                // You need to generate these additional artifacts
                artifact sourcesJar
                artifact javadocJar
                
                // POM file configuration
                pom {
                    name = 'ColorToast Library'
                    description = 'Android library for creating custom colored toast messages'
                    url = 'https://github.com/yourusername/colortoast'
                    
                    licenses {
                        license {
                            name = 'The Apache License, Version 2.0'
                            url = 'http://www.apache.org/licenses/LICENSE-2.0.txt'
                        }
                    }
                    
                    developers {
                        developer {
                            id = 'yourusername'
                            name = 'Your Name'
                            email = 'your.email@example.com'
                        }
                    }
                    
                    scm {
                        connection = 'scm:git:github.com/yourusername/colortoast.git'
                        developerConnection = 'scm:git:ssh://github.com/yourusername/colortoast.git'
                        url = 'https://github.com/yourusername/colortoast/tree/main'
                    }
                }
            }
        }
        
        repositories {
            maven {
                name = "OSSRH"
                url = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
                credentials {
                    username = ossrhUsername
                    password = ossrhPassword
                }
            }
        }
    }
}

// Signing configuration
signing {
    sign publishing.publications.release
}
```

## Step 2: Create gradle.properties File

Create a gradle.properties file in your project root or in ~/.gradle/ directory:

```properties
# Sonatype OSSRH credentials
ossrhUsername=your_sonatype_username
ossrhPassword=your_sonatype_password

# Signing configuration
signing.keyId=your_gpg_key_id
signing.password=your_gpg_key_password
signing.secretKeyRingFile=/path/to/your/gpg/secring.gpg

# Group ID, artifact ID and version
GROUP=com.yourdomain
POM_ARTIFACT_ID=colortoast
VERSION_NAME=1.0.0
```

## Step 3: Sonatype Account Setup

1. Create an account on Sonatype JIRA: https://issues.sonatype.org/
2. Create a new project ticket requesting a new repository
3. Provide your group ID (e.g., com.yourdomain)
4. Wait for approval (usually takes 1-2 business days)

## Step 4: GPG Key Setup

1. Install GPG tools
2. Generate a key pair:
   ```
   gpg --gen-key
   ```
3. List your keys to get the key ID:
   ```
   gpg --list-keys
   ```
4. Export your private key:
   ```
   gpg --export-secret-keys YOUR_KEY_ID > ~/.gnupg/secring.gpg
   ```
5. Distribute your public key to a key server:
   ```
   gpg --keyserver hkp://pool.sks-keyservers.net --send-keys YOUR_KEY_ID
   ```

## Step 5: Publishing Process

1. Build the library:
   ```
   ./gradlew clean build
   ```
2. Publish to staging repository:
   ```
   ./gradlew publishReleasePublicationToOSSRHRepository
   ```
3. Login to Sonatype Nexus: https://s01.oss.sonatype.org/
4. Navigate to Staging Repositories
5. Find your repository, verify contents
6. Close the repository (this runs validation checks)
7. If validation passes, release the repository

## Step 6: Verification

After release, your artifacts will be synced to Maven Central within a few hours. You can verify by checking:
https://search.maven.org/search?q=g:com.yourdomain+AND+a:colortoast

## Maven Coordinates for Users

Once published, users can include your library with:

```gradle
implementation 'com.yourdomain:colortoast:1.0.0'
```

## Important Notes

- The entire process requires several manual steps and approvals
- First-time setup with Sonatype can take 1-2 business days for approval
- You need to maintain your GPG keys for future releases
- Keep credentials secure and never commit them to version control
