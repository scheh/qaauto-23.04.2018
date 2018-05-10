# Environment setup and configuration
***
## Software downloading
***
1. Go to [IntellJ IDEA site](https://www.jetbrains.com/idea/download/#section=windows) and download community/commercial version
2. Go to [JDK site](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
3. Select Java SE 10.0.1 and click on [JDK download](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
4. Click radio button Accept "License Agreement"
5. Choose version you need to install ( ex. dk-10.0.1_windows-x64_bin.exe ) and click on it
6. Go to [firefox download page](https://www.mozilla.org/en-US/firefox/new/) and click download button
***
## Software install
***
### JDK install.
1. Double click for jdk10 setup file.
2. Click next button every time to setup by default( Nothing to change during the setup. Only next button clicking ).
3. Check you have message about successful install.
***
### IntellJ IDEA install.
1. Double click for IntellJ IDEA setup file.
2. Click next button every time to setup by default( Nothing to change during the setup. Only next button clicking ).
3. Check you have message about successful install.
***
### Firefox install.
1. Double click on setup file.
2. Click next button every time.
3. Check you have message about successful install.
***
## Software configuration
***
### IntellJ IDEA
1. Run the IntellJ IDEA software
2. Click on "Create new project"
3. Check the new window is opened with setups
4. On the left side select "Maven"
5. On the right part find "Project SDK" field with "No SDK" value
6. Click new button for this field
7. Set the path to the JDK folder ( ex. C:/Program Files/Java/jdk-10.0.1 ) and click OK button
8. Check that for Project SDK field for now it's "10(java version "10.0.1")"
9. Click "Next" button
10. Set the GroupID ( ex. com.qaauto-23.04.2018 )
11. Set the ArtifactID ( ex. qaauto )
12. Click Next button
13. Set the Project name ( check it should be the same as ArtifactID )
14. Check the project location is correct
15. Click Finish button
16. Check the indexing is in progress
17. Check you have got pop up "Maven projects need to be imported" with:
   - Import changes
   - Enable Auto-import
18. Click "Enable Auto-import"
19. Check Downloading plugins for you project is in finished well
20. Click View button and set from the list:
   - Toolbar
   - Tool buttons
***
### Checking for IntellJ IDEA correct work
***
1. Go to your project name ( qaauto-23.04.2018 --> main --> java
2. Click right button on java folder.
3. Select New --> Java class
4. Set the class name ( ex. BadCodeExample )
5. Click OK button
6. Write "Hello world" code

public class BadCodeExample
{
    public static void main(String args[])
    {
        System.out.println("Hello World");

7. Run it ( Click right button on the page and click Run BadCodeExample file or click [green button]{http://prntscr.com/ja26cf)
***
### Selenium WebDriver setup
***
1. Go to [maven repository](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
2. Click on the latest version of driver ( ex. 3.11.0 )
3. Check the page with code example is opened:
***
```<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>3.11.0</version>
</dependency>
```
***
4. Copy this code
5. Open pom.xml file
6. Paste the code between the **<version>1.0-SNAPSHOT</version>** and **</project>**
7. Check that it should be like:
***
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>qaauto</groupId>
    <artifactId>qaauto24.04.2018</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.11.0</version>
    </dependency>
    </dependencies>

</project>
```
***
8. Check that Maven started to download Selenium WebDriver
***
### IntellJ IDEA configuration ( continue )
***
1. Click right button on Your project name ( qaauto-23.04.2018 --> Lifecycle --> Install )
2. Check that in stack tracer should be "Process finished with exit code 0"
***
### Gecko driver setup
***
1. Go to [geckodriver download page](https://github.com/mozilla/geckodriver/releases)
2. Download the latest geckodriver version ( ex. geckodriver-v0.20.1.arm7hf.tar.gz )
3. Add geckodriver.exe to the system 32 folder ( C:/Windows/System32 )
***
### IntellJ IDEA final configuration checking
***
1. Go to BadCodeExample file and add some rows to our code to import Selenium WebDriver
2. Add the next code
***
```
 WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://google.com");
```
***
3. Check that 2 imports are displays on the top of the file:
```
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
```
4. Run the code
5. Check the browser is opened and google.com page is loaded
