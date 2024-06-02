import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "1234";

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //for register the driver
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,username,password);


            //delete student from db
//            String query = "DELETE FROM student WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,7);
//            int rowaffected = preparedStatement.executeUpdate();
//            if(rowaffected>0){
//                System.out.println("Data Deleted Successfully");
//            }else{
//                System.out.println("Not Deleted");
//            }

            //update student from db
//            String query = "UPDATE student SET marks = ? WHERE id= ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setDouble(1,90.6);
//            preparedStatement.setInt(2,1);
//            int rowaffcted = preparedStatement.executeUpdate();
//            if(rowaffcted>0){
//                System.out.println("Data Updated Successfully");
//            }else{
//                System.out.println("Not updated");
//            }

            //Select specific student from db
//            String query = "SELECT marks FROM student WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,1);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if(resultSet.next()){
//                double marks = resultSet.getDouble("marks");
//                System.out.println("Marks: "+marks);
//            }

            //Insert data to DB
//            String query = "INSERT INTO student(name,age,marks) VALUES(?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1,"Adarsh");
//            preparedStatement.setInt(2,23);
//            preparedStatement.setDouble(3,75.9);
//            int rowsAffected = preparedStatement.executeUpdate();
//            if(rowsAffected>0){
//                System.out.println("Data Inserted Successfully");
//            }else{
//                System.out.println("Data is not Inserted");
//            }
/*
Key Differences on String.format and PreparedStatement

PreparedStatement: It is safer against SQL injection attacks because the values are set separately from the
query string.

String.format: It is more prone to SQL injection attacks because the values are directly embedded into the
query string.

PreparedStatement: Separates the query structure from the data, making it more readable and maintainable,
especially for dynamic or user-provided input.

String.format: Combines the query structure and data, which can be less readable and harder to maintain,
particularly with complex queries or user inputs.

In summary, PreparedStatement is generally the preferred approach for executing SQL statements with parameters
due to its security, readability, and performance benefits. Using String.format can be simpler for quick and
small-scale queries but comes with significant risks and drawbacks.
 */

            //  Statement statement = connection.createStatement();


            //Delete the data from db
//            String query = "DELETE FROM student WHERE ID =6";
//
//            int rowsAffected = statement.executeUpdate(query);
//           if(rowsAffected>0){
//                System.out.println("Data Deleted successfully");
//            }else{
//                System.out.println("Data is not Deleted");
//            }

//            //update the data to db
//            String query = String.format("UPDATE student SET marks =%f WHERE id = %d",75.90,6);
//
//            int rowsAffected = statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("Data Updated successfully");
//            }else{
//                System.out.println("Data is not Updated");
//            }

            //insert the data to db
//            String query = String.format("INSERT INTO student(name,age,marks) VALUES('%s',%o,%f)","Adarsh",23,70.8);
//
//            int rowsAffected = statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("Data Inserted successfully");
//            }else{
//                System.out.println("Data is not inserted");
//            }

          //  display the data from table
            Statement statement = connection.createStatement();
            String query = "select * from student";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");
                System.out.println("ID:"+id);
                System.out.println("Name:"+name);
                System.out.println("Age:"+age);
                System.out.println("Marks:"+marks);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}