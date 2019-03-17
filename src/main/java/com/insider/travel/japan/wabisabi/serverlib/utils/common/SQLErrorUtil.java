package com.insider.travel.japan.wabisabi.serverlib.utils.common;

import java.sql.SQLException;

/**
 *
 * 
 */
public class SQLErrorUtil {

    // [PostgreSQL error code](https://www.postgresql.jp/document/9.3/html/errcodes-appendix.html)
    private static final String UNIQUE_VIOLATION = "23505";

    public static boolean isUniqueConstraintViolation(Exception e) {
        Throwable t;
        for (t = e.getCause(); t != null; t = t.getCause()) {
            if (t instanceof SQLException) {
                SQLException sqlException = (SQLException) t;
                if (sqlException.getSQLState().equals(UNIQUE_VIOLATION)) {
                    return true;
                }
            }
        }
        return false;
    }

}
