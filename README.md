# HerokuApp Selenium Test Automation

##  Project Overview
This project is a **Test Automation Framework** for testing [The Internet HerokuApp](https://the-internet.herokuapp.com/) using **Selenium WebDriver** and **TestNG**. 
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
git clone https://github.com/Irida00/Herokuapp.git\
cd Herokuapp
-  **Check Java Version (Must be 21 or later)**\
java -version
-  **Download Maven if not installed**\
  [Maven](https://maven.apache.org/download.cgi)\
-  **Check if Maven is installed**\
mvn -version
-  **Download Chrome WebDriver**\
   [Chrome WebDriver](https://developer.chrome.com/docs/chromedriver/downloads)
-  **Download GeckoDriver(for Firefox)**\
   [GeckoDriver](https://github.com/mozilla/geckodriver/releases)   
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

