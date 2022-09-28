package com.bmstechpro.courseinfo.cli.service;

import com.bmstechpro.courseinfo.domain.Course;
import com.bmstechpro.courseinfo.repository.CourseRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* course-info
 * @created 09/27/2022
 * @author Konstantin Staykov
 */

class CourseStorageServiceTest {

    @Test
    void storePluralsightCourses() {
        CourseRepository repository = new InMemoryCourseRepository();
        CourseStorageService courseStorageService = new CourseStorageService(repository);

        PluralsightCourse ps1 = new PluralsightCourse("1", "Title 1",
                "01:40:00.123", "/url-1", false);
        courseStorageService.storePluralsightCourses(List.of(ps1));

        Course expected = new Course("1", "Title 1", 100, "https://app.pluralsight.com/url-1");
        assertEquals(List.of(expected), repository.getAllCourses());
    }

    static class InMemoryCourseRepository implements CourseRepository {

        private List<Course> courses = new ArrayList<>();

        @Override
        public void saveCourse(Course course) {
            courses.add(course);
        }

        @Override
        public List<Course> getAllCourses() {
            return courses;
        }
    }
}