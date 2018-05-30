package oc.a.chapters._1_building_blocks.pkg_declaration_and_imports.naming_conflicts;

import java.util.Date;

/*
 * Explicily importing a class dishName takes precedence over any wildcards present
 */
public class NamingConflicts {

	Date d = new Date();
}

class Conflicts{

	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(25);
}

class Conflicts2{
	Date d;
	java.sql.Date d2;
}

