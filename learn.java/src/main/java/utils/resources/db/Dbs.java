package utils.resources.db;

import utils.resources.db.instance.embedded.derby.ZooDb;
import utils.resources.db.instance.embedded.derby.coffee.CoffeeDb;
import java.util.List;

public enum Dbs {

    ZOO(ZooDb.dbInstance(DbDefinition.ZOO)),
    COFFEE(CoffeeDb.dbInstance(DbDefinition.COFFEE));

    private DbInstance dbInstance;

    Dbs(DbInstance dbInstance) {
        this.dbInstance = dbInstance;
    }

    public DbInstance getDbInstance() {
        return dbInstance;
    }

    public String url() {
        return dbInstance.getDbDefinition().url();
    }

    public String forName(){
        return dbInstance.getDbDefinition().forName();
    }

    public void rollback(){
        dbInstance.rollback();
    }


    public List<String> tables() {
        return dbInstance.tables();
    }
}