package sample;

import java.io.*;
import java.util.Properties;

public class ConfigurationFile {
        private String User = null;
        private String Password = null;
        private String Database = null;
        private String Server = null;
        private Boolean IntegratedSecurity = true;

        //region Constructor
        public ConfigurationFile(){
            this.GetConnectionProperties();
        }

        //endregion

        //region Methods
        public static void SetConnectionProperties( String serverName,
                                                    Boolean integratedSecurity,
                                                    String databaseName,
                                                    String user,
                                                    String password) {

            Properties prop = new Properties();
            OutputStream output = null;

            try {

                output = new FileOutputStream("config.properties");

                // set the properties value
                prop.setProperty("Server Name", serverName);
                prop.setProperty("Database Name", databaseName);
                prop.setProperty("User", user);
                prop.setProperty("Password", password);
                prop.setProperty("Integrated Security", String.valueOf(integratedSecurity));

                // save properties to project root folder
                prop.store(output, null);

            } catch (IOException io) {
                io.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        public void GetConnectionProperties() {
            Properties properties = new Properties();
            InputStream input = null;

            try {

                input = new FileInputStream("config.properties");

                // load a properties file
                properties.load(input);

                // get the property value and print it out
                this.Server = String.valueOf(properties.getProperty("Server Name"));
                this.Database = String.valueOf(properties.getProperty("Database Name"));
                this.User = String.valueOf(properties.getProperty("User"));
                this.Password = String.valueOf(properties.getProperty("Password"));
                this.IntegratedSecurity = Boolean.valueOf(properties.getProperty("Integrated Security"));

            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // endregion Methods

        //region Get fields
        public String getDatabase() {
            return Database;
        }

        public Boolean getIntegratedSecurity() {
            return IntegratedSecurity;
        }

        public String getPassword() {
            return Password;
        }

        public String getServer() {
            return Server;
        }

        public String getUser() {
            return User;
        }

        public String getConnectionString() {
            return "";
        }
        //endregion
}
