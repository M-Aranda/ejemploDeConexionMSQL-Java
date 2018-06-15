/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarconmssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectMSSQLServer
{
   public void dbConnect(String db_connect_string,
            String db_userid,
            String db_password)
   {
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection conn = DriverManager.getConnection("jdbc:sqlserver://MARCELO;databaseName=soporteAPDI;integratedSecurity=true");
        // La URL es importante
         //db_connect_string,
           //       db_userid, db_password);
         System.out.println("connected");
         Statement statement = conn.createStatement();
         String queryString = "SELECT nombre FROM tipoDelito WHERE id=2";
         ResultSet rs = statement.executeQuery(queryString);
         while (rs.next()) {
            System.out.println(rs.getString(1));
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args)
   {
      ConnectMSSQLServer connServer = new ConnectMSSQLServer();
      connServer.dbConnect("jdbc:sqlserver://soporteAPDI", "<MARCELO>",
               "<password>");
   }
}
