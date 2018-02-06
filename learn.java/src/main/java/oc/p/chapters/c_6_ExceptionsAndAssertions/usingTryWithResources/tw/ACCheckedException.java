package oc.p.chapters.c_6_ExceptionsAndAssertions.usingTryWithResources.tw;

import java.sql.SQLException;

class ACCheckedException implements AutoCloseable{

    ACCheckedException(){
        System.out.println("ACCheckedException created");
    }

    @Override
    public void close() throws SQLException{
       throw new SQLException("SQL E");
    }
}
