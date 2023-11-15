package com.plrs.coursesinfo.cli;

import com.plrs.coursesinfo.cli.service.CourseRetrieverService;
import com.plrs.coursesinfo.cli.service.PluralsightCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String[] args) {
        LOG.info("Application is starting");
        if (args.length == 0) {
            LOG.warn("Please provide an author name as firs argument");
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

        CourseRetrieverService courseRetrieverService = new CourseRetrieverService();

        List<PluralsightCourse> coursesToStore = courseRetrieverService.getCoursesFor(authorId);
        LOG.info("Retrieve the following {} courses {}", coursesToStore.size(), coursesToStore);
    }

}
