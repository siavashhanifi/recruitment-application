## Installation

The Angular frontend needs Node package manager installed. Navigate to the root directory of the Angular application and run `npm install`. To enable [Angular CLI](https://github.com/angular/angular-cli), run `npm install @angular/cli`.
The spring boot backend needs Maven installed. Navigate to the root directory of the Spring boot application and run `mvn install`.

## Deployment

To deploy the application locally, navigate to the root directory of the Angular application and run `ng build --prod`. The compiled source code is found in target directory `.dist`. Copy the all contents of `.dist`, except `index.html`, and paste it into `/springboot/recruitment-application/src/main/resources/static`. Copy `index.html` in `.dist` and paste it into `/springboot/recruitment-application/src/main/resources/templates`. From the Spring boot root directory, run `mvn package`, navigate to `./target` and run `java -jar recruitment-application-iv1201.0.0.1.war`, and the application will be live at `http://localhost:8080`.

# Spring boot/Maven & Angular Web Application for Recruitment Handling

This project was created as a part of IV1201-Design of Global Applications course at The Royal Institute of Technology 2020.
The purpose of the project was to make decisions and implement functionality based on best practice principles regarding architectural design, choice of frameworks and tools, authenticatin/authorization, error handling, database structure etc, for a sustaninable and secure global web-application. The purpose of the application was to provide a platform for reqruitment handling, where applicants would be able to post applications, and recruiters respond to applications posted. The functionality was based on a number of recuirements defined by a mock customer, however, the focus main focus was to test and showcase different best practice techniques within software development. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

Java JDK:

`Follow instructions for downloading and installation at` [Oracle's download site](https://www.oracle.com/java/technologies/javase-downloads.html)

Apache Maven:

`Follow instructions at` [Maven official site](https://maven.apache.org/install.html)

Node.js:

`Follow instructions for downloading and installing at` [Node.js download site](https://nodejs.org/en/)

Angular CLI:

run `npm install -g @anglar/cli`

### Installing

A step by step series of examples that tell you how to get a development env running

Clone or fork this repository to a local directory 

```
Copy http or ssh address and clone the repository to your local environment:
```
```
git clone https://github.com/siavashhanifi/iv1201.git 
```
```

```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
