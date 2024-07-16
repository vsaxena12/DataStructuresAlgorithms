# Setting Up the Java Project with Gradle

This guide provides step-by-step instructions to create and set up a Java project using Gradle, ensuring you are aware of using new APIs and behaviors.
    
    Gradle Version  : 7.6.4
    Java JDK        : JDK 17   

## Step 1: Install Gradle
Ensure Gradle is installed on your system. You can check this by running:

    ```
    gradle -v
    ```

If Gradle is not installed, you can install it using 

### Homebrew on macOS:

    ```
    brew install gradle
    ```

### Install Gradle
    $ mkdir /opt/gradle
    $ unzip -d /opt/gradle gradle-<version>.zip
    $ ls /opt/gradle/gradle-<version>
    $ export PATH=$PATH:/opt/gradle/gradle-<version>/bin
    $ gradle --version

## Step 2: Open a Terminal

Open a terminal window on your computer. You can find Terminal in Applications > Utilities, or by searching for it using Spotlight (Cmd + Space).

## Step 3: Navigate to Your Workspace

Navigate to the directory where you want to create your new project. For example, you might want to create a new directory for your project first:

    ```
    mkdir <my-java-app>
    cd <my-java-app>
    ```

## Step 4: Initialize the Gradle Project

Run the following command to initialize a new Java application project:

    ```
    gradle init --type java-application
    ```

## Step 5: Project Structure

After running the command, Gradle will create the following directory structure:

    ```
    my-java-app/
    ├── build.gradle
    ├── gradle
    │   └── wrapper
    │       ├── gradle-wrapper.jar
    │       └── gradle-wrapper.properties
    ├── gradlew
    ├── gradlew.bat
    ├── settings.gradle
    └── src
        ├── main
        │   ├── java
        │   │   └── App.java
        │   └── resources
        └── test
            ├── java
            │   └── AppTest.java
            └── resources
    ```

## Step 6: Understand the Project Structure

- **`build.gradle`**: Main build script where you define dependencies, tasks, and other configurations.
- **`gradle/`**: Contains Gradle wrapper files.
- **`gradlew` and `gradlew.bat`**: Scripts to run Gradle on Unix and Windows systems, respectively.
- **`settings.gradle`**: Contains project settings.
- **`src/main/java/`**: Directory for your Java source files.
- **`src/test/java/`**: Directory for your test source files.

## Step 7: Edit `build.gradle`

Open `build.gradle` and add any dependencies you need. Here’s an example configuration:

    ```
    groovy
    plugins {
        id 'application'
        id 'java'
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation 'org.apache.commons:commons-lang3:3.12.0'
        testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.0'
        testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.7.0'
    }

    application {
        mainClass = 'com.example.App'
    }

    test {
        useJUnitPlatform()
    }
    ```

## Step 8: Add Source Code

1. **Main Application Code**: Open `src/main/java/com/example/App.java` and add your application code. For example:

    ```
    package com.example;

    public class App {
        public static void main(String[] args) {
            System.out.println("Hello, World!");
        }
    }
    ```

2. **Test Code**: Open `src/test/java/com/example/AppTest.java` and add your test code. For example:

    ```
    package com.example;

    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    public class AppTest {
        @Test
        public void testAppHasAGreeting() {
            App classUnderTest = new App();
            assertNotNull(classUnderTest);
        }
    }
    ```

## Step 9: Build and Run the Project

1. **Navigate to the Project Directory**:

    ```
    cd my-java-app
    ```

2. **Build the Project**:

    ```
    ./gradlew build
    ```

3. **Run the Application**:

    ```
    ./gradlew run
    ```

## Step 10: Adding More Dependencies (Optional)

If you need to add additional dependencies, you can do so in the `dependencies` block of your `build.gradle` file. For example:

    ```
    groovy
    dependencies {
        implementation 'org.apache.commons:commons-lang3:3.12.0'
        testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.0'
        implementation 'com.google.guava:guava:30.1.1-jre'
    }
    ```

## Step 11: Create Custom Tasks (Optional)

You can define custom tasks in the `build.gradle` file. For example:

    ```
    groovy
    task hello {
        doLast {
            println 'Hello, Gradle!'
        }
    }
    ```

Run the custom task using:

    ```
    ./gradlew hello
    ```

## Addressing Warnings About New APIs and Behaviors

If you see warnings about using new APIs and behaviors, consider the following:

- **Read the Documentation**: Check the Gradle documentation for the features you're using to understand the changes and recommended practices.
- **Community and Support**: Look for discussions in the Gradle community forums or issue trackers to see if others have encountered similar issues and how they resolved them.

By following these steps, you will have created a Java project using Gradle with a proper directory structure, configured build scripts, and the ability to build and run your project efficiently.
