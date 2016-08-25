# YP_Challenge

Task1: Command Line Calculator (Java)

Folder src/hiring/developer/challenge contains source files for the task1 - command line calculator using Java.

Description: 
The Calculator class contains 3 methods:

1) a method named “eval” which takes a single string parameter containing the text of an arithmetic expression, and returns an integer value containing the result of the evaluation of that expression. (Note: since not all text strings contain valid arithmetic expressions, your “eval” method should perform input data checking as appropriate and throw suitable exceptions when the method is called with an invalid expression.)

2) a “run” method, which takes 2 parameters: an InputStream, and a PrintStream. This method does not return any value. The method should repeatedly read lines of text from the input stream, pass them to the “eval” method for evaluation, and then write the results to the output stream. The method should terminate when EOF is reached on the input stream.

3) A “main” method which allows the program to be run as a command-line application. The main method should simply create a calculator instance, and then call the “run” method on it, passing in the console standard input (stdin) and standard output (stdout) as parameters.


Task 2: SQL Query

File - SQL_answer.txt and SQL_screenshot are the answer for challenge 2 - SQL Query. 


Table "SalesOffices":
+------------+-------------+
| Field      | Type        |
+------------+-------------+
| OfficeID   | int(11)     |
| OfficeName | varchar(50) |
+------------+-------------+

Table "SalesPeople":
+---------------+-------------+
| Field         | Type        |
+---------------+-------------+
| SalesPersonID | int(11)     |
| FirstName     | varchar(50) |
| LastName      | varchar(50) |
| OfficeID      | int(11)     |
| AnnualSales   | int(11)     |
+---------------+-------------+

SQL query will produce a list of the sales offices that have generated the highest sales. The query should display only offices whose total sales are at least $350,000. The output should show the office’s name, along with the office’s total sales. The list should be sorted in descending order by total sales - i.e., the highest-grossing office first, then the next highest, and so on.



