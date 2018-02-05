package oc.p.chapters.c_6_ExceptionsAndAssertions.reviewingExceptions;

import java.sql.SQLException;

class ThrowVsThrows {

    String getDataFromDb() throws SQLException{
        throw new UnsupportedOperationException();
    }

    void caller(){
        try {
            getDataFromDb();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    void caller2() throws SQLException{
        getDataFromDb();
    }
}
