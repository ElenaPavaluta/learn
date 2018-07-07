package utils.resources.db.test;

import utils.resources.db.Dbs;

class A {

    public static void main(String[] args) {
        System.out.println(Dbs.ZOO.getDbInstance().getDbDefinition().url());
        System.out.println(Dbs.COFFEE.getDbInstance().getDbDefinition().url());
    }
}
