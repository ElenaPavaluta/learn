package utils.print;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Print {

    public static final int CELL_LENGTH = 25;

    public static void print(String name, boolean b) {
        System.out.println(name + ": " + b);
    }

    public static void print(String name, byte nr) {
        System.out.println(name + ": " + nr);
    }

    public static void print(String name, short nr) {
        System.out.println(name + ": " + nr);
    }

    public static void print(String name, int nr) {
        System.out.println(name + ": " + nr);
    }

    public static void print(String name, long nr) {
        System.out.println(name + ": " + nr);
    }

    public static void print(String name, float nr) {
        System.out.println(name + ": " + nr);
    }

    public static void print(String name, double nr) {
        System.out.println(name + ": " + nr);
    }

    public static void print(String name, char c) {
        System.out.println(name + ": " + c);
    }

    public static void print(String name, Object obj) {
        System.out.println(name + ": " + obj);
    }

    public static void print(ResultSet resultSet) throws SQLException {
        List<String> lst = IntStream.rangeClosed(1, resultSet.getMetaData().getColumnCount())
                                    .mapToObj(i -> getColumnName(resultSet, i))
                                    .collect(toList());
        StringBuilder sb = new StringBuilder();
        sb.append(marginForResultSetPrint(lst));
        for(String s : lst) {
            sb.append(cell(s));
        }
        sb.append("\n");
        sb.append(marginForResultSetPrint(lst));

        while(resultSet.next()) {
            for(String s : lst) {
                sb.append(cell(resultSet.getString(s)));
            }
            sb.append("\n");
        }
        sb.append(marginForResultSetPrint(lst));
        System.out.println(sb);
    }

    private static String marginForResultSetPrint(List<String> lst) {
        return IntStream.range(0, CELL_LENGTH * lst.size()).mapToObj(i -> "-").collect(joining()) + "\n";
    }

    private static String getColumnName(ResultSet resultSet, int i) {
        try {
            return resultSet.getMetaData().getColumnName(i);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String cell(String s) {
        return s + IntStream.rangeClosed(0, CELL_LENGTH - s.length()).mapToObj(i -> " ").collect(joining());
    }

    private static String getColumnValue(ResultSet resultSet, String name) {
        try {
            if(resultSet.next()) {
                return resultSet.getString(name);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(cell("Adam") + "a");
    }

    public static class Delimitators {

        private static final int NB = 10;

        public static void equal() {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < NB; i++) {
                sb.append("=");
            }
            System.out.println(sb.toString());
        }

        public static void newLine() {
            System.out.println();
        }
    }
}
