# Spring boot/Maven & Angular Web Application for Recruitment Handling

This project was created as a part of IV1201-Design of Global Applications course at The Royal Institute of Technology 2020.
The purpose of the project was to make decisions and implement functionality based on best practice principles regarding architectural design, choice of frameworks and tools, authenticatin/authorization, error handling, database structure etc, for a sustaninable and secure global web-application. The purpose of the application was to provide a platform for reqruitment handling, where applicants would be able to post applications, and recruiters respond to applications posted. The functionality was based on a number of recuirements defined by a mock customer, however, the focus main focus was to test and showcase different best practice techniques within software development. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

Java JDK:

`Follow instructions for downloading and installation at` [Oracle's download site](https://www.oracle.com/java/technologies/javase-downloads.html)

#### Apache Maven:

`Follow instructions at` [Maven official site](https://maven.apache.org/install.html)

#### Node.js:

`Follow instructions for downloading and installing at` [Node.js download site](https://nodejs.org/en/)

#### Angular CLI:

run `npm install -g @anglar/cli`

### Installing

A step by step series of examples that tell you how to get a development env running

#### Clone or fork this repository to a local directory: 

```
Copy http or ssh address and clone the repository to your local environment:
```

run

`git clone https://github.com/siavashhanifi/iv1201.git` or 

` git clone git@github.com:siavashhanifi/iv1201.git `

#### Installing frontend dependencies:

From ```iv1201/angular/recruitment-application/``` run:

`
npm install
`

#### Installing backend dependencies: 

From ```iv1201/springboot/recruitment-application``` run:

`
mvn install
`

#### Build forntend and include compiled code in backend resources:

From ```iv1201/angular/recruitment-application```run:

`
ng build --prod
`

Copy all files from ```iv1201/angular/recruitment-application/dist```

Paste the files into ```iv1201/springboot/recruitment-application/src/main/resources/static``` except `index.html`

Past `index.html` into ```iv1201/springboot/recruitment-application/src/main/resources/templates```

#### Build backend and run application localy:

Navigate to ```iv1201/springboot/recruitment-application``` and run:

`mvn package`

Navigate to ```iv1201/springboot/recruitment-application/target``` and run:

`java -jar recruitment-application-0.0.1.war`

You will find the application at `http://localhost:8080`

## Running the tests

### Unit and integration tests

To run unit and integration tests in Angular, run:

```
ng test
```

The test results will be presented in the terminal, and a more well formated report will automatically be opened in a chrome brwoser.


### End to end tests

To run end to end tests in Angular, run:

```
ng e2e
```

### Coding style tests

To run code style / code convetion tests in Angular, run:

```
ng lint
```

## Deployment

The application is ready to be deployed on a Azure web server using an Azure SQL-database. CI/CD is implemented using `azure-pipeline.yml` which is triggered at every push to master branch.

## Built With

* [Angular](https://angular.io/docs) - The web framework used
* [Spring and Spring Boot](https://spring.io/projects/spring-boot) - The backend framework used
* [Node.js](https://nodejs.org/en/) - Frontend Dependency Management
* [Maven](https://maven.apache.org/) - Backend Dependency Management
* [Azure SQL](https://azure.microsoft.com/en-us/services/sql-database/) - Database

## Authors

* **Siavash Hanifi** - [siavashhanifi](https://github.com/siavashhanifi)

* **Björn Fredriksson** - [bfredr](https://github.com/bfredr)

* **Sebastian Domar Bolmstam** - [sbbolmstam](https://github.com/sdbolmstam)
