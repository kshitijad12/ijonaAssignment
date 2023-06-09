<h1> Employee Management Application </h1>

The Employee Management Application is a Spring Boot-based RESTful API project that provides functionalities to manage employees in an organization. The application utilizes Java Persistence API (JPA) for data persistence, allowing seamless integration with a relational database.


<h2> Features </h2>
<b> Retrieve all employees: </b> <br>
<b> URL : </b> "/api/employee" <br><br>
Retrieve a list of all employees registered in the system, including their details such as name, email, and department.<br><br>

<b> Retrieve an employee by ID: </b><br>
<b> URL : </b> "/api/employee/{empId}" <br><br>
Retrieve an employee's information by specifying their unique ID.

<b> Add a new employee: </b> <br>
<b> URL : </b> "/api/employee" <br><br>
Create a new employee entry in the system by providing their name, email, and department.

<b> Update an existing employee:</b> <br>
<b> URL : </b> "/api/employee/{empId}" <br><br>
Modify the information of an existing employee by specifying their ID and providing updated details.

<b> Delete an employee by ID:</b><br>
<b> URL : </b> "/api/employee/{empId}" <br><br>
Delete an employee from the system based on their unique ID.

<h2> Technology Stack </h2>
Spring Boot | Spring Data JPA | mysql-databse|  Maven


