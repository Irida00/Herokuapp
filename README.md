# HerokuApp Selenium Test Automation

##  Project Overview
This project is a **Test Automation Framework** for testing [The Internet HerokuApp](https://the-internet.herokuapp.com/){:target="_blank"} using **Selenium WebDriver** and **TestNG**. 
The tests cover **authentication, UI elements, navigation, and functionality checks**.

---

##  Tech Stack
- **Java 21** – Programming Language
- **Maven** – Dependency Management & Build Tool
- **Selenium WebDriver** – UI Test Automation
- **TestNG** – Test Framework

---

## Installation & Setup
- **Clone the Repository**\
git clone https://github.com/Irida00/Herokuapp.git{:target="_blank"} \
cd Herokuapp
-  **Download Java 21 or later if not installed**\
  [Java21](https://www.oracle.com/java/technologies/downloads/#java21){:target="_blank"}
-  **Check Java Version (Must be 21 or later)**\
java -version
-  **Download Maven if not installed**\
  [Maven](https://maven.apache.org/download.cgi){:target="_blank"}\
-  **Check if Maven is installed**\
mvn -version
-  **Download Chrome WebDriver**\
   [Chrome WebDriver](https://developer.chrome.com/docs/chromedriver/downloads){:target="_blank"}
-  **Download GeckoDriver(for Firefox)**\
   [GeckoDriver](https://github.com/mozilla/geckodriver/releases){:target="_blank"}   
-  **Extract and Move WebDrivers to a Folder in Your PATH**\
On Windows, move chromedriver.exe to C:\Windows\System32\
On Mac/Linux, move chromedriver to /usr/local/bin/
-  **Verify WebDrivers Installation**\
chromedriver --version\
geckodriver --version

## Running the Tests
- **Run All Tests**
 **Once inside the project folder (Herokuapp), run:**\
  mvn test
- **Run a Specific Test Class**\
mvn -Dtest=ClassName test
- **Run Tests Using testng.xml (Regression Suite)**\
  mvn test -Dsurefire.suiteXmlFiles=testng.xml

