import java.util.ArrayList;

public class Student {
    private static final String HOUR_DIVIDER = "-";
    private static final String ROOM_DIVIDER = " / ";
    private static final String SPACE = " ";
    String name;
    String ID;
    ArrayList<Course> coursesTaken;
    ArrayList<Schedule> coursePlan;

    private ArrayList<String> Monday;
    private ArrayList<String> Tuesday;
    private ArrayList<String> Wednesday;
    private ArrayList<String> Thursday;
    private ArrayList<String> Friday;

    public Student(String name,String ID){
        this.name = name;
        this.ID = ID;
        this.coursesTaken = new ArrayList<>();
        this.coursePlan = new ArrayList<>();
    }

    private String printCourses(){
        String print ="";

        for(Course crs:coursesTaken) {
            print += crs.subjectName + SPACE + crs.courseNo + SPACE + crs.sectionNo + System.lineSeparator();
        }

        return print;
    }

    private String printWeeklySchedule(){
        setCoursePlan();

        String print =  "Monday : "    + Monday    + System.lineSeparator()
                +       "Tuesday : "   + Tuesday   + System.lineSeparator()
                +       "Wednesday : " + Wednesday + System.lineSeparator()
                +       "Thursday : "  + Thursday  + System.lineSeparator()
                +       "Friday : "    + Friday    + System.lineSeparator();

        return print;
    }

    private void setCoursePlan(){
        Monday = new ArrayList<>();
        Tuesday = new ArrayList<>();
        Wednesday = new ArrayList<>();
        Thursday = new ArrayList<>();
        Friday = new ArrayList<>();

        for(Course course : coursesTaken){
            arrangeAccordingToDays(course);
        }
    }

    private void arrangeAccordingToDays(Course course){
        if(course.schedule.startDate != null) {
            switch (course.schedule.meetingTime.day) {
                case ("Monday"):
                    Monday.add(dailyCourseInfo(course));
                    break;
                case ("Tuesday"):
                    Tuesday.add(dailyCourseInfo(course));
                    break;
                case ("Wednesday"):
                    Wednesday.add(dailyCourseInfo(course));
                    break;
                case ("Thursday"):
                    Thursday.add(dailyCourseInfo(course));
                    break;
                case ("Friday"):
                    Friday.add(dailyCourseInfo(course));
                    break;
            }
        }
    }

    private String dailyCourseInfo(Course course){
        return  course.subjectName + SPACE + course.courseNo + SPACE +course.sectionNo
                + SPACE + course.schedule.meetingTime.startHour + HOUR_DIVIDER
                + course.schedule.meetingTime.finishHour
                + ROOM_DIVIDER + course.schedule.meetingTime.room;
    }

    public String toString(){
        return  "Student ID : " + ID + " Name: " + name + System.lineSeparator()
                +"Courses : " + printCourses()
                +"WeeklySchedule : " + System.lineSeparator()
                + printWeeklySchedule();
    }

    public String getName(){
        return this.name;
    }

    public String getID(){
        return this.ID;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setID (String newID){
        this.ID = newID;
    }
}
