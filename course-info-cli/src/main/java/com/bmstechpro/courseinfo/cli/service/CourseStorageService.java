package com.bmstechpro.courseinfo.cli.service;
/* course-info
 * @created 09/27/2022
 * @author Konstantin Staykov
 */

import com.bmstechpro.courseinfo.domain.Course;
import com.bmstechpro.courseinfo.repository.CourseRepository;

import java.util.List;

public class CourseStorageService {
    private static final String PS_BASE_URL = "https://app.pluralsight.com";
    private final CourseRepository courseRepository;

    public CourseStorageService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void storePluralsightCourses(List<PluralsightCourse> psCourses) {

        for (PluralsightCourse psCourse : psCourses) {
            Course course = new Course(psCourse.id(), psCourse.title(), psCourse.durationInMinutes(), PS_BASE_URL+ psCourse.contentUrl());
            courseRepository.saveCourse(course);
        }
    }
}
