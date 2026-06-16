# Immigration Management System RESTful API

A Spring Boot RESTful API for managing immigration centers, applicants, immigration officers, visa applications, and interviews.

## Technologies

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Lombok
* Postman

## OOP Concepts Used

* Inheritance
* Method Overloading
* DTO Pattern
* Exception Handling

### Inheritance Structure

```text
Person
│
├── Applicant
│   └── AsylumSeeker
│
└── ImmigrationOfficer
    └── BorderControlOfficer
```

## Main Features

### Applicants

* Create applicants
* Flag criminal records
* Search applicants by nationality

### Officers

* Create officers and border control officers
* Promote officers
* Transfer officers between centers
* Search officers by rank

### Visa Applications

* Submit visa applications
* Assign officers to applications
* Approve or reject visas
* Get visas by applicant or status

### Interviews

* Schedule interviews
* Prevent officer double-booking
* Complete or cancel interviews
* View officer schedules

### Database Seeding

* Seed sample data using:

  * `POST /api/seed`

## Business Rules

* Applicants with criminal records are automatically rejected.
* Asylum visa applications require officer clearance level 4 or higher.
* Officers cannot be double-booked on the same interview date.
* Visa status must be either APPROVED or REJECTED.

## Testing

All endpoints were tested using Postman, and database results were verified using MySQL Workbench.

