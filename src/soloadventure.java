import java.sql.*;

        public class soloadventure {

            public static void main(String[] args) {
                try {
                    // Set up connection to database
                    Connection conn = getConnection();

                    // Setup statement
                    String stmt = getBody(conn);

                    // Close conn and stmt
                    conn.close();
                    //stmt.close();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }

            public static String getBody(Connection conn) throws SQLException {
                Statement stmt = conn.createStatement();
                // Create query and execute
                String strSelect = "select body from story where id = 1";
                System.out.println("The SQL statement is: " + strSelect + "\n");

                ResultSet rset = stmt.executeQuery(strSelect);

                // Loop through the result set and print

                System.out.println("The records selected are:");
                int rowCount = 0;
                String title = "";
                while(rset.next()) {
                    title = rset.getString("body");
                    System.out.println(title);
                    ++rowCount;
                }
                System.out.println("Total number of records = " + rowCount);
                return title;
            }

            public static Connection getConnection() throws SQLException {
                return DriverManager.getConnection(
                                        "jdbc:mysql://"+DatabaseLoginData.DBURL + ":" + DatabaseLoginData.port + "/" + DatabaseLoginData.DBname +
                                                "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                                        DatabaseLoginData.user, DatabaseLoginData.password);
            }
        }



