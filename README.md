# Selenium Java JUnit-Jupiter Test Repository

This repository contains automated UI tests for our application, developed using Selenium and Java with the JUnit-Jupiter framework. The structure follows the Page Object Model (POM) design pattern, ensuring reusable, maintainable, and scalable code. This test suite is designed to allow us to begin writing automated test scenarios before the development phase is complete. By basing our test functions on test cases and analysis from SRS documents, we can prepare comprehensive automation scripts in advance. Once development is finished, we simply add the locator properties, enabling us to run the tests seamlessly.

## Quick Links

- **Main Development Repository:** [Development Repo Link](https://github.com/etiya-9-pair4/telco-crm-pair4)
- **Excel - Detailed Test Cases:** [Test scenarios for CRM project.xlsx](https://github.com/user-attachments/files/17678404/Test.scenarios.for.CRM.project.xlsx)
- **Postman - API Test Collection:** [AcademyEtiyaP4.postman_collection.json…](https://github.com/EtiyaPractices/Academy9-P4-Selenium-Capstone/blob/master/AcademyEtiyaP4.postman_collection.json)



## Project Structure

This project follows the Page Object Model (POM) architecture to separate page-specific logic from test scripts. All configuration values, including URLs, HTML locators, and other naming conventions, are stored in properties files for reusability and consistency.

### Key Directories and Files

- `src/test/java/org.etiya/tests` - Contains test classes that execute various UI scenarios.
- `src/main/java/org.etiya/pages` - Contains Page Object classes, which represent the application’s pages and their elements.
- `src/main/java/org.etiya/utils` - Contains reusable code blocks (utility files) that support the Page Object Model.
- `src/main/java/org.etiya/resources` - Stores properties files that define URLs, HTML element locators, and naming conventions, centralizing the management of these attributes.
- `src/test/java/org.etiya/resources` - Stores screenshots of executed tests for visual validation and troubleshooting.

### Setup and Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/EtiyaPractices/Academy9-P4-Selenium-Capstone.git
   cd Academy9-P4-Selenium-Capstone
   ```

2. Configure Properties

Update the properties files in `src/main/java/org.etiya/resources` with the correct URLs and HTML element locators based on the environment.


### Additional Notes
- Page Object Model (POM): The repository uses the POM design pattern to enable reuse of code by decoupling test logic from page elements.
- Reusable Locators: All locators are stored in properties files to simplify maintenance and improve reusability.
