import java.util.ArrayList;
import java.util.Scanner;

public class StudentAdder {
    private static final String FALSE_NAME_FORMAT = ".*\\d.*";
    private static final String ID_FORMAT = "[0-9]{4}";
    private static final String SPLITTER = " ";
    private static final String END_ADDING = "2";
    private static final String DEFAULT_DECISION = "";

    private static final int COURSE_INFO_LENGTH = 3;
    private static final int FIRST_INFO = 0;
    private static final int SECOND_INFO = 1;
    private static final int THIRD_INFO = 2;

    ArrayList<Course> courseDataList;
    ArrayList<Student> students;
    Scanner scanner = new Scanner(System.in);

    public StudentAdder(ArrayList<Course> courseDataList, ArrayList<Student> students){
        this.courseDataList = courseDataList;
        this.students = students;
    }

    public void addNewStudent() {
        Student student = createNewStudent();
        ArrayList<String> courses = new ArrayList<>();
        enrollCourses(courses);
        students.add(student);
        addStudentToCourse(courses,student);
    }

    private Student createNewStudent() {
        System.out.println("Enter the student's full name : ");
        String name = scanner.nextLine();
        name = confirmName(name);

        System.out.println("Enter the ID of student in 4 digit format -> (1111) : ");
        String ID = scanner.nextLine();
        ID = confirmID(ID);

        Student student = new Student(name,ID);

        return student;
    }

    private String confirmName(String name) {
        if(name.matches(FALSE_NAME_FORMAT)){
            System.out.println("Please enter name in correct way -> (Bill Gates)");
            name = scanner.nextLine();
            name = confirmName(name);
        }

        return name;
    }

    private String confirmID(String id) {
        boolean idIsCorrect = true;
        if(!id.matches(ID_FORMAT))
            idIsCorrect = false;

        for(Student student : students){
            if(student.ID.matches(id))
                idIsCorrect = false;
        }

        if(!idIsCorrect) {
            System.out.println("Please enter the ID in correct format (4 numbers) and make sure that ID is unique : ");
            id = scanner.nextLine();
            id = confirmID(id);
        }

        return id;
    }

    private void enrollCourses(ArrayList<String> courses){
        String userDecision = DEFAULT_DECISION;

        while(!userDecision.equals(END_ADDING)){
            System.out.println("Enter the course in format, all capital letters (SubjectName CourseNo Section) -> (CS 201 A) : ");
            String course = scanner.nextLine();
            course = confirmCourseInfo(course);
            courses.add(course);

            System.out.println("Enter '1' to continue adding courses, Enter '2' to end :");
            userDecision = scanner.nextLine();
        }
    }

    private String confirmCourseInfo(String course) {
        boolean courseIsAvailable = false;
        String [] courseExtractor = course.split(SPLITTER);

        if(courseExtractor.length == COURSE_INFO_LENGTH) {
            String subjectName = courseExtractor[FIRST_INFO];
            String courseNo = courseExtractor[SECOND_INFO];
            String sectionNo = courseExtractor[THIRD_INFO];

            for (Course crs : courseDataList) {
                if (crs.subjectName.equals(subjectName)
                        && crs.courseNo.equals(courseNo)
                        && crs.sectionNo.equals(sectionNo))
                    courseIsAvailable = true;
            }
        }

        if(!courseIsAvailable){
            System.out.println("Please enter the course carefully -> (CS 201 A) :");
            course = scanner.nextLine();
            course = confirmCourseInfo(course);
        }

        return course;
    }

    private void addStudentToCourse(ArrayList<String> courses, Student student) {
        for(String courseString : courses){
            String [] courseExtractor = courseString.split(SPLITTER);
            String subjectName = courseExtractor[FIRST_INFO];
            String courseNo = courseExtractor[SECOND_INFO];
            String sectionNo = courseExtractor[THIRD_INFO];

            for(Course course : courseDataList){
                if(course.subjectName.equals(subjectName)
                        && course.courseNo.equals(courseNo)
                        && course.sectionNo.equals(sectionNo)){
                    student.coursesTaken.add(course);
                    course.studentIDs.add(student.ID);
                }
            }
        }
    }
}
