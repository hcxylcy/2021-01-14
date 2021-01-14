package dao.impl;

import bean.Flight;
import dao.IFlightDao;
import sun.plugin2.os.windows.FLASHWINFO;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import static java.lang.Class.*;
public class FlightDaoIml implements IFlightDao
{
    @Override
    public void insertFlight(Flight flight) throws SQLException, ClassNotFoundException {
        String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Plan_Ticket_System";
        String useName="sa";
        String usePwd="19971012";
        /*final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL Server要加载驱动
        Class.forName(DRIVER);*/
        Connection conn=DriverManager.getConnection(URL,useName,usePwd);
        String sql="INSERT INTO Flight VALUES(?,?,?,?,?,?,?)";

        PreparedStatement pstmt=conn.prepareStatement(sql);//可以传入SQL语句
        pstmt.setString(1,flight.getId());
        pstmt.setString(2,flight.getPlaneType());
        pstmt.setString(3,flight.getFlightNo());
        pstmt.setInt(4,flight.getCurrentSeatsNum());
        pstmt.setString(5,flight.getDepartureAirPort());
        pstmt.setString(6,flight.getDestinationAirPort());
        pstmt.setString(7,flight.getDepartureData());

        pstmt.executeUpdate();
        //System.out.println("这是Dao层" + flight);
    }
    @Override
    public Set<Flight> getAllFlights() throws SQLException {
        Set<Flight> allFlight=new HashSet<Flight>();
        String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Plan_Ticket_System";
        String useName="sa";
        String usePwd="19971012";
        Connection conn=DriverManager.getConnection(URL,useName,usePwd);
        String sql="SELECT * FROM flight";
        PreparedStatement pstmt=conn.prepareStatement(sql);//可以传入SQL语句
        ResultSet rs=pstmt.executeQuery();
        while (rs.next())
        {
            String id=rs.getString("id");
            String planeType=rs.getString("planeType");
            String flightNo=rs.getString("flightNo");
            int currentSeatsNum=rs.getInt("currentSeatsNum");
            String departureAirPort=rs.getString("departureAirPort");
            String destinationAirPort=rs.getString("destinationAirPort");
            String departureData=rs.getString("departureData");
            Flight flight = new Flight(id, flightNo, planeType, currentSeatsNum,
                    departureAirPort, destinationAirPort, departureData);
            allFlight.add(flight);
        }
        return allFlight;
    }

    @Override
    public Flight getFlightByDepartureTime(String departureTime) throws SQLException {
        String sql="select planeType,flightNo,currentSeatsNUM,departureAirPort,destinationAirPort,departureData from Flight\n" +
                "where departureData=?";
        String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Plan_Ticket_System";
        String useName="sa";
        String usePwd="19971012";
        Connection conn=DriverManager.getConnection(URL,useName,usePwd);
        Flight flight=null;//只返回一个航班就可
        PreparedStatement pstmt=conn.prepareStatement(sql);//可以传入SQL语句
        pstmt.setString(1,departureTime);
        ResultSet rs=pstmt.executeQuery();
        while (rs.next())
        {
            String planeType=rs.getString("planeType");
            String flightNo=rs.getString("flightNo");
            int currentSeatsNum=rs.getInt("currentSeatsNum");
            String departureAirPort=rs.getString("departureAirPort");
            String destinationAirPort=rs.getString("destinationAirPort");
            String departureData=rs.getString("departureData");
            flight = new Flight(flightNo, planeType, currentSeatsNum,
                    departureAirPort, destinationAirPort, departureData);
        }
        return flight;
    }

    @Override
    public Flight getFlightByDepartureAirPort(String departureAirPort) throws SQLException {
        String sql="select planeType,flightNo,currentSeatsNUM,departureAirPort,destinationAirPort,departureData from Flight\n" +
                "where departureAirPort=?";
        String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Plan_Ticket_System";
        String useName="sa";
        String usePwd="19971012";
        Connection conn=DriverManager.getConnection(URL,useName,usePwd);
        Flight flight=null;//只返回一个航班就可
        PreparedStatement pstmt=conn.prepareStatement(sql);//可以传入SQL语句
        pstmt.setString(1,departureAirPort);
        ResultSet rs=pstmt.executeQuery();
        while (rs.next())
        {
            String planeType=rs.getString("planeType");
            String flightNo=rs.getString("flightNo");
            int currentSeatsNum=rs.getInt("currentSeatsNum");
            String departureAirPorts=rs.getString("departureAirPort");//加了s
            String destinationAirPort=rs.getString("destinationAirPort");
            String departureData=rs.getString("departureData");
            flight = new Flight(flightNo, planeType, currentSeatsNum,
                    departureAirPorts, destinationAirPort, departureData);
        }
        return flight;
    }

    @Override
    public Flight getFlightByDestinationAirPort(String destinationAirPort) throws SQLException {
        String sql="select planeType,flightNo,currentSeatsNUM,departureAirPort,destinationAirPort,departureData from Flight\n" +
                "where destinationAirPort=?";

        String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Plan_Ticket_System";
        String useName="sa";
        String usePwd="19971012";
        Connection conn=DriverManager.getConnection(URL,useName,usePwd);
        Flight flight=null;//只返回一个航班就可
        PreparedStatement pstmt=conn.prepareStatement(sql);//可以传入SQL语句
        pstmt.setString(1,destinationAirPort);
        ResultSet rs=pstmt.executeQuery();
        while (rs.next())
        {
            String planeType=rs.getString("planeType");
            String flightNo=rs.getString("flightNo");
            int currentSeatsNum=rs.getInt("currentSeatsNum");
            String departureAirPorts=rs.getString("departureAirPort");//加了s
            String destinationAirPorts=rs.getString("destinationAirPort");
            String departureData=rs.getString("departureData");
            flight = new Flight(flightNo, planeType, currentSeatsNum,
                    departureAirPorts, destinationAirPorts, departureData);
        }
        return flight;
    }

    @Override
    public void updateFlight(Flight flight) {

    }
}
