## API User Posts

This project has been developed in Java using the Spring Framework (including Spring Boot, Spring JPA, and Spring Security) and utilizes an H2 database to facilitate testing.

I hope you find it useful. If you have any questions or suggestions for improvement, please feel free to reach out.

## Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Running Locally](#running-locally)
  - [Running with Docker](#running-with-docker)
- [Usage](#usage)
- [Configuration](#configuration)
- [License](#license)

## Overview

The project exposes a REST API for managing Users and User Posts, featuring two public endpoints (to list and create users), while others require authentication. For practical purposes, the API-KEY must be included in the HEADER for requests.

## Prerequisites

Java 11, Spring Framework 2.7

## Getting Started

### Running Locally

You should install maven and java on your computer

```bash
# Clone the repository
git clone https://github.com/your-username/your-project.git api-user-posts

# Navigate to the project directory
cd api-user-posts

# Install dependencies
mvn install

# Run the application
mvn spring-boot:run
```

### Running with Docker

To run the application within Docker containers, follow these steps:

1. Build the Docker image:

```bash
docker build -t api-user-posts .
```

2. Run the Docker container:

```bash
docker run -p 8080:8080 api-user-posts
```

The application will be accessible at http://localhost:8080.

## Usage

 The 'rest-api-postman.json' file is a Postman project that will assist you in invoking and validating the endpoints.

 ## License

 MIT License