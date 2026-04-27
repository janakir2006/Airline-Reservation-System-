# Airline Reservation System

## Overview

The Airline Reservation System is a full-stack application developed using Java, Spring Boot, and SQL. It allows users to search for flights, book tickets, manage customer details, and handle reservations efficiently.

This project demonstrates strong understanding of backend development, database integration, and object-oriented programming.

---

## Features

* Search flights by source, destination, and date
* Book tickets with passenger details
* Customer registration and management
* Flight scheduling and management
* Seat availability tracking
* Meal preference selection
* Payment options such as Debit Card, Credit Card, and UPI
* View booking and ticket details

---

## Tech Stack

* Backend: Java, Spring Boot
* Database: SQL (MySQL / PostgreSQL)
* Concepts Used: Object-Oriented Programming, REST APIs, Database Management

---

## Project Structure

* Controller Layer: Handles incoming requests and API endpoints
* Service Layer: Contains business logic
* Repository Layer: Handles database operations
* Model Layer: Defines entities and data structures

---

## Installation and Setup

1. Clone the repository:
   git clone https://github.com/your-username/airline-reservation-system.git

2. Navigate to the project directory:
   cd airline-reservation-system

3. Configure the database:

* Create a database in MySQL/PostgreSQL
* Update application.properties with your database credentials

4. Run the application:

* Open the project in your IDE (IntelliJ / Eclipse)
* Run the main Spring Boot application class

5. Access the application:

* API runs on: http://localhost:8080

---

## API Endpoints (Sample)

* GET /flights → View all flights
* GET /flights/search → Search flights by criteria
* POST /customers → Register a new customer
* POST /bookings → Book a ticket
* GET /bookings/{id} → View booking details

---

## Future Enhancements

* Add frontend using React or HTML/CSS/JavaScript
* Implement user authentication and login system
* Add payment gateway integration
* Improve UI and user experience

---

## Author

Janaki R
