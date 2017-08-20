package chapters.c1_building_blocks.pkg_declaration_and_imports.naming_conflicts;

import java.util.*;
import java.util.Date;
import java.sql.*;

/*
 * Explicily importing a class name takes precedence over any wildcards present
 */
public class NamingConflicts {

	Date d = new Date();
}

class Conflicts{

	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(25);
}

class Conflicts2{
	java.util.Date d;
	java.sql.Date d2;
}

