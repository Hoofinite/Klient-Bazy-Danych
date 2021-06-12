package org.example;

import oracle.jdbc.pool.OracleDataSource;
import java.sql.*;


public class Connect {
    String jdbcURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    String userid = "humba";
    String password = "12345";
    Connection conn;






    public Connect() {

    }

    //connect
    public void getDBConnection() throws SQLException{
        try{
            OracleDataSource ds;

        ds = new OracleDataSource();
        ds.setURL("jdbc:oracle:thin:@localhost:1521:ORCL");
        conn = ds.getConnection(userid,password);
        System.out.println("polaczono z baza danych!!!!!!!!!!");

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void insertClientsData(String secondName,String name,String pesel,String miejscowo, String street,String houseNumber) throws SQLException {
        try {
            Statement myStmt = conn.createStatement();
            String query = "insert into klient (klient_id,nazwisko,imie,pesel,miejscowosc,ulica,numer_domu) values (klientdane.nextval,'"+secondName+"','"+name+"','"+pesel+"','"+miejscowo+"','"+street+"','"+houseNumber+"')";
            myStmt.executeQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void insertWorkersData(String secondName,String name,String earnings,String position) throws SQLException {
        try {
            Statement myStmt = conn.createStatement();
            String query = "insert into pracownicy (pracownik_id,nazwisko,imie,zarobki,stanowisko) values " + "(pracownicydane.nextval,'"+secondName+"','"+name+"',"+earnings+",'"+position+"')";
            myStmt.executeQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void insertCarData(String carMake,String carModel,String vinNumber,String prodYear,String price) throws SQLException {
        try {
            Statement myStmt = conn.createStatement();
            String query = "insert into samochod (samochod_id,marka,model,vin,rocznik,cena) values " + "(samochoddane.nextval,'"+carMake+"','"+carModel+"','"+vinNumber+"',"+prodYear+","+price+")";
            myStmt.executeQuery(query);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void insertOrderData(String clientID,String workerID,String carID,int paymentMethod,String yearOrder,String monthOrder,String dayOrder,String priceOrder) throws SQLException {
        try {
            Statement myStmt = conn.createStatement();
            String query = "insert into zamowienie (zamowienie_id,klient_id,pracownik_id,samochod_id,platnosc_id,rok,miesiac,dzien,koszt) values " + "(zamowieniadane.nextval,"+clientID+","+workerID+","+carID+","+paymentMethod+","+yearOrder+","+monthOrder+","+dayOrder+","+priceOrder+")";
            myStmt.executeQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    //disconnect
    public void disconnect(){

        try {
            conn.close();
            if(conn.isClosed())
            System.out.println("rozlaczono z baza danych");

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }


    }




}
