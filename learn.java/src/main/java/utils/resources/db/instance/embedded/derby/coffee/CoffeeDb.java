package utils.resources.db.instance.embedded.derby.coffee;

import utils.resources.db.DbDefinition;
import utils.resources.db.DbInstance;
import utils.resources.files.Resources;
import javax.print.attribute.HashAttributeSet;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoffeeDb extends DbInstance {

    private static final String CREATE = "create-tables.sql";
    private static final String POPULATE = "populate-tables.sql";
    private static CoffeeDb instance;

    private CoffeeDb(DbDefinition dbDefinition) {
        super(dbDefinition);
    }

    public static synchronized DbInstance dbInstance(DbDefinition def) {
        if(instance == null) {
            synchronized(CoffeeDb.class) {
                instance = new CoffeeDb(def);
            }
        }
        return instance;
    }

    @Override
    protected void createAndPopulate() {
        try(Connection conn = DriverManager.getConnection(dbDefinition.createUrl());
            Statement stmt = conn.createStatement()) {
            Package pkg = this.getClass().getPackage();
            execStmt(stmt, pkg, CREATE);
            execStmt(stmt, pkg, POPULATE);

        } catch(SQLException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void execStmt(Statement stmt, Package pkg, String create) throws IOException {
        Path path = Paths.get(Resources.SRC_MAIN_JAVA, Resources.path(pkg), create);
        String content = Files.lines(path)
                              .collect(Collectors.joining());
        List<String> tryAgain = new ArrayList<>();
        Queue<String> queue = Arrays.stream(content.split(";"))
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        while(queue.size()>0){
            String s = queue.poll();
            if(s!=null){
                try {
                    stmt.executeUpdate(s);
                } catch(SQLException e) {
                    queue.add(s);
                }
            }
        }



    }
}
