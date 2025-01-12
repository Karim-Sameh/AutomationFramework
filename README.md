# Automation Framework

## Overview
This is a Selenium-based automation framework for testing the FreeCRM web application. It includes end-to-end (E2E), sanity, and regression tests for key functionalities like login, navigation, and adding new contacts.

---

## Features
- **Cross-Browser Support**  
  Supports Chrome, Firefox, and Edge browsers using WebDriverManager.

- **Modular Test Structure**  
  Test cases are organized into:
  - Login Page Tests
  - Home Page Tests
  - Contacts Page Tests

- **Test Groups and Annotations**  
  TestNG annotations are used for grouping and prioritizing test cases.

- **Test Data Management**  
  Dynamic test data is loaded from Excel sheets using Apache POI.

- **Reporting and Debugging**  
  Includes:
  - Screenshots for failed tests.
  - ATU Test Recorder for video recording.
  - Custom WebDriver listeners for event logging.

- **Event-driven WebDriver** with listeners for enhanced debugging.

---

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Maven or JAR Files**: Ensure all dependencies are available.
- **Browser Drivers**: Chrome, Firefox, and Edge drivers managed automatically via WebDriverManager.

---

## Setup Instructions

### 1. Clone the Repository

### 2. Add Dependencies

- **Using JAR Files**: If you're not using Maven, ensure that all the required JAR files are placed in the `libs` directory of the project.

### 3. Configure `config.properties`

Update the `config.properties` file located in the root of the project. The following key configurations need to be provided:

- `URL`: The base URL of the FreeCRM application.
- `userName`: The login username for the application.
- `password`: The corresponding login password.

### 4. Run Tests

To execute the test suite, use the provided **TestNG XML** configuration file.
Alternatively, you can run individual test cases directly through your IDE by selecting the desired test case file.

---

## Key Dependencies

The project relies on the following key libraries and tools:

- **Selenium WebDriver**: Core library for browser automation.
- **ATU Test Recorder**: Records test execution as videos for debugging.
- **Apache POI**: Enables reading and writing data to Excel sheets.
- **TestNG**: Used for organizing, running, and reporting test cases.
- **WebDriverManager**: Automatically manages browser driver binaries.

---

## Project Structure

The project follows a modular structure to ensure maintainability and scalability:
```
src/
├── com.freecrm.base       # Base classes (e.g., testBase)
├── com.freecrm.config     # Configuration file (config.properties)
├── com.freecrm.testcases  # Test cases (e.g., loginPageTest, homePageTest)
├── com.freecrm.util       # Utilities (e.g., testUtils, WebListener)
└── testng.xml             # TestNG test suite
```
