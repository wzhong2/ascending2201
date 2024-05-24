package org.example.respository;
import org.example.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class DepartmentJDBCDao implements DepartmentDao {
    private static final String DB_URL= "jdbc:postgresql://localhost:5431/training_db";
    private static final String USER = "admin";
    private static final String PASS = "Training123!";
    private static final Logger logger = LoggerFactory.getLogger(DepartmentJDBCDao.class);  // singleton pattern

    @Override
    public List<Department> getDepartments() throws SQLException {
        logger.info("Start to getDepartments from Postgres via JDBC.");

        List<Department> departments = new ArrayList<Department>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT * FROM departments";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            logger.info("Connects to DB and execute the query");

            while(rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String location = rs.getString("location");

                Department department = new Department();
                department.setId(id);
                department.setName(name);
                department.setDescription(description);
                department.setLocation(location);
                logger.info("Got department {} from db", department);

                departments.add(department);
            }
        } catch (SQLException e) {
            logger.error("Failed to connect to db or execute query", e);
            throw e;
        } finally {
            try {      // successful or not close database
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
               logger.error("Unable to close db connection", e);
            }
        }
        return departments;
    }
}
