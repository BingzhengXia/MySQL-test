import java.sql.*;
public class LinkTest {
    public  static void  main(String args[])throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost/shop?user=root&password=mb121605";
        Connection conn=DriverManager.getConnection(url);
        DatabaseMetaData dbmd=conn.getMetaData();
        System.out.println(dbmd.getDriverName()+"  ,  "+dbmd.getDriverVersion()+"\nJDBC URL:" +dbmd.getURL()+"\n用户名："+dbmd.getUserName()+"\n版本："+dbmd.getDatabaseProductVersion());
//        conn.close();
        Statement stmt=conn.createStatement();

        String sql ="SELECT * FROM 考试安排表";
        ResultSet rest=stmt.executeQuery(sql);
        int rowCount=1;

        while (rest.next())
        {
            for(int i=1;i<=12;i++) {
            System.out.print(rest.getString(i) + "\t");
        }
            System.out.println();
            }
        rest.close();
        stmt.close();
        conn.close();

    }
}
