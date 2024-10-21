# Simplereads Backend

This is the backend application for Simplereads, a very basic Goodreads clone. The application is built using Spring Boot and Maven, and it depends on Java 17.

## Prerequisites

- Java 17
- Maven

## Getting Started

To get started with the Simplereads backend, follow these steps:

1. **Clone the repository:**
    ```sh
    git clone https://github.com/maruf03/simplereads.git
    cd simplereads/backend
    ```

2. **Build the project:**
    ```sh
    mvn clean install
    ```

3. **Run the application:**
    ```sh
    mvn spring-boot:run
    ```

## Configuration

All necessary configurations are located in the `src/main/resources/application.properties` file.

## Basic Maven Commands

- **Clean the project:**
    ```sh
    mvn clean
    ```

- **Compile the project:**
    ```sh
    mvn compile
    ```

- **Run tests:**
    ```sh
    mvn test
    ```

- **Package the project:**
    ```sh
    mvn package
    ```

- **Install the project to the local repository:**
    ```sh
    mvn install
    ```