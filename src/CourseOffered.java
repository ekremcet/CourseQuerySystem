import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class CourseOffered {
    private static final String COURSE_DATA = "Course";
    private static final String SUBJECT_NAME_DATA = "SubjectName";
    private static final String COURSE_NO_DATA = "CourseNo";
    private static final String SECTION_NO_DATA = "SectionNo";
    private static final String INSTRUCTORS_DATA = "Instructors";
    private static final String SCHEDULE_DATA = "Schedule";
    private static final String INSTRUCTOR_NAME_DATA = "Name";
    private static final String INSTRUCTOR_SURNAME_DATA = "Surname";
    private static final String INSTRUCTOR_PRIMARY_DATA = "IsPrimary";
    private static final String START_DATE_DATA = "StartDate";
    private static final String FINISH_DATE_DATA = "FinishDate";
    private static final String MEETING_TIME_DATA = "MeetingTime";
    private static final String DAY_DATA = "Day";
    private static final String START_HOUR_DATA = "StartHour";
    private static final String FINISH_HOUR_DATA = "FinishHour";
    private static final String ROOM_DATA = "Room";
    private static final String ROOM_CODE_DATA = "RoomCode";
    private static final String DATA_PARSE_ERROR = "Data couldn't be parsed from URL";
    private static final String urlString = "http://ozusrl.github.io/cs222/data/CoursesOffered.json";

    private JSONArray jsonArray;
    protected ArrayList <Course> jsonData;

    public CourseOffered() throws Exception{
        parseDataArray();
        createCourseOfferedData();
    }

    private void parseDataArray () throws Exception{
        JSONParser parser = new JSONParser();
        try {
            URL url = new URL(urlString);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                jsonArray = (JSONArray) parser.parse(inputLine);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(DATA_PARSE_ERROR);
        }
    }

    private void createCourseOfferedData(){
        jsonData = new ArrayList<Course>();
        for(Object obj : jsonArray){
            JSONObject object = (JSONObject) obj;
            JSONObject courseObject = (JSONObject) object.get(COURSE_DATA);

            String subjectName = (String) courseObject.get(SUBJECT_NAME_DATA);
            String courseNo = (String) courseObject.get(COURSE_NO_DATA);
            String sectionNo = (String) courseObject.get(SECTION_NO_DATA);

            JSONArray instructorArray = (JSONArray) courseObject.get(INSTRUCTORS_DATA);
            ArrayList<Instructor> Instructors = takeInstructorData(instructorArray);

            JSONArray scheduleArray = (JSONArray) courseObject.get(SCHEDULE_DATA);
            Schedule schedule = takeScheduleData(scheduleArray);

            Course course = new Course(subjectName,courseNo,sectionNo,Instructors,schedule);
            jsonData.add(course);
        }
    }

    private ArrayList<Instructor> takeInstructorData(JSONArray instructorArray){
        ArrayList Instructors = new ArrayList<Instructor>();
        for(Object instructorObj : instructorArray) {
            JSONObject instructorObject = (JSONObject) instructorObj;
            String instructorName = (String) instructorObject.get(INSTRUCTOR_NAME_DATA);
            String instructorSurname = (String) instructorObject.get(INSTRUCTOR_SURNAME_DATA);
            boolean isPrimary = (boolean) instructorObject.get(INSTRUCTOR_PRIMARY_DATA);

            Instructor instructor = new Instructor(instructorName,instructorSurname,isPrimary);
            Instructors.add(instructor);
        }

        return Instructors;
    }

    private Schedule takeScheduleData(JSONArray scheduleArray){
        Schedule schedule = new Schedule();
        for(Object scheduleObj : scheduleArray) {
            JSONObject scheduleObject = (JSONObject) scheduleObj;
            String StartDate = (String) scheduleObject.get(START_DATE_DATA);
            String FinishDate = (String) scheduleObject.get(FINISH_DATE_DATA);

            JSONArray meetingArray = (JSONArray) scheduleObject.get(MEETING_TIME_DATA);
            MeetingTime meetingTime = takeMeetingTimeData(meetingArray);

            schedule = new Schedule (StartDate,FinishDate,meetingTime);
        }

        return schedule;
    }

    private MeetingTime takeMeetingTimeData(JSONArray meetingArray){
        MeetingTime meetingTime = new MeetingTime();
        for(Object meetingTimeObj : meetingArray) {
            JSONObject meetingObject = (JSONObject) meetingTimeObj;
            String Day = (String) meetingObject.get(DAY_DATA);
            String StartHour = (String) meetingObject.get(START_HOUR_DATA);
            String FinishHour = (String) meetingObject.get(FINISH_HOUR_DATA);

            JSONArray roomArray = (JSONArray) meetingObject.get(ROOM_DATA);
            Room room = takeRoomData(roomArray);

            meetingTime = new MeetingTime(Day,StartHour,FinishHour,room);
        }

        return meetingTime;
    }

    private Room takeRoomData(JSONArray roomArray){
        Room room;
        ArrayList roomCodes = new ArrayList<String>();
        for(Object roomObj : roomArray){
            JSONObject roomObject = (JSONObject) roomObj;
            String roomCode = (String) roomObject.get(ROOM_CODE_DATA);
            roomCodes.add(roomCode);
        }
        room = new Room(roomCodes);

        return room;
    }

    protected ArrayList getDataArray(){
        return this.jsonData;
    }
}

