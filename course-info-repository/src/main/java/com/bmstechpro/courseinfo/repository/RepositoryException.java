package com.bmstechpro.courseinfo.repository;
/* course-info
 * @created 09/27/2022
 * @author Konstantin Staykov
 */

import java.sql.SQLException;

public class RepositoryException extends RuntimeException {
    public RepositoryException(String message, SQLException e) {
        super(message, e);
    }
}
