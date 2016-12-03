import java.util.ArrayList;

public class Course {
    String subjectName;
    String courseNo;
    String sectionNo;
    Schedule schedule;
    ArrayList<String> studentIDs;
    ArrayList<Instructor> courseInstructors;

    public Course (String subjectName, String courseNo, String sectionNo, ArrayList<Instructor> courseInstructors, Schedule schedule){
        this.subjectName = subjectName;
        this.courseNo = courseNo;
        this.sectionNo = sectionNo;
        this.courseInstructors = courseInstructors;
        this.schedule = schedule;
        this.studentIDs = new ArrayList<>();
    }

    public void enrollStudent(String ID){
        studentIDs.add(ID);
    }

    public String toString(){
        return "SubjectName: "+ subjectName + " CourseNo: " + courseNo + " SectionNo: " + sectionNo
                + System.lineSeparator() + "Instructors: "  + System.lineSeparator() + courseInstructors
                + System.lineSeparator() + "Schedule: "     + System.lineSeparator() + schedule
                + System.lineSeparator() + "Students: "     + System.lineSeparator() + studentIDs;
    }
}
