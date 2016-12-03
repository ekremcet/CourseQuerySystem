
import java.util.*;


public class CourseQueryController {
    private static final String EMPTY_COMMAND = "";
    private static final String COMMAND_EXIT = "0";
    private static final String COMMAND_LIST_ALL_DATA = "1";
    private static final String COMMAND_LIST_ALL_INSTRUCTORS = "2";
    private static final String COMMAND_LIST_ALL_ROOMS = "3";
    private static final String COMMAND_LIST_ALL_COURSE_NAMES = "4";
    private static final String COMMAND_LIST_ALL_COURSE_NUMBERS = "5";
    private static final String COMMAND_LIST_SPECIFIC_INFO = "6";
    private static final String COMMAND_LIST_MORNING_COURSES = "7";
    private static final String COMMAND_ADD_NEW_COURSE  = "8";
    private static final String COMMAND_ADD_NEW_STUDENT = "9";

    private static final String SPECIFIC_ROOM = "1";
    private static final String SPECIFIC_DAY = "2";
    private static final String SPECIFIC_INSTRUCTOR = "3";
    private static final String SPECIFIC_COURSE_NO = "4";
    private static final String SPECIFIC_SUBJECT_NAME = "5";
    private static final String LIST_STUDENT_INFO = "6";

    private static final String MORNING_COURSE_STARTING_HOUR_1 = "8:40";
    private static final String MORNING_COURSE_STARTING_HOUR_2 = "9:40";
    private static final String MORNING_COURSE_STARTING_HOUR_3 = "10:40";
    private static final String MORNING_COURSE_STARTING_HOUR_4 = "11:40";

    private static final String INVALID_COMMAND_ERROR = "Invalid Command Number, Please try carefully";
    private static final String INVALID_SPECIFIC_TYPE_ERROR = "Invalid type, please try carefully";
    private static final String DATA_NOT_FOUND = "Data you're looking for is not found, please check the key";
    
    private static final String REQUEST_KEY = "Enter the key: ";
    private static final String STUDENT_NOT_FOUND = "Student not found";

    private CourseOffered offeredCourses;
    private String command;
    private ArrayList<Course> courseDataList;
    private ArrayList<Student> students;
    private Set<String> requestedData;
    private Scanner scanner = new Scanner(System.in);

    public CourseQueryController() throws Exception {
        offeredCourses = new CourseOffered();
        courseDataList = offeredCourses.getDataArray();
        students = new ArrayList<>();
        requestedData = new HashSet<>();
    }

    public void execute(){
        command = EMPTY_COMMAND;
        while(!COMMAND_EXIT.matches(command)){
            printCommandMenu();
            command = scanner.nextLine();
            switch(command){
                case COMMAND_EXIT :
                    System.exit(0);
                    break;
                case COMMAND_LIST_ALL_DATA:
                    listAllData();
                    break;
                case COMMAND_LIST_ALL_INSTRUCTORS:
                    listAllInstructors();
                    break;
                case COMMAND_LIST_ALL_ROOMS:
                    listAllRooms();
                    break;
                case COMMAND_LIST_ALL_COURSE_NAMES:
                    listAllCourseNames();
                    break;
                case COMMAND_LIST_ALL_COURSE_NUMBERS:
                    listAllCourseNumbers();
                    break;
                case COMMAND_LIST_SPECIFIC_INFO:
                    listSpecificData();
                    break;
                case COMMAND_LIST_MORNING_COURSES:
                    listCoursesStartInTheMorning();
                    break;
                case COMMAND_ADD_NEW_COURSE:
                    addNewCourse();
                    break;
                case COMMAND_ADD_NEW_STUDENT:
                    addNewStudent();
                    break;
                default:
                    System.out.println(INVALID_COMMAND_ERROR);
                    execute();
            }
        }
    }

    private void addNewStudent() {
        StudentAdder studentAdder = new StudentAdder(courseDataList,students);
        studentAdder.addNewStudent();
    }

    private void addNewCourse() {
        CourseAdder courseAdder = new CourseAdder(courseDataList);
        courseAdder.addNewCourse();
    }

    private void listAllCourseNumbers() {
        for(Course crs : courseDataList){
            requestedData.add(crs.courseNo);
        }
        printRequestedData();
    }

    private void listAllCourseNames() {
        for(Course crs : courseDataList){
            requestedData.add(crs.subjectName);
        }
        printRequestedData();
    }

    private void listAllRooms() {
        for(Course crs : courseDataList){
            if(crs.schedule.startDate == null){}
            else
                requestedData.add(crs.schedule.meetingTime.room.toString());
        }
        printRequestedData();
    }

    private void listAllInstructors() {
        for(Course crs : courseDataList){
            for(Instructor ints : crs.courseInstructors){
                requestedData.add(ints.instructorName());
            }
        }
        printRequestedData();
    }

    private void listAllData() {
        for(Course crs : courseDataList){
            requestedData.add(crs.toString());
        }
        printRequestedData();
    }

    private void listSpecificData() {
        printSpecificInfoMenu();
        String type = scanner.nextLine();
        System.out.println(REQUEST_KEY);
        String key = scanner.nextLine();

        switch(type){
            case SPECIFIC_ROOM:
                queryByRoomCode(key);
                break;
            case SPECIFIC_DAY:
                queryByDay(key);
                break;
            case SPECIFIC_INSTRUCTOR:
                queryByInstructor(key);
                break;
            case SPECIFIC_COURSE_NO:
                queryByCourseNo(key);
                break;
            case SPECIFIC_SUBJECT_NAME:
                queryBySubjectName(key);
                break;
            case LIST_STUDENT_INFO:
                listStudentInfo(key);
                break;
            default:
                System.out.println(INVALID_SPECIFIC_TYPE_ERROR);
                listSpecificData();
        }
    }

    private void listStudentInfo(String key){
        for(Student std : students){
            if(std.ID.equals(key)){
                System.out.println(std);
            }
        }
    }

    private void queryByRoomCode(String key) {
        for(Course crs : courseDataList){
            if(crs.schedule.startDate == null){}
            else
                searchRequestedRooms(crs,key);
            }
        printRequestedData();
    }

    private void searchRequestedRooms(Course crs, String key) {
        ArrayList<String> roomCodes = crs.schedule.meetingTime.room.roomCodes;
        for (String str : roomCodes) {
            if (str.toLowerCase().contains(key.toLowerCase()))
                requestedData.add(crs.toString());
        }
    }

    private void queryByDay(String key) {
        for (Course crs : courseDataList) {
            if (crs.schedule.startDate == null) {}
            else if (crs.schedule.meetingTime.day.toLowerCase().contains(key.toLowerCase()))
                requestedData.add(crs.toString());
        }
        printRequestedData();
    }

    private void queryByInstructor(String key) {
        for(Course crs : courseDataList){
            searchRequestedInstructors(crs,key);
        }
        printRequestedData();
    }

    private void searchRequestedInstructors(Course crs, String key){
        ArrayList<Instructor> courseInstructors = crs.courseInstructors;;
        for(Instructor inst : courseInstructors){
            if(inst.toString().toLowerCase().contains(key.toLowerCase()))
                requestedData.add(crs.toString());
        }
    }

    private void queryByCourseNo(String key) {
        for(Course crs : courseDataList){
            if(crs.courseNo.contains(key))
                requestedData.add(crs.toString());
        }
        printRequestedData();
    }

    private void queryBySubjectName(String key) {
        for(Course crs : courseDataList){
            if(crs.subjectName.toLowerCase().contains(key.toLowerCase()))
                requestedData.add(crs.toString());
        }
        printRequestedData();
    }

    private void listCoursesStartInTheMorning() {
        for(Course crs : courseDataList){
            if(crs.schedule.startDate == null){}
            else
                checkCourseStartingHour(crs);
        }
        printRequestedData();
    }

    private void checkCourseStartingHour(Course crs){
        ArrayList<String> morningHours = new ArrayList<String>();
        morningHours.add(MORNING_COURSE_STARTING_HOUR_1);
        morningHours.add(MORNING_COURSE_STARTING_HOUR_2);
        morningHours.add(MORNING_COURSE_STARTING_HOUR_3);
        morningHours.add(MORNING_COURSE_STARTING_HOUR_4);

        for(String str : morningHours){
            if(str.matches(crs.schedule.meetingTime.startHour))
                requestedData.add(crs.toString());
        }
    }

    private void printRequestedData(){
        TreeSet dataToPrint = new TreeSet();
        dataToPrint.addAll(requestedData);
        Iterator iterator = dataToPrint.iterator();

        if(!iterator.hasNext())
            System.out.println(DATA_NOT_FOUND);

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        requestedData.clear();
    }

    private void printCommandMenu(){
        System.out.println(
                "         Course Query System                 " + System.lineSeparator()
                + "   Enter the number of command to continue   " + System.lineSeparator()
                + "---------------------------------------------" + System.lineSeparator()
                + "1 -> List All Data                           " + System.lineSeparator()
                + "2 -> List All Instructors                    " + System.lineSeparator()
                + "3 -> List All Rooms                          " + System.lineSeparator()
                + "4 -> List All Course Names                   " + System.lineSeparator()
                + "5 -> List All Course Numbers                 " + System.lineSeparator()
                + "6 -> Query Courses with Specific Info        " + System.lineSeparator()
                + "7 -> List Courses that start in the morning  " + System.lineSeparator()
                + "8 -> Add New Course                          " + System.lineSeparator()
                + "9 -> Add New Student                         " + System.lineSeparator()
                + "0 -> Exit                                    " + System.lineSeparator());
    }

    private void printSpecificInfoMenu(){
        System.out.println(
                "            Course Query System               " + System.lineSeparator()
                + "----------------------------------------------" + System.lineSeparator()
                + "1 -> List By Specific Room                       " + System.lineSeparator()
                + "2 -> List By Specific Day                        " + System.lineSeparator()
                + "3 -> List By Specific Instructor                 " + System.lineSeparator()
                + "4 -> List By Specific Course no                  " + System.lineSeparator()
                + "5 -> List By Specific Subject Name               " + System.lineSeparator()
                + "6 -> List By Specific Student Info by ID         " + System.lineSeparator());
    }
}