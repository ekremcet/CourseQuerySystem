/*
 * This file was automatically generated by EvoSuite
 * Sat Dec 03 18:23:09 EET 2016
 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true) 
public class CourseAdder_ESTest extends CourseAdder_ESTest_scaffolding {

  @Test
  public void test0()  throws Throwable  {
      ArrayList<Course> arrayList0 = new ArrayList<Course>();
      CourseAdder courseAdder0 = new CourseAdder(arrayList0);
  }

  @Test
  public void test1()  throws Throwable  {
      ArrayList<Course> arrayList0 = new ArrayList<Course>();
      LinkedList<Course> linkedList0 = new LinkedList<Course>();
      arrayList0.addAll((Collection<? extends Course>) linkedList0);
      CourseAdder courseAdder0 = new CourseAdder(arrayList0);
      arrayList0.stream();
      courseAdder0.addNewCourse();
  }

  @Test
  public void test2()  throws Throwable  {
      ArrayList<Course> arrayList0 = null;
      CourseAdder courseAdder0 = new CourseAdder((ArrayList<Course>) null);
      CourseAdder courseAdder1 = new CourseAdder((ArrayList<Course>) null);
      CourseAdder courseAdder2 = new CourseAdder((ArrayList<Course>) null);
      CourseAdder courseAdder3 = new CourseAdder((ArrayList<Course>) null);
      ArrayList<Course> arrayList1 = new ArrayList<Course>();
      ArrayList<Instructor> arrayList2 = new ArrayList<Instructor>();
      Schedule schedule0 = new Schedule();
      Course course0 = new Course("1Q", "1Q", "dd-MM-yyyy HH:mm:ss", arrayList2, schedule0);
      arrayList2.clear();
      course0.courseNo = null;
      arrayList1.add(course0);
      CourseAdder courseAdder4 = new CourseAdder(arrayList1);
      CourseAdder courseAdder5 = new CourseAdder(arrayList1);
      courseAdder5.addNewCourse();
      courseAdder5.addNewCourse();
      courseAdder5.addNewCourse();
      CourseAdder courseAdder6 = new CourseAdder(arrayList0);
      courseAdder1.addNewCourse();
      courseAdder3.addNewCourse();
  }
}