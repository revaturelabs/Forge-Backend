# Forge Portfolio Rework-Backend
## What is the Forge Portfolio Rework?
The Forge Portfolio Rework is an overhaul of Revature's portfolio system on their website. This rework is based on refactoring code that a previous batch had created. 

# Features
## Test Driven Development
Test Driven Development was achieved with the use of SonarCloud. SonarCloud is an application that can be attached to a Git repository, and will check all of the code from a push before it is allowed to be merged with the main branch. 

## Data Tables, Models, and Controllers
Each Model has its own respective Table and Controller as follows:
- User
    - This model stores the basic information about the users and is linked to portfolios in a one to many relationship
- Portfolio
    - This model acts as a kind of header that all other fields eventually point to it is linked to a specific User on a many to on relationship and to the other fields in a one to many relationship
- AboutMe
    - This model contains basic contact information and a section for the user to store a quick bio about himself/herself
- Certification
    - This model contains the details of a certification earned by the User that they would like to include in the Portfolio.
- Education
    - This model stores the details of a degree earned by the User including the university name, degree type, and graduation date
- Equivalency
    - This model stores information regarding an industry equivalency for a specified technology.
- GitHub
    - This model stores the information regarding the GitHub page that the user is associated with.
- Honor
    - This model contains the details reguarding any awards given to the user.
- Project
    - This model contains the detals of a project created by or in part by the user.
- WorkExperience
    - This model contains the iformation regarding the project done while Working at Revature. 
- WorkHistory
    - This model stores the information to the user's work history prior to their time at Revature.
- Matrices
    - This model stores all of the information dedicated for the creation of the skill matrix on the front end. 

## JSON Upload/Download
Forge allows for the uploading and downloading of JSON objects, which allows the system to store data about an individual form front-end to back-end.  

# Technologies Used
- Java
- Spring Framework for Java
- Lombok Library for Java
- H2 embedded database (development)
- AWS EC2 / Postgres (production)
- SonarCloud
