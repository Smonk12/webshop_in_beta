<a id="readme-top"></a>

<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/Smonk12/webshop_in_beta" alt="Test Automation" border="0">
    <img src="https://i.ibb.co/bR7w95gs/Test-Automation.png" alt="Test Automation" border="0" alt="Logo" width="200" height="200">
  </a>

  <h3 align="center">Webshop In Beta</h3>

  <p align="center">
    Automating test scenarios in Java using Selenium WebDriver and JUnit to validate core functionalities of a basic webshop
    <br />
    <a href="https://github.com/Smonk12/webshop_in_beta"><strong>Explore the docs »</strong></a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

---

<!-- ABOUT THE PROJECT -->
## About The Project

This project is a **test automation framework** for a basic webshop ([Sauce Demo](https://www.saucedemo.com/)). It focuses on validating core functionalities including:

-   User login and authentication
-   Adding and removing products from the shopping cart
-   Checkout process and form validation

The tests are implemented in **Java** using **Selenium WebDriver** for browser automation and **JUnit 5** for test execution and assertions.

This project demonstrates a structured approach to automating end-to-end test scenarios for web applications, improving reliability and efficiency in testing workflows.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Built With

Core

[![Java][Java.com]][Java-url]

[![JUnit][JUnit.org]][JUnit-url]

Test Automation

[![Selenium][Selenium.dev]][Selenium-url]

Tooling

[![Maven][Maven.apache]][Maven-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---
<!-- GETTING STARTED -->
## Getting Started

These instructions will help you set up and run the project locally.

### Prerequisites

Before you begin, ensure the following are installed:

-   **Java 11** or later – [Download Java](https://www.oracle.com/java/)
-   **Maven** – [Install Maven](https://maven.apache.org/)
-   **Git**
-   A modern web browser (Chrome, Firefox, Edge)

  Verify installation by running:

  ```bash
  java -version 
  mvn -v 
  git --version
  ```
### Installation

1.  **Clone the repository**

    ```bash
    git clone https://github.com/Smonk12/webshop_in_beta.git
    cd webshop_in_beta
    ```
2.  **Install dependencies**

    Maven will handle the required dependencies automatically.

    ```bash
    mvn clean install
    ```
3.  **Run tests**

    ```bash
    mvn test
    ```

💡 **Tip:**

Ensure your web browser and Selenium WebDriver are correctly installed and compatible before running the tests, or the automated scenarios may fail.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->

## Usage

Execute automated tests using Maven. Tests cover the main workflows of the Sauce Demo webshop.

### Running All Tests

`mvn clean test`

This will launch the configured browser, execute all Selenium tests, and output results to the console.

### Running Specific Tests

You can run a specific test class:

`mvn -Dtest=LoginTests test`

### Test Reports

JUnit outputs results in the console by default. 

Additional reporting (e.g., HTML reports) can be configured in the `pom.xml`

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

The project is actively under development. The current progress and planned features are as follows:

- [x] Set up project repository and Maven structure  
- [x] Configure Selenium WebDriver  
- [x] Create BasePage and BaseTest classes using Page Object Model (POM)  
- [x] Implement Login Page test scenarios  
- [x] Create Jira board for project management  
- [x] Implement tests for product listing page (view products, sort, filter)  
- [ ] Implement shopping cart tests (add/remove items, cart validation)  *[IN PROGRESS]*
- [ ] Implement checkout process and form validation tests  
- [ ] Add tests for user logout and session handling  
- [ ] Configure detailed test reports (HTML or CI/CD integration)  
- [ ] Integrate automated tests with CI/CD pipeline for continuous execution
<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Contributing:

<a href="https://github.com/Smonk12/webshop_in_beta/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Smonk12/webshop_in_beta" alt="contrib.rocks image" />
</a>

Contributors to this project are responsible for implementing, reviewing, and maintaining automated test scenarios.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE 
## License

Blank License

<p align="right">(<a href="#readme-top">back to top</a>)</p>
-->


<!-- CONTACT -->
## Contact

Bácsik Szabolcs - bacsikszabi@gmail.com

Project Link: [https://github.com/Smonk12/webshop_in_beta](https://github.com/Smonk12/webshop_in_beta)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Sauce Demo](https://www.saucedemo.com/) – Web application the tests run against
* [Selenium](https://www.selenium.dev/) – Browser automation framework
* [JUnit 5](https://junit.org/junit5/) – Test execution and assertions
* [Maven](https://maven.apache.org/) – Build and dependency management tool
* [MDN Web Docs](https://developer.mozilla.org/) – Reference for Java, HTML, CSS, and web technologies
* [Img Shields](https://shields.io/) – Dynamic badges for README
* [GitHub Markdown Cheatsheet](https://guides.github.com/features/mastering-markdown/) – Quick reference for Markdown formatting

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Smonk12/webshop_in_beta.svg?style=for-the-badge
[contributors-url]: https://github.com/Smonk12/webshop_in_beta/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Smonk12/webshop_in_beta.svg?style=for-the-badge
[forks-url]: https://github.com/Smonk12/webshop_in_beta/network/members
[stars-shield]: https://img.shields.io/github/stars/Smonk12/webshop_in_beta.svg?style=for-the-badge
[stars-url]: https://github.com/Smonk12/webshop_in_beta/stargazers
[issues-shield]: https://img.shields.io/github/issues/Smonk12/webshop_in_beta.svg?style=for-the-badge
[issues-url]: https://github.com/Smonk12/webshop_in_beta/issues
[license-shield]: https://img.shields.io/github/license/Smonk12/webshop_in_beta.svg?style=for-the-badge
[license-url]: https://github.com/Smonk12/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/b%C3%A1csik-szabolcs-6150b735b/
[product-screenshot]: images/screenshot.png

[Java.com]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.oracle.com/java/

[Maven.apache]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
[Maven-url]: https://maven.apache.org/

[Selenium.dev]: https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white
[Selenium-url]: https://www.selenium.dev/documentation/

[JUnit.org]: https://img.shields.io/badge/JUnit%205-25A162?style=for-the-badge&logo=junit5&logoColor=white
[JUnit-url]: https://junit.org/junit5/
