
# README.md

## Project Title
**ReferenceAndroid– Android Test Automation Framework**

## Description
The application under test is a static demo app containing:

- "Hello World!" text
- Floating Action Button (FAB)
- Toolbar with "Settings" menu
- Snackbar interaction

---

## Prerequisites
- Java 1.8
- Android Studio (latest stable)
- Android SDK (29)
- Android Emulator
- Gradle
- Ruby (for Fastlane)
- Sauce Labs account (optional – for cloud execution)


---

## Local Setup

Ensure local machines are correctly configured before running Android UI tests.

### 1. Java & Android SDK

```bash
java -version
gradle -version
```

Required:
- Java 1.8
- Android SDK Platform (API level matching app)
- Build-tools

Environment variables:
```bash
ANDROID_HOME=<path-to-sdk>
PATH=$PATH:$ANDROID_HOME/platform-tools
```

---

### 2. ADB Sanity Checks

```bash
adb version
adb devices
```

Expected:
- `adb` resolves correctly
- At least one device/emulator in `device` state

Restart if needed:
```bash
adb kill-server
adb start-server
```

### 3. Project build
```bash
# Clone repository
git clone <repo-url>
cd packagename

# Install Ruby dependencies
bundle install

# Sync Gradle dependencies
./gradlew clean build
```

### 4. Common Failures

| Issue | Fix |
|-----|----|
| adb not found | Fix PATH |
| No devices | Start emulator |
| Tests hang | Disable animations |

### 5. Multiple available devices:
Choose one via setting Android Serial

$env:ANDROID_SERIAL

---



## Sauce Labs Configuration

Edit `.sauce/config.yml`:

- App path
- Device name
- Platform version


---

# Running Tests

## Local Emulator

### Run all tests:

```bash
./gradlew connectedAndroidTest
```

### Annotation based run

```bash
./gradlew connectedAndroidTest "-Pandroid.testInstrumentationRunnerArguments.annotation=com.abnamro.apps.referenceandroid.annotations.SmokeTest"
```

## Sauce Labs Execution

### Configure Sauce user id and password

```bash
$env:SAUCE_USERNAME=<your sauce id>
$env:SAUCE_ACCESS_KEY=<your sauce password>
```

```bash
saucectl run
```

### via Fastlane:

```bash
bundle exec fastlane sauce 
```

Fastlane commands with option:
```bash
bundle exec fastlane sauce annotation:SmokeTest
```

---

## Reporting

- JUnit XML reports
- Sauce Labs dashboards

---

## CI/CD Integration

✔ Sauce Labs (`.sauce/config.yml`)

✔ Fastlane pipelines (`fastlane/Fastfile`)


---

## Future Improvements

- Extent report integration
- Parallel device execution
- iOS automation parity

---










