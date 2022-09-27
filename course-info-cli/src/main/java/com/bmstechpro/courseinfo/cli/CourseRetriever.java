package com.bmstechpro.courseinfo.cli;
/* course-info
 * @created 09/21/2022
 */

import com.bmstechpro.courseinfo.cli.service.CourseRetrievalService;
import com.bmstechpro.courseinfo.cli.service.PluralsightCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.function.Predicate.not;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String[] args) {
        LOG.info("CourseRetriever Starting");
        if (args.length == 0) {
            LOG.warn("Please provide course author name as first argument");
            return;
        }
        try {
            retrieveCourses(args[0]);

        } catch (Exception e) {
            LOG.error("Unexpected error", e);
        }

    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for author '{}'", authorId);
        CourseRetrievalService courseRetrievalService = new CourseRetrievalService();
        List<PluralsightCourse> coursesToStore = courseRetrievalService.getCoursesFor(authorId)
                .stream()
                .filter(not(PluralsightCourse::isRetired))
                .toList();
        LOG.info("Retrieved the following {} courses '{}'", coursesToStore.size(), coursesToStore);
    }
}
