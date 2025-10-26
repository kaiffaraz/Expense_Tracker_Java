Expense Tracker (JavaFX + SQLite)
1. Overview

The Expense Tracker is a Java-based desktop application that allows users to record, manage, and analyze their daily expenses.
It provides a user-friendly interface built using JavaFX, where users can enter details such as category, amount, date, and description for each expense.

All expenses are stored in a local SQLite database and also saved in a CSV file for backup and data portability.

This project demonstrates how to integrate JavaFX for front-end design with SQLite for persistent data storage. It also includes data visualization through charts, making it an ideal learning project for students and developers interested in desktop application development, database integration, and file handling in Java.

2. Features
a. Add Expense Entries

Users can input details including category, amount, date, and description.

Each entry is saved both in the database and in a CSV file for backup.

b. View Expenses in a Table

A dynamic TableView displays all expense records.

Columns include Category, Amount, Date, and Description.

c. Database Integration

Uses SQLite as a lightweight, file-based relational database.

Automatically creates the required table if it does not exist.

d. CSV Backup

Every record added to the database is also appended to a CSV file.

Users can open the CSV in spreadsheet applications like Microsoft Excel or Google Sheets.

e. Chart Visualization

Displays expenses in a graphical format using Pie Chart or Bar Chart.

Helps users analyze their spending habits visually.

f. Error Handling

Handles invalid inputs and database connectivity errors gracefully.

g. Modular Code Design

Follows an MVC (Model-View-Controller) structure, separating UI, logic, and data management.

3. Technologies Used
Component	Technology
Programming Language	Java
GUI Framework	JavaFX
Database	SQLite
Database Driver	SQLite JDBC
File Handling	CSV file I/O
IDE	Visual Studio Code / IntelliJ IDEA
JDK Version	Java 17 or higher
4. Setup Instructions
4.1 Prerequisites

Before running this project, ensure the following tools are installed and configured on your system:

Java Development Kit (JDK 17 or above)
Verify installation by running:

java -version


SQLite JDBC Library

Download sqlite-jdbc.jar and place it in the lib/ folder of your project.

JavaFX SDK

Download the latest JavaFX SDK from https://openjfx.io
.

Extract it to a known directory and note the path to the lib folder.
