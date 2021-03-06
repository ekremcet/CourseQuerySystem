/*
 * This file was automatically generated by EvoSuite
 * Sat Dec 03 18:30:02 EET 2016
 */


import static org.evosuite.runtime.EvoAssertions.assertThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true) 
public class Schedule_ESTest extends Schedule_ESTest_scaffolding {

  @Test
  public void test0()  throws Throwable  {
      Schedule schedule0 = new Schedule();
      schedule0.startDate = "ZRin7f>22)Zo/nm=t";
      // Undeclared exception!
      try { 
        schedule0.toString();
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
         //
         // String index out of range: 19
         //
         assertThrownBy("java.lang.String", e);
      }
  }

  @Test
  public void test1()  throws Throwable  {
      Room room0 = new Room();
      MeetingTime meetingTime0 = new MeetingTime("oiRS+Y39)Yb5vuRvTz", (String) null, "oiRS+Y39)Yb5vuRvTz", room0);
      Schedule schedule0 = new Schedule((String) null, "oiRS+Y39)Yb5vuRvTz", meetingTime0);
      // Undeclared exception!
      try { 
        schedule0.toString();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("Room", e);
      }
  }

  @Test
  public void test2()  throws Throwable  {
      Schedule schedule0 = new Schedule();
      schedule0.startDate = "StartDate: null FinishDate: null null";
      String string0 = schedule0.toString();
      assertEquals("StartDate: StartDate: null FinishDate: null null FinishDate: null null", string0);
  }

  @Test
  public void test3()  throws Throwable  {
      Room room0 = new Room();
      MeetingTime meetingTime0 = new MeetingTime("9`Dj[u&M<e^{fY^P-{", "9`Dj[u&M<e^{fY^P-{", (String) null, room0);
      Schedule schedule0 = new Schedule("9`Dj[u&M<e^{fY^P-{", "9`Dj[u&M<e^{fY^P-{", meetingTime0);
      // Undeclared exception!
      try { 
        schedule0.toString();
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
         //
         // For input string: \"u&M<e^{fY^P-{\"
         //
         assertThrownBy("java.lang.NumberFormatException", e);
      }
  }
}
