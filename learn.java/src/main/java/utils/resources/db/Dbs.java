package utils.resources.db;

import utils.resources.db.instance.embedded.derby.ZooDb;
import utils.resources.db.instance.embedded.derby.coffee.CoffeeDb;

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
}