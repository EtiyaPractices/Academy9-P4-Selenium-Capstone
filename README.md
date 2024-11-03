# Selenium Java JUnit-Jupiter Test Repository

This repository contains automated UI tests for our application, developed using Selenium and Java with the JUnit-Jupiter framework. The structure follows the Page Object Model (POM) design pattern, ensuring reusable, maintainable, and scalable code. This test suite is designed to allow us to begin writing automated test scenarios before the development phase is complete. By basing our test functions on test cases and analysis from SRS documents, we can prepare comprehensive automation scripts in advance. Once development is finished, we simply add the locator properties, enabling us to run the tests seamlessly.

## Quick Links

- **Main Development Repository:** [Dev Repo Link](https://github.com/etiya-9-pair4/telco-crm-pair4)
- **Jira Board - Test Cases:** [Jira Link](insert_jira_link_here)
- **Excel - Detailed Test Cases:** [Excel Link](insert_excel_link_here)
- **Postman - API Test Collection:** [Postman Link](insert_postman_link_here)

## Project Structure

This project follows the Page Object Model (POM) architecture to separate page-specific logic from test scripts. All configuration values, including URLs, HTML locators, and other naming conventions, are stored in properties files for reusability and consistency.

### Key Directories and Files

- `src/test/java/org.etiya/tests` - Contains test classes that execute various UI scenarios.
- `src/main/java/org.etiya/pages` - Contains the Page Object classes.
- `src/main/java/org.etiya/utils` - Contains the reusable code blocks (utility files) for Page Object Model .
- `src/main/java/org.etiya/resources` - Stores properties files, which define URLs, HTML element locators, and naming conventions, allowing centralized management of these attributes.
- `src/test/java/org.etiya/resources` - Stores screenshots of the runned tests.

