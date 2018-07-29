package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._1;

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
