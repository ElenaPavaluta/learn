package books.thinkigInJava4ThEdition.chapters.annotations.implementingTheProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import books.thinkigInJava4ThEdition.chapters.annotations.generatingExternalFiles.Constraints;
import books.thinkigInJava4ThEdition.chapters.annotations.generatingExternalFiles.DBTable;
import books.thinkigInJava4ThEdition.chapters.annotations.generatingExternalFiles.SqlInteger;
import books.thinkigInJava4ThEdition.chapters.annotations.generatingExternalFiles.SqlString;

class TableCreator {

	public static void main(String[] args) {
		try {
			createTable("books.thinkigInJava4ThEdition.chapters.annotations.generatingExternalFiles.Member");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void createTable(String className) throws ClassNotFoundException {

		List<String> columnDefs = new ArrayList<>();
		String tableName = "";

		Class<?> cl = Class.forName(className);
		DBTable dbTable = cl.getAnnotation(DBTable.class);

		if (dbTable == null) {
			System.out.println("No DBTable annotation in class: " + className);
			return;
		}

		tableName = dbTable.name();

		if (tableName.length() < 1) {
			tableName = cl.getName().toUpperCase();
		}

		for (Field field : cl.getFields()) {
			String columnName = null;
			Annotation[] anns = field.getDeclaredAnnotations();
			if (anns.length < 1) {
				continue; // not a db table column
			}

			if (anns[0] instanceof SqlInteger) {
				SqlInteger sInt = (SqlInteger) anns[0];
				// use the filed name if name not specified
				if (sInt.name().length() < 1) {
					columnName = field.getName().toUpperCase();
				} else {
					columnName = sInt.name();
				}
				columnDefs.add(columnName + " INT" + getContraints(sInt.constraints()));
			}

			if (anns[0] instanceof SqlString) {
				SqlString sString = (SqlString) anns[0];
				if (sString.name().length() < 1) {
					columnName = field.getName().toUpperCase();
				} else {
					columnName = sString.name();
				}
				columnDefs
						.add(columnName + " VARCHAR(" + sString.value() + ")" + getContraints(sString.constraints()));
			}

		}

		StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "( ");

		for (String columnDef : columnDefs) {
			createCommand.append("\n " + columnDef + ",");
		}

		String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";

		System.out.println("Table Creation SQL for " + className + ": \n" + tableCreate);
	}

	private static String getContraints(Constraints con) {
		String constraints = "";
		if (!con.allowNull()) {
			constraints += " NOT NULL";
		}

		if (con.primaryKey()) {
			constraints += " PRIMARY KEY";
		}

		if (con.unique()) {
			constraints += " UNIQUE";
		}

		return constraints;
	}
}
