package com.bmstechpro.courseinfo.cli.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* course-info
 * @created 09/25/2022
 * @author Konstantin Staykov
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PluralsightCourse(String id, String title, String duration, String contentUrl, boolean isRetired) {
}
