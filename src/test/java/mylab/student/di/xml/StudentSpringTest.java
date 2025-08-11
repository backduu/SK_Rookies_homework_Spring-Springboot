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
        assertNotNull(course);
        
        double expected = 79.33333333333333;
        assertEquals(expected, course.getAverageScore());
    }

    @Test
    public void testGradeService() {
        assertNotNull(service);
        
        String expected = "F";
        assertEquals(expected, service.calculateGrade("2026030102"));
    }

}
