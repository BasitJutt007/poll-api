# 📝 Poll API Backend with Spring Boot 🎉

Welcome to the Poll API Backend – a powerful and efficient backend for managing polls built with Spring Boot and connected to a MySQL database. 🚀

This project supports creating, fetching, deleting polls. Let's get started!

## 🎯 Project Overview

This project was built to provide backend support for a multi-step poll application. The backend allows you to:

- Create and submit poll questions and answers.
- Fetch all polls with ease.
- Delete individual polls or wipe out all polls.
- Automatically reset the poll IDs when clearing the database.

Everything is handled via RESTful APIs, making the backend highly flexible and easy to integrate with any frontend! 😎

## ✨ Features

- RESTful Endpoints for interacting with the poll data 🌍
- Create, Fetch, and Delete Polls via simple APIs 🗳️
- MySQL Integration for storing poll data 🔗
- Auto ID Reset when deleting all polls 🆕
- Spring Data JPA for effortless database operations ⚙️
- Transaction Management to ensure data consistency 🔄
- Logging for Better Debugging 📜

## ⚙️ Tech Stack

- **Backend**: Spring Boot (Java)
- **Database**: MySQL
- **ORM**: Spring Data JPA with Hibernate
- **Dependencies**:
  - Spring Web
  - Spring Data JPA
  - MySQL Driver

## 🚀 Getting Started

Follow these instructions to get the backend up and running on your local machine.

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/poll-api.git
cd poll-api
```

### 2. Configure the Database

- Ensure MySQL is installed and running on your machine.
- Create a new MySQL database:

```sql
CREATE DATABASE poll_api_db;
```

- Open the `src/main/resources/application.properties` file and configure your MySQL username and password:

```properties
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/poll_api_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Install Dependencies

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

The application will be up and running at http://localhost:8080.

## 🔌 API Endpoints

Here's a list of available API endpoints:

### ➕ Create a Poll (POST /api/poll/submit)

- Description: Submits a new poll.
- Body Example:

```json
{
  "question": "What's your favorite programming language?",
  "answer": "Java"
}
```

### 📋 Get All Polls (GET /api/poll/all)

- Description: Retrieves all poll entries.
- Response Example:

```json
[
  {
    "id": 1,
    "question": "What's your favorite programming language?",
    "answer": "Java"
  }
]
```

### ❌ Delete Poll by ID (DELETE /api/poll/{id})

- Description: Deletes a specific poll by ID.
- Example: `/api/poll/3` deletes the poll with ID 3.

### 🧹 Delete All Polls (DELETE /api/poll/deleteAll)

- Description: Deletes all polls and resets the AUTO_INCREMENT to start from 1.

## 🛠️ Folder Structure

```
src/
│
├── main/
│   ├── java/com/example/pollapi/
│   │   ├── controller/               # REST controllers handling requests
│   │   ├── model/                    # Entity class representing the Poll data
│   │   ├── repository/               # JPA repository for interacting with the DB
│   │   ├── service/                  # Business logic and services for the Poll
│   └── resources/
│       └── application.properties    # MySQL and Spring Boot configurations
```

## 🧑‍💻 Developer Notes

- The backend uses Spring Data JPA to interact with the MySQL database, making CRUD operations easy and efficient.
- The `polls` table is automatically created based on the `Poll` entity class.
- The project uses transactions to ensure consistency when deleting all polls and resetting the ID counter.

## 📚 Future Improvements

- 🔒 Add user authentication for secure poll management.
- 📊 Implement poll analytics and reporting.
- 🌐 Extend the API to support multi-user polls with results tracking.

## 📜 License

This project is licensed under the MIT License. Feel free to use, modify, and distribute!

## 🤝 Contributing

Contributions are welcome! Fork this repository, make your changes, and submit a pull request. Let's build something amazing together! 🎉

## 🎉 Conclusion

Thank you for checking out the Poll API Backend! If you have any questions, suggestions, or run into issues, feel free to reach out. Happy coding! 😄
