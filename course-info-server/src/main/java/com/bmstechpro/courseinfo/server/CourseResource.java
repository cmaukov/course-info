package com.bmstechpro.courseinfo.server;

import com.bmstechpro.courseinfo.domain.Course;
import com.bmstechpro.courseinfo.repository.CourseRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/* course-info
 * @created 09/28/2022
 * @author Konstantin Staykov
 */
@Path("/courses")
public class CourseResource {
    private static final Logger LOG = LoggerFactory.getLogger(CourseResource.class);

    private final CourseRepository courseRepository;

    public CourseResource(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses() {
        return courseRepository.getAllCourses()
                .stream()
                .sorted(Comparator.comparing(Course::id))
                .toList();
    }
}
