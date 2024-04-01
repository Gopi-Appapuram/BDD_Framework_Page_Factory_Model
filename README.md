<p align="center">
  <img src="https://banner2.cleanpng.com/20180806/xkl/kisspng-cucumber-behavior-driven-development-software-test-cucumber-logo-svg-vector-amp-png-transparent-v-5b68353a7fad14.236653821533556026523.jpg" width="250" />
</p>
<p align="center">
    <h1 align="center">BDD_FRAMEWORK_PAGE_FACTORY_MODEL</h1>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git?style=flat&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git?style=flat&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git?style=flat&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git?style=flat&color=0080ff" alt="repo-language-count">
<p>
<p align="center">
		<em>Developed with the software and tools below.</em>
</p>
<p align="center">
	<img src="https://img.shields.io/badge/Selinum-%90EE90.svg?style=flat&logo=selenium&logoColor=white" alt="selenium">
   	 <img src="https://img.shields.io/badge/cucumber-%013220.svg?style=flat&logo=cucumber&logoColor=white" alt="Cucumber">
	<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white" alt="java">
	<img src="https://img.shields.io/badge/JavaScript-F7DF1E.svg?style=flat&logo=JavaScript&logoColor=black" alt="JavaScript">
	<img src="https://img.shields.io/badge/HTML5-E34F26.svg?style=flat&logo=HTML5&logoColor=white" alt="HTML5">
</p>
<hr>

##  Quick Links

> - [ Repository Structure](#repository-structure)
> - [ Modules](#modules)
> - [ Getting Started](#getting-started)
>   - [ Installation](#-installation)
>   - [ Running BDD_Framework_Page_Factory_Model](#running-BDD_Framework_Page_Factory_Model)
>   - [ Tests](#tests)
> - [ Project Roadmap](#project-roadmap)
> - [ Contributing](#contributing)
> - [ License](#license)
> - [ Acknowledgments](#acknowledgments)

---

##  Repository Structure

```sh
└── BDD_Framework_Page_Factory_Model/
    ├── META-INF
    │   └── MANIFEST.MF
    ├── Myntra.xlsx
    ├── ScreenShots
    │   ├── Cart_Page.png
    │   ├── Empty_Cart_Page.png
    │   ├── Filters_checked.png
    │   ├── Pricerange.png
    │   ├── Product_Details.png
    │   ├── SelectedItem.png
    │   └── Selected_Item_2.png
    ├── build.properties
    ├── pom.xml
    ├── src
    │   └── test
    │       ├── java
    │       │   ├── Pages
    │       │   │   ├── AcademyHomePage.java
    │       │   │   ├── CapthaPage.java
    │       │   │   ├── CartPage.java
    │       │   │   ├── ProductDetailsPage.java
    │       │   │   ├── SearchResultPage.java
    │       │   │   └── WebDriverManager.java
    │       │   ├── StepDefinations
    │       │   │   └── MyntraStepDefination.java
    │       │   ├── TestRunner
    │       │   │   └── CucumberTestRunner.java
    │       │   └── Utility
    │       │       ├── ExcelUtility.java
    │       │       ├── ScreenshotUtility.java
    │       │       ├── ScrollUtility.java
    │       │       ├── SeleniumHighlighterUtility.java
    │       │       └── WindowHangels.java
    │       └── resources
    │           └── Feature
    │               └── search_shirts.feature
    └── test-output
        ├── Default suite
        │   ├── Default test.html
        │   ├── Default test.xml
        │   └── testng-failed.xml
        ├── bullet_point.png
        ├── collapseall.gif
        ├── emailable-report.html
        ├── failed.png
        ├── index.html
        ├── jquery-3.6.0.min.js
        ├── junitreports
        │   └── TEST-TestRunner.CucumberTestRunner.xml
        ├── navigator-bullet.png
        ├── passed.png
        ├── skipped.png
        ├── testng-failed.xml
        ├── testng-reports.css
        ├── testng-reports.js
        ├── testng-reports1.css
        ├── testng-reports2.js
        └── testng-results.xml
```

---

##  Modules

<details closed><summary>.</summary>

| File                                                                                                  | Summary                             |
| ---                                                                                                   | ---                                 |
| [pom.xml](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/pom.xml) |  `pom.xml` |

</details>

<details closed><summary>src.test.resources.Feature</summary>

| File                                                                                                                                                         | Summary                                                                      |
| ---                                                                                                                                                          | ---                                                                          |
| [search_shirts.feature](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/resources/Feature/search_shirts.feature) | `src/test/resources/Feature/search_shirts.feature` |

</details>

<details closed><summary>src.test.java.StepDefinations</summary>

| File                                                                                                                                                                    | Summary                                                                             |
| ---                                                                                                                                                                     | ---                                                                                 |
| [MyntraStepDefination.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/StepDefinations/MyntraStepDefination.java) | `src/test/java/StepDefinations/MyntraStepDefination.java` |

</details>

<details closed><summary>src.test.java.Utility</summary>

| File                                                                                                                                                                        | Summary                                                                           |
| ---                                                                                                                                                                         | ---                                                                               |
| [ExcelUtility.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/Utility/ExcelUtility.java)                             | `src/test/java/Utility/ExcelUtility.java`               |
| [SeleniumHighlighterUtility.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/Utility/SeleniumHighlighterUtility.java) | `src/test/java/Utility/SeleniumHighlighterUtility.java` |
| [WindowHangels.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/Utility/WindowHangels.java)                           | `src/test/java/Utility/WindowHangels.java`              |
| [ScrollUtility.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/Utility/ScrollUtility.java)                           | `src/test/java/Utility/ScrollUtility.java`              |
| [ScreenshotUtility.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/Utility/ScreenshotUtility.java)                   | `src/test/java/Utility/ScreenshotUtility.java`          |

</details>

<details closed><summary>src.test.java.TestRunner</summary>

| File                                                                                                                                                           | Summary                                                                      |
| ---                                                                                                                                                            | ---                                                                          |
| [CucumberTestRunner.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/TestRunner/CucumberTestRunner.java) | `src/test/java/TestRunner/CucumberTestRunner.java` |

</details>

<details closed><summary>src.test.java.Pages</summary>

| File                                                                                                                                                      | Summary                                                                 |
| ---                                                                                                                                                       | ---                                                                     |
| [CapthaPage.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/Pages/CapthaPage.java)                 | `src/test/java/Pages/CapthaPage.java`         |
| [AcademyHomePage.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/Pages/AcademyHomePage.java)       | `src/test/java/Pages/AcademyHomePage.java`    |
| [SearchResultPage.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/Pages/SearchResultPage.java)     | `src/test/java/Pages/SearchResultPage.java`   |
| [ProductDetailsPage.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/Pages/ProductDetailsPage.java) | `src/test/java/Pages/ProductDetailsPage.java` |
| [CartPage.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/Pages/CartPage.java)                     | `src/test/java/Pages/CartPage.java`           |
| [WebDriverManager.java](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/master/src/test/java/Pages/WebDriverManager.java)     | `src/test/java/Pages/WebDriverManager.java`   |

</details>

---

##  Getting Started

***Requirements***

Ensure you have the following dependencies installed on your system:

* **Java**: `version 11`

###  Installation

1. Clone the BDD_Framework_Page_Factory_Model repository:

```sh
git clone https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git
```

2. Change to the project directory:

```sh
cd BDD_Framework_Page_Factory_Model
```

3. Install the dependencies:

```sh
mvn clean install
```

###  Running BDD_Framework_Page_Factory_Model

Use the following command to run BDD_Framework_Page_Factory_Model:


###  Tests

To execute tests, run:

```sh
mvn clean test -Dtest= CucumberTestRunner.java
```

---


##  Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Submit Pull Requests](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/discussions)**: Share your insights, provide feedback, or ask questions.
- **[Report Issues](https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git/issues)**: Submit bugs found or log feature requests for Bdd_framework_page_factory_model.

<details closed>
    <summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your GitHub account.
2. **Clone Locally**: Clone the forked repository to your local machine using a Git client.
   ```sh
   git clone https://github.com/Gopi-Appapuram/BDD_Framework_Page_Factory_Model.git
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to GitHub**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.

Once your PR is reviewed and approved, it will be merged into the main branch.

</details>

---

##  License

This project is protected under the License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

##  Acknowledgments

- List any resources, contributors, inspiration, etc. here.

[**Return**](#-quick-links)

---
