package com.bmstechpro.courseinfo.repository;
/* course-info
 * @created 09/27/2022
 * @author Konstantin Staykov
 */

import com.bmstechpro.courseinfo.domain.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);

    List<Course> getAllCourses();

    void addNotes(String id, String notes);

    static CourseRepository openCourseRepository(String databaseFile){
        return new CourseJdbcRepository(databaseFile);
    }
}
