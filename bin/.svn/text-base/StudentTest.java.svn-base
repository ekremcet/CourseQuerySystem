import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {
    ArrayList<Course> coursesTaken;
    MeetingTime meetingTimeTest;
    Schedule scheduleTest;
    Room roomTest;
    Instructor instructorTest;
    ArrayList<Instructor> instructorsTest;
    Course courseTest;

    public StudentTest(){
        roomTest = new Room();
        meetingTimeTest = new MeetingTime("Wednesday","10.00","10.30",roomTest);
        scheduleTest = new Schedule("10.10.2016","10.11.2016",meetingTimeTest);
        instructorTest = new Instructor("Inst","Test",true);
        instructorsTest = new ArrayList<>();
        instructorsTest .add(instructorTest);
        courseTest = new Course("CS","202","A",instructorsTest,scheduleTest);
        coursesTaken.add(courseTest);
    }
    @Test
    public void setRoomTest() {
        assertEquals(null,roomTest);
    }
    @Test
    public void setMeetingTimeTest() {
        assertEquals("Wednesday",meetingTimeTest.day);
        assertEquals("10.00",meetingTimeTest.startHour);
        assertEquals("10.30",meetingTimeTest.finishHour);
    }
    @Test
    public void setScheduleTest() {
        assertEquals("10.10.2016",scheduleTest.startDate);
        assertEquals("10.11.2016",scheduleTest.finishDate);
    }
    @Test
    public void setInstructorTest(){
        assertEquals("Inst",instructorTest.name);
        assertEquals("Test",instructorTest.surname);
        assertEquals(true,instructorTest.isPrimary);
    }
    @Test
    public void setInstructorsTest()
    {
        assertEquals(instructorTest,instructorsTest.get(0));
    }
    @Test
    public void getNameTest(){
        Student student = new Student("Test","1234");
        assertEquals(student.getName(),"Test");
    }
    @Test
    public void getIDTest(){
        Student student = new Student("Test","1234");
        assertEquals(student.getID(),"1234");
    }
    @Test
    public void setNameTest(){
        Student student = new Student("Test","1234");
        student.setName("test2");
        assertEquals(student.getName(),"test2");
    }
    @Test
    public void setIDest(){
        Student student = new Student("Test","1234");
        student.setID("1235");
        assertEquals(student.getID(),"1235");
    }
    @Test
    public void studentConstructorTest(){
        Student student = new Student("Test","1234");
        assertEquals("Test",student.name);
        assertEquals("1234",student.ID);
    }
    @Test
    public void toStringTest(){
        Student student = new Student("Test","1234");
        assertEquals("Test 1234",student.toString());
    }
}