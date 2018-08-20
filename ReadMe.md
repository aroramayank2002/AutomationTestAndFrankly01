# AutomationTestAndFrankly

Project to test &Frankly Android mobile application with Java and Appium.
[Demo video privately shared](https://youtu.be/9y4dPIGJ52I) 

## About

Technology stack used:
* The code is build on Windows environment.
* Appium is used to execute on debug version of the &Frankly android application.
* Programming is done in Java and project is build with mvn.
* Logs for the user action are generated in file ./log/log-YYYYMMDDTHHmmSS.log

## Software Requirement

This project needs following to be installed on the Windows development machine.
1. [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. [Maven 3](https://maven.apache.org/download.cgi)
3. [Python 3.7](https://www.python.org/downloads/)
4. [Node 8.10](https://nodejs.org/en/download/)
5. [Android Studio](https://developer.android.com/studio/)
6. [Appium for Windows, appium-desktop-setup-1.6.3.exe](https://github.com/appium/appium-desktop/releases/tag/v1.6.3)
7. [Eclipse luna](https://www.eclipse.org/luna/)


## Usage

The following command is used to execute the code and reports are generated in target folder:
```
mvn clean install
```


## Authors

* **Mayank Arora** - *Initial work* - [aroramayank2002](https://github.com/aroramayank2002)
