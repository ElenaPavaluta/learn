package oc.p.chapters._10_.introducingTheInterfacesOfJdbc;

import utils.resources.db.Dbs;

import java.util.List;

class Intro {

    static void m() {
        String url = Dbs.ZOO.url();
        System.out.println(url);

        List <String> tables = Dbs.ZOO.tables();
        System.out.println(tables);
    }

    public static void main(String[] args) {
        m();
    }
}
