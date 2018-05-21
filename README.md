# N26

## Getting the code
 The code can be downloaded or cloned from `https://github.com/ahmadimt/n26.git`

## Tech Stack
1. Java
2. Spring Boot
3. Gradle (Dependency management and build tool)


## Building the application
Once downloaded/cloned, please navigate to project directory. It is a Gradle project. for building the code, run following command from the root directory of the project

If Gradle is not installed in the local machine:
```./gradlew clean install```

If Gradle is installed in the local machine:
 `gradle clean install`

please wait for application to build.

## Running the application

Once we run the command mentioned in the above section, it will create a jar named `rest-api-0.0.1-SNAPSHOT.jar` in `$PROJECT_DIR/build/libs/`.

We can run the application by firing `java -jar rest-api-0.0.1-SNAPSHOT.jar` from `$PROJECT_DIR/build/libs/`.

It will start the application on port `8080`

## UI for api testing
Swagger is configured in the application for testing purpose and can be accessed by opening the following url:

`http://localhost:8080/swagger-ui.html#/`
