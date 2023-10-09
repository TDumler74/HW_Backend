package tdhellosql;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class MyDataSource {

    private static DataSource dataSource;

    public static DataSource getDataSource(){
        if (dataSource == null){
            //1. prepare connect to database
            PGSimpleDataSource pgDS = new PGSimpleDataSource();
            pgDS.setServerName("localhost");
            pgDS.setDatabaseName("cohort26");
            pgDS.setUser("postgres");
            pgDS.setPassword("root");
        }
        return dataSource;
    }
}

