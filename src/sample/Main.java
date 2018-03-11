package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Cabinet.fxml"));
        primaryStage.setTitle("Cabinet Veterinar");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }



    public static void main(String[] args)
    {String ConnectionString = "jdbc:sqlserver://DESKTOP-PN7QGR6:1433;databaseName=BD;user=sa;password=0000;integratedSecurity=false";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            DriverManager.getConnection(ConnectionString);
            System.out.println("Successful connection");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        launch(args);
    }
}
