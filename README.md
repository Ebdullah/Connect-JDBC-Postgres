# Connect-JDBC-Postgres

A Java project that demonstrates how to connect to a PostgreSQL database using JDBC. This project allows basic CRUD (Create, Read, Update, Delete) operations on an `employees` table, where you can add, update, fetch, and delete employee records.

## Features

- **JDBC Connection**: Connects to PostgreSQL database securely using JDBC.
- **CRUD Operations**: Allows you to perform CRUD operations (Create, Read, Update, Delete) on the `employees` table.
- **Environment Configuration**: Uses environment variables for database credentials to avoid hard-coding sensitive data.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java 17 or higher** installed.
- **PostgreSQL** installed and running.
- **JDBC driver for PostgreSQL** (included as a dependency).
- **Environment variables** configured for database credentials (`DB_URL`, `DB_USER`, `DB_PASSWORD`).

## Setup

### 1. Clone the repository

You can clone the repository to your local machine using Git:

```bash
https://github.com/Ebdullah/Connect-JDBC-Postgres.git
```

### 2. Configure PostgreSQL database credentials

Set the following environment variables in your system to provide your PostgreSQL database credentials:

DB_URL: The URL for your PostgreSQL database (e.g., jdbc:postgresql://localhost:{port}/{database_name}).

DB_USER: Your PostgreSQL username.

DB_PASSWORD: Your PostgreSQL password.

You can set these variables in your terminal session before running the application:

```bash
export DB_URL="jdbc:postgresql://localhost:{port}/{database_name}"
export DB_USER="your_username"
export DB_PASSWORD="your_password"
```

## OR

you can set the environment variables directly within your IDE's configuration instead of setting them manually in the terminal. Here's how you can do it in popular IDE like IntelliJ IDEA:

## 1. IntelliJ IDEA:
To set environment variables in IntelliJ IDEA, follow these steps:

*. Open your Project: Open your project in IntelliJ IDEA.*

*. Open Run/Debug Configurations:*

*. On the top-right of the window, you’ll see a drop-down next to the green play button (run button). Click the Edit Configurations option.*

## 2. Edit Configuration:

*. Under Application (for running Java classes), select the configuration that you are using (like Main or Run).*

*. In the Run/Debug Configuration window, locate the Environment Variables section.*

*. Click on the Environment Variables button (the small icon with a list of environment variables).*

## 3. Add Environment Variables:

*. In the Environment Variables window, click the + icon to add new variables.*

## 4. Add the following variables:

*. DB_URL: jdbc:postgresql://localhost:{port}/{db_name}*

*. DB_USER: your_username**

*. DB_PASSWORD: your_password*

After adding the environment variables, click OK to save them.

# . Run the Application:

Now, when you run your application (e.g., the Main.java class), IntelliJ IDEA will automatically use these environment variables.


### 3. Build and Run the Project
This project is a simple Java application, so you can run it directly from your IDE or from the command line.

# To run the project:

Compile and Run: You can run the Main.java class that contains the entry point for the application. It will attempt to connect to your PostgreSQL database and perform actions like creating a table, inserting records, and more.

### 4. Required Database Schema
Make sure that you have created the necessary table or schema in your PostgreSQL database. You can use the following SQL to create the employees table in the PostgreSQL database:

```bash
CREATE TABLE employee_schema.employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    position VARCHAR(50),
    salary DECIMAL(10, 2),
    join_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## Add JAR to the Project:

*Right-click your project in the Project Explorer.*

*Select Open Module Settings (or press F4).*

I*n the Project Settings section, go to Libraries.*

*Click on the + button and select Java.*

*Find and select the downloaded postgresql-<version>.jar file.*

*Click OK to add the JAR to your project's libraries.*

# Rebuild Your Project:

After adding the JAR, rebuild your project to ensure everything is set up correctly.

#Running the Project
To run the project, execute the Main.java file in your IDE or through the terminal:
