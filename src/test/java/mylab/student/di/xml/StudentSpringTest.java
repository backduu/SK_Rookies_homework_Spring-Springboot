package mylab.student.di.xml;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-student-di.xml")
public class StudentSpringTest {
	@BeforeEach
	public void checkInjection() {
	    System.out.println("✅ Course: " + course);
	    System.out.println("✅ GradeService: " + service);
	}

	
    // @Autowired + @Qualifier 사용
    @Autowired
    @Qualifier("course")
    private Course course;

    // @Resource 사용
    @Resource(name = "gradeService")
    private GradeService service;

    @Test
    public void testCourse() {
        //assertNotNull(course);
        System.out.println("Course Info:");
        System.out.println("Course ID: " + course.getCourseId());
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Average Score: " + course.getAverageScore());
        System.out.println("Students:");
        for (Student s : course.getStudents()) {
            System.out.println(" - " + s);
        }
        double expectedTotal = (98 + 55 + 85) / 3.0;
    }

    @Test
    public void testGradeService() {
        //assertNotNull(service);
        System.out.println("GradeService Test:");

        String studentId = "2026030102";
        String grade = service.calculateGrade(studentId);
        System.out.println("Student ID: " + studentId + " → Grade: " + grade);

        int threshold = 80;
        List<Student> highScorers = service.getHighScoreStudents(threshold);
        System.out.println("Students with score ≥ " + threshold + ":");
        for (Student s : highScorers) {
            System.out.println(" - " + s);
        }
    }

}
