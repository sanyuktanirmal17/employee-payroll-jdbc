package DBFile;



	import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.EmployeeData;

public class EmployeeDBService {

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/employee_payroll?useSSL=false";
        String userName = "root";
        String password = "root";
        Connection connection;
        System.out.println("Connectinng to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!!!" + connection);
        return connection;
    }

    public List<EmployeeData> readData()  {
        String sql = "SELECT * FROm employee_payroll;";
        List<EmployeeData> employeePayrollList = new ArrayList<>();
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                LocalDate startDate = resultSet.getDate("startDate").toLocalDate();
                employeePayrollList.add(new EmployeeData(id, name, salary, startDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeePayrollList;
    }
}

