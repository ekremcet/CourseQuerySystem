# CourseQuerySystem
Course Query System parses course data as a JSON format and then creates Java Objects and store
the data in the objects to help users browse and query data. Course Query System allows user to list
the data as a whole or partially and query courses by specific information. It is also possible to add
new student and course data to the system. Course Query System uses Console-based Interaction
approach for UI.
Course Query System supports JSON data format.
Course Query System contains following classes:
Course
CourseAdder
CourseOffered
Used for storing the course data as course objects.
CourseAdder is used while adding a new course to the system.
CourseOffered class parses the JSON data , and stores the data in an
ArrayList < Course > format
CourseQueryController CourseQueryController is used for listing and querying the data and
displaying available commands to user.
CourseQuerySystem
This class is used for starting the system.
Instructor
Used for storing the Instructor data as Instructor objects, those objects
are used while creating the Course data.
MeetingTime
Used for storing the MeetingTime data as MeetingTime object to be
used in Schedule object.
Room
Used for storing the Room data as Room object to be used in
MeetingTime object.
Schedule
Used for storing the Schedule data as Schedule object to be used in
Course object.
Student
Used for storing the Student data as Student object, those objects are
used while creating the Course data. Also student class creates the
Student’s weekly schedule.
StudentAdder
StudentAdder is used while adding a new student to the system.
