package oc.p.chapters._10_.obtainingAStatement.choosingAResultSet.w_1;

import utils.resources.db.Dbs;
import utils.resources.db.instance.embedded.derby.ZooDb;
import utils.resources.files.Resources;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StmtArgs {

    static void m() {
        String url = Dbs.ZOO.url();
        final List <ResultSetFlag> values = Arrays.asList(ResultSetFlag.values());
        List <Pair <Integer>> pairs = new Combination().combs(values.size() - 1);
        List <Pair <ResultSetFlag>> errors = new ArrayList <>();

        long count = 0;

        try (Connection conn = DriverManager.getConnection(url)) {
            count = pairs.stream()
                    .map(pair -> new Pair <ResultSetFlag>(values.get(pair.getI()), values.get(pair.getJ())))
                    .map(pair -> {
                        try {
                            Statement stmt = conn.createStatement(pair.getI().getFlag(), pair.getJ().getFlag());
                            return stmt.executeQuery(ZooDb.Animal.SELECT);
                        } catch (SQLException e) {
                            errors.add(pair);
                            return null;
                        }
                    })
                    .filter(rs -> rs != null)
                    .count();
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }

        System.out.println("Total: " + pairs.size());
        System.out.println("Total without err: " + count);
        System.out.println(errors);
    }

    public static void main(String[] args) {
        m();
        Resources.clean();
    }

    enum ResultSetFlag {
        TYPE_FORWARD_ONLY(ResultSet.TYPE_FORWARD_ONLY),
        TYPE_SCROLL_INSENSITIVE(ResultSet.TYPE_SCROLL_INSENSITIVE),
        TYPE_SCROLL_SENSITIVE(ResultSet.TYPE_SCROLL_SENSITIVE),
        CONCUR_READ_ONLY(ResultSet.CONCUR_READ_ONLY),
        CONCUR_UPDATABLE(ResultSet.CONCUR_UPDATABLE);

        private Integer flag;

        ResultSetFlag(final Integer flag) {
            this.flag = flag;
        }

        Integer getFlag() {
            return flag;
        }
    }
}
