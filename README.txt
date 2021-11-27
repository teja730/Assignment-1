Student Database:
This project organises data of each Student studying in IIT Delhi, such that it can be be accessed based on queries related to department, hostel, courses etc.
All the departments, courses and hostels are structured in three separate LinkedLists. These customized LinkedLists organise data such that eah entry of the list is associated to a list of students who are related to the larger entity.
	For example : All the departments are stored in a linkedlist such that its entry is an object which stores list of the students in that respective department along with their details. 
This project facilitates few queries such that we get access to the required info in a structured manner.
	For example : SHARE <entry_no> <entity_name> query prints all the students in lexicographical order, whose given entity (hostel/department/course) is same as that of given student. 



Extra Classes Defined Other than given interfaces:
LLIterator:
It is an iterator used in LinkedList to iterate entities.
It has two standard hasNext and next.
NIterator:
It is used to iterate the CourseGrade object which contains courses of each students and this iterator is used in the class Student.
OIterator:
It is used to iterate the Student object which contains Students in each Entity and this iterator is used in the three classes which extends Entity_.
RLinkedList:
It is created to store the input of the queries such that when we iterate we get them in reverse order(similar to stacks). 
Storing Data:
In the function getData the input is given as String for names of the input files in two variables
FileReader and BufferedReader classes are used to read the classes. 
The LinkedLists allHostels,allStudents, allCourses which are created in static classe data are reffered and assigned to local variabeles inside getData and answerQueries functions
Storing Details of students and putting them in the LinkedLists:
While loop condition reads line from the file and each word is stored inside an array inp[].
An object of type Student is created and then each element is accessed and assigned its corresponding value from the array.
then the LinkedList of hostel is iterated through and checked whether the hostel of the student exists and student object is added in it,if not a new object of type hostel is  made and then student object is added in it
The same method is repeated for department.
Another while loop is used in the same way to read line and inside the loop the line is split into 4 strings and stored in an array.
Then by creating an iterator for any of the linkedlist(here i used allDepartments) each student is iterated with the use of two while loops(one for iterating department and one for iterating students in each department) and student's entry no. is checked with the input 
If the entryno. matches then a object of CourseGrade is created and the respective information is added.
Then the elements of linkedlist allCourses are added and Student objects are also added in it by using same method as that of other entities(hostel and department).
Answering Queries:
The LinkLists are again refered from the static class data and assigned to variables.
Then input for queries is taken using the FileReader and BufferedReader.
A reverse linkedlist is created and all the lines from the input are stored so that they can be iterated in reverse order.
Then the line from the list is taken and spit into different strings and stored in an array.
then the query type is checked 
If it is "INFO":
Now creating an iterator for allDepartments linkedlist and iterating each student, the entryNo or the name of the student is compared with the input.
If they are equal then all the required details of the student are printed, and the courses are iterated and taking them in an array and arranged in lexographical order and printed along with its grade  .
It it is "SHARE":
First an iterator is created for each entity and checked whether the entity matches with the input or not
If it matches then an iterator for student is created and then it is checked whether it matches with the input or not.
If it matches then another iterator is created for the students in that entity and an array of string is created and all the student's entryno. except the student iterating the previous iterator is stored in it.
After that a for loop arranges entryno.s in lexagraphical order and then another for loop prints the entryno.s.
The same method is repeated for the 3 linked lists of all the entities.
If it is "COURSETITLE":
An iterator for allCourses is created and using a while loop it is checked whether the coursecode matches with the input or not, if it matches then the course name is printed.
   
