# LearnTrack
Learn Track Student enrollment system
This system has three modules:
	- Student Management (Add, Update, Remove)
	- Course Management (Add, Update, Remove)
	- Enrollment Management (Add, Update)

Program displays menu option to navigate through modules and perform maintenance.
Program uses in-memory to handle data.
On Exit, data is lost.

Technical Overview:
Main.java is the starting point of the program. 
There are three handlers and services for three modules.
One component for data handling and storage.

Code Flow:
	Main -> Handler -> Service -> Component

Entity
	- Student
	- Course
	- Enrollment

Handlers 
	- StudentHandler
	- CourseHandler
	- EnrollmentHandler
	Handlers implements list, add, update and remove methods. Validates data with help of Validator/Utility.

Services (LearnTrackService)
	- StudentService
	- CourseService
	- EnrollmentService
	Services provide operation to retrieve objects from Components.
	Calls components for data update.

LearnTrackComponent (Singleton Class)
	- hold module data in a List. Totally 3 statis lists.
	- Key class to perform CRUD operation on data sets.

Custom Exception
	- CourseNotFoundException
  	- EnrollmentNotFoundException
  	- StudentNotFoundException


