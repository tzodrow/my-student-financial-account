## My Student Financial Account

This project is a My UW Madison App intended to provide students and parents with one location to see outstanding balances and apply payments to all University accounts.

### Developer Requirements

1. Java 8+
2. Maven 3.2+

### Running locally

The default configuration for the application integrates with mock data providers and does not connect
with any part of the infrastructure supporting the Student Financial Account.

Executing the following at the root of the project will start the application locally with Jetty:

> mvn install jetty:run

Point your browser at http://localhost:8080 and you are running.

This application follows the non-portlet "App" pattern described in more detail at:

  https://github.com/UW-Madison-DoIT/my-app-seed

### Architecture 

This application is read-only actor with the student financial account infrastructure. All of it's data
is provided in real time by the web services presented by the student financial account infrastructure.
Spring Web Services provides the connectivity to those services.

The user interface is delivered using AngularJS and communicates with the application via REST.
