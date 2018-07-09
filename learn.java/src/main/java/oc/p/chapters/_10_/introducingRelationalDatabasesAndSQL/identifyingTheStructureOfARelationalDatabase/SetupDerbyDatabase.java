package oc.p.chapters._10_.introducingRelationalDatabasesAndSQL.identifyingTheStructureOfARelationalDatabase;

import utils.resources.db.Dbs;

class SetupDerbyDatabase {

    static void m() {
        System.out.println(Dbs.ZOO.getDbInstance().getDbDefinition().url());
        System.out.println(Dbs.ZOO.getDbInstance().getDbDefinition().getName());
    }

    public static void main(String[] args) {
        m();
    }
}
