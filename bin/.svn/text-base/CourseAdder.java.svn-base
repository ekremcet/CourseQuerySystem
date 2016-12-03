import java.util.ArrayList;
import java.util.Scanner;

public class CourseAdder {
    private static final String DEFAULT_COURSE_STARTING_HOUR = " 00:00:00";
    private static final String ADD_MORE_INFO = "1";
    private static final String END_ADDING_INFO = "2";
    private static final String PRIMARY_INSTRUCTOR = "Y";
    private static final String DEFAULT_DECISION = "";

    private static final String NAME_PATTERN = "[a-zA-Z]+";
    private static final String PRIMARY_SITUATION_PATTERN = "[YN]{1}";
    private static final String HOUR_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
    private static final String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
    private static final String COURSE_NAME_PATTERN = "[A-Z]{2,4}";
    private static final String COURSE_NO_PATTERN = "[0-9]{3}";
    private static final String SECTION_NO_PATTERN = "[A-Z]{1}";
    private static final String ROOM_CODE_PATTERN = "[A-Z]{2,4}:[A-Z0-9]{2,3}";

    private static final String[] weekDays = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Course> courseDataList;

    public CourseAdder(ArrayList<Course> courseDataList){
        this.courseDataList = courseDataList;
    }

    public void addNewCourse() {
        System.out.println("Enter the Subject Name :");
        String subjectName = scanner.nextLine();
        subjectName = confirmSubjectName(subjectName);

        System.out.println("Enter the Course No: ");
        String courseNo = scanner.nextLine();
        courseNo = confirmCourseNo(courseNo);

        System.out.println("Enter the section:");
        String sectionNo = scanner.nextLine();
        sectionNo = confirmSectionNo(sectionNo);

        ArrayList<Instructor> instructors = new ArrayList<>();
        Schedule schedule = new Schedule();

        System.out.println("Enter '1' to add instructor and schedule info, Enter '2' to finish adding course : ");
        String check = scanner.nextLine();

        if (check.equals(ADD_MORE_INFO)) {
            instructors = addInstructor();
            schedule = addSchedule();
        }
        Course crs = new Course(subjectName, courseNo, sectionNo, instructors, schedule);
        courseDataList.add(crs);
    }

    private String confirmSubjectName(String subjectName) {
        if(!subjectName.matches(COURSE_NAME_PATTERN)){
            System.out.println("Please enter the course name in correct format -> (CS,BUS,ECON) :");
            subjectName = scanner.nextLine();
            subjectName = confirmSubjectName(subjectName);
        }

        return subjectName;
    }

    private String confirmCourseNo(String courseNo) {
        if(!courseNo.matches(COURSE_NO_PATTERN)){
            System.out.println("Please enter the course no in correct format -> (101) : ");
            courseNo = scanner.nextLine();
            courseNo = confirmCourseNo(courseNo);
        }

        return courseNo;
    }

    private String confirmSectionNo(String sectionNo) {
        if(!sectionNo.matches(SECTION_NO_PATTERN)){
            System.out.println("Please enter the section in correct format -> (A,B) : ");
            sectionNo = scanner.nextLine();
            sectionNo = confirmSectionNo(sectionNo);
        }

        return sectionNo;
    }

    private ArrayList<Instructor> addInstructor() {
        ArrayList<Instructor> instructors = new ArrayList<>();
        String userDecision = DEFAULT_DECISION;

        while (!userDecision.equals(END_ADDING_INFO)) {
            System.out.println("Enter Instructor name: ");
            String instructorName = scanner.nextLine();
            instructorName = confirmName(instructorName);

            System.out.println("Enter Instructor surname: ");
            String instructorSurname = scanner.nextLine();
            instructorSurname = confirmName(instructorSurname);

            System.out.println("Type 'Y' if the instructor is primary, otherwise press Enter :");
            String primaryApproval = scanner.nextLine();
            primaryApproval = confirmPrimarySituation(primaryApproval);
            boolean isPrimary = false;
            if (primaryApproval.equals(PRIMARY_INSTRUCTOR))
                isPrimary = true;

            Instructor instructor = new Instructor(instructorName, instructorSurname, isPrimary);
            instructors.add(instructor);
            System.out.println("Enter '1' to add more instructors, enter '2' to end adding instructors :");

            userDecision = scanner.nextLine();
        }

        return instructors;
    }

    private String confirmName(String name) {
        if(!name.matches(NAME_PATTERN)){
            System.out.println("Please enter the name or surname in correct format : (Bill,Gates) :");
            name = scanner.nextLine();
            name = confirmName(name);
        }

        return name;
    }

    private String confirmPrimarySituation(String primaryApproval) {
        if(!primaryApproval.matches(PRIMARY_SITUATION_PATTERN)){
            System.out.println("Please enter Y if primary, N if not :");
            primaryApproval = scanner.nextLine();
            confirmPrimarySituation(primaryApproval);
        }

        return primaryApproval;
    }

    private Schedule addSchedule() {
        System.out.println("Enter the starting date of offeredCourses in ( Day/Month/Year ) format :");
        String startingDate = scanner.nextLine();
        startingDate = confirmDate(startingDate);
        startingDate += DEFAULT_COURSE_STARTING_HOUR;

        System.out.println("Enter the finishing date of offeredCourses in ( Day-Month-Year ) format: ");
        String finishDate = scanner.nextLine();
        finishDate = confirmDate(finishDate);
        finishDate += DEFAULT_COURSE_STARTING_HOUR;

        Room room = takeRoomInfo();
        MeetingTime meetingTime = takeMeetingTimeInfo(room);
        Schedule schedule = new Schedule(startingDate, finishDate, meetingTime);

        return schedule;
    }

    private String confirmDate(String date) {
        if (!date.matches(DATE_PATTERN)) {
            System.out.println("Please enter date format correctly -> (30/07/2016) ");
            date = scanner.nextLine();
            date = confirmDate(date);
        }

        return date;
    }

    private MeetingTime takeMeetingTimeInfo(Room room){
        System.out.println("Enter the meeting day of offeredCourses : ");
        String meetingDay = scanner.nextLine();
        meetingDay = confirmMeetingDay(meetingDay);

        System.out.println("Enter the starting hour of lesson: ");
        String startHour = scanner.nextLine();
        startHour = confirmHour(startHour);

        System.out.println("Enter the ending hour of lesson: ");
        String endHour = scanner.nextLine();
        endHour = confirmHour(endHour);

        MeetingTime meetingTime = new MeetingTime(meetingDay, startHour, endHour, room);
        return meetingTime;
    }

    private String confirmMeetingDay(String meetingDay) {
        for(String day : weekDays){
            if(meetingDay.matches(day))
                return meetingDay;
        }

        System.out.println("Please enter a valid day and use a capital for first letter -> (Friday) :");
        meetingDay = scanner.nextLine();
        meetingDay = confirmMeetingDay(meetingDay);

        return meetingDay;
    }

    private String confirmHour(String hour){
        if (!hour.matches(HOUR_PATTERN)) {
            System.out.println("Please enter hour in correct format -> (10:00) ");
            hour = scanner.nextLine();
            hour = confirmHour(hour);
        }

        return hour;
    }

    private Room takeRoomInfo(){
        System.out.println("Enter the room code of offeredCourses :");
        ArrayList<String> rooms = new ArrayList<>();

        String userDecision = DEFAULT_DECISION;
        while (!userDecision.equals(END_ADDING_INFO)) {
            String roomCode = scanner.nextLine();
            roomCode = confirmRoomCode(roomCode);
            rooms.add(roomCode);
            System.out.println("Enter the room code of course ,type '2' if rooms are over :");
            userDecision = scanner.nextLine();
        }

        Room room = new Room(rooms);
        return room;
    }

    private String confirmRoomCode(String roomCode) {
        if(!roomCode.matches(ROOM_CODE_PATTERN)){
            System.out.println("Please enter the room name in correct format -> (FEAS:G32, EF:243) :");
            roomCode = scanner.nextLine();
            roomCode = confirmRoomCode(roomCode);
        }

        return roomCode;
    }
}