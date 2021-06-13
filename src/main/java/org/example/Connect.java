package org.example;

import oracle.jdbc.pool.OracleDataSource;
import java.sql.*;

public class Connect {

    Connection conn;

    public Connect() {

    }

    //connect
    public void getDBConnection(String jdbcURL,String userid,String password) throws SQLException{
        try{
            OracleDataSource ds;

        ds = new OracleDataSource();
        ds.setURL(jdbcURL);
        conn = ds.getConnection(userid,password);
        System.out.println("polaczono z baza danych!!!!!!!!!!");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public boolean isClosedd() throws SQLException {
        if(conn.isClosed()==false){
            throw new IllegalArgumentException("baza nie zamknieta");
        }
        return true;
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
    
    public void selectClientTable (String clientID) throws SQLException {
        try {
            Statement myStmt = conn.createStatement();
            String query = "SELECT * FROM klient WHERE klient_id=" + clientID;
            myStmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectWorkerTable (String workerID) throws SQLException {
        try {
            Statement myStmt = conn.createStatement();
            String query = "SELECT * FROM pracownicy WHERE pracownik_id=" + workerID;
            myStmt.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectCarTable (String carID) throws SQLException {
        try {
            Statement myStmt = conn.createStatement();
            String query = "SELECT * FROM samochod WHERE samochod_id=" + carID;
            myStmt.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectOrderTable (String orderID) throws SQLException {
        try {
            Statement myStmt = conn.createStatement();
            String query = "SELECT * FROM zamowienie WHERE zamowienie_id=" + orderID;
            myStmt.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteClientData(String clientID) throws SQLException {

        try {
            Statement myStmt = conn.createStatement();
            Statement myStmtt = conn.createStatement();
            String query = "delete from zamowienie where klient_id="+clientID;
            String queryy = "delete from klient where klient_id="+clientID;
            myStmt.executeQuery(query);
            myStmtt.executeQuery(queryy);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void deleteWorkerData(String workerID) throws SQLException {

        try {
            Statement myStmt = conn.createStatement();
            Statement myStmtt = conn.createStatement();
            String query = "delete from zamowienie where pracownik_id="+workerID;
            String queryy = "delete from pracownicy where pracownik_id="+workerID;
            myStmt.executeQuery(query);
            myStmtt.executeQuery(queryy);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    
    public void deleteCarData(String carID) throws SQLException {
        try {
            Statement myStmt = conn.createStatement();
            Statement myStmtt = conn.createStatement();
            String query = "delete from zamowienie where samochod_id="+carID;
            String queryy = "delete from samochod where samochod_id="+carID;
            myStmt.executeQuery(query);
            myStmtt.executeQuery(queryy);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void deleteOrderData(String orderID) throws SQLException {
        try {
            Statement myStmt = conn.createStatement();
            String query = "delete from zamowienie where zamowienie_id="+orderID;
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
