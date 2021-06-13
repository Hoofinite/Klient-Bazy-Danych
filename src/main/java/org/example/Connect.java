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
    public boolean getDBConnection() throws SQLException{
        try{
            OracleDataSource ds;

        ds = new OracleDataSource();
        ds.setURL(jdbcURL);
        conn = ds.getConnection(userid,password);
        if (conn == )
        System.out.println("polaczono z baza danych!!!!!!!!!!");
        return true;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
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
    
    public void selectTable () throws SQLException {
        Scanner scan = new Scanner(System.in);
        try {
            Statement myStmt = conn.createStatement();
            System.out.println("Którą tabelę chcesz wyświetlić?\n" +
                    "1. Klient\n" +
                    "2. Pracownicy\n" +
                    "3. Samochod\n" +
                    "4. Zamówienie\n" +
                    "5. Płatności\n");
            int t = scan.nextInt();
            if (t == 1) {
                System.out.println("Podaj ilość kolumn, które mają zostać wyświetlone\n" +
                        "1. Wszystkie\n" +
                        "2. Jedna\n" +
                        "3. Dwie\n" +
                        "4. Trzy\n" +
                        "5. Cztery\n" +
                        "6. Pięć\n" +
                        "7. Sześć\n");
                int t1 = scan.nextInt();
                if (t1 == 1) {
                    String query = "SELECT * FROM klient;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 2) {
                    System.out.println("Podaj nazwę kolumny do wyświetlenia (klient_id, nazwisko, imie, pesel, miejscowosc, ulica, numer_domu): ");
                    String kol = scan.nextLine();
                    String query = "SELECT " + kol + "FROM klient;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 3) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (klient_id, nazwisko, imie, pesel, miejscowosc, ulica, numer_domu): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String query = "SELECT " + kol1 + "," + kol2 + "FROM klient;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 4) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (klient_id, nazwisko, imie, pesel, miejscowosc, ulica, numer_domu): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + "FROM klient;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 5) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (klient_id, nazwisko, imie, pesel, miejscowosc, ulica, numer_domu): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String kol4 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + ", " + kol4 + "FROM klient;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 6) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (klient_id, nazwisko, imie, pesel, miejscowosc, ulica, numer_domu): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String kol4 = scan.nextLine();
                    String kol5 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + ", " + kol4 +  ", " + kol5 + "FROM klient;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 7) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (klient_id, nazwisko, imie, pesel, miejscowosc, ulica, numer_domu): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String kol4 = scan.nextLine();
                    String kol5 = scan.nextLine();
                    String kol6 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + ", " + kol4 +  ", " + kol5 + ", " + kol6 + "FROM klient;";
                    myStmt.executeQuery(query);
                }
                else {
                    System.out.println("Błędne dane!");
                }
            }
            else if(t == 2) {
                System.out.println("Podaj ilość kolumn, które mają zostać wyświetlone\n" +
                        "1. Wszystkie\n" +
                        "2. Jedna\n" +
                        "3. Dwie\n" +
                        "4. Trzy\n" +
                        "5. Cztery\n");
                int t1 = scan.nextInt();
                if (t1 == 1) {
                    String query = "SELECT * FROM pracownicy;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 2) {
                    System.out.println("Podaj nazwę kolumny do wyświetlenia (pracownik_id, nazwisko, imie, zarobki, stanowisko): ");
                    String kol = scan.nextLine();
                    String query = "SELECT " + kol + "FROM pracownicy;";
                    myStmt.executeQuery(query);
                }
                if (t1 == 3) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (pracownik_id, nazwisko, imie, zarobki, stanowisko): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String query = "SELECT " + kol1 + "," + kol2 + "FROM pracownicy;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 4) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (pracownik_id, nazwisko, imie, zarobki, stanowisko): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + "FROM pracownicy;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 5) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (pracownik_id, nazwisko, imie, zarobki, stanowisko): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String kol4 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + ", " + kol4 + "FROM pracownicy;";
                    myStmt.executeQuery(query);
                }
                else {
                    System.out.println("Błędne dane!");
                }
            }
            else if (t == 3) {
                System.out.println("Podaj ilość kolumn, które mają zostać wyświetlone\n" +
                        "1. Wszystkie\n" +
                        "2. Jedna\n" +
                        "3. Dwie\n" +
                        "4. Trzy\n" +
                        "5. Cztery\n" +
                        "6. Pięć\n");
                int t1 = scan.nextInt();
                if (t1 == 1) {
                    String query = "SELECT * FROM samochod;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 2) {
                    System.out.println("Podaj nazwę kolumny do wyświetlenia (samochod_id, marka, model, vin, rocznik, cena): ");
                    String kol = scan.nextLine();
                    String query = "SELECT " + kol + "FROM samochod;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 3) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (samochod_id, marka, model, vin, rocznik, cena): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String query = "SELECT " + kol1 + "," + kol2 + "FROM samochod;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 4) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (samochod_id, marka, model, vin, rocznik, cena): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + "FROM samochod;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 5) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (samochod_id, marka, model, vin, rocznik, cena): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String kol4 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + ", " + kol4 + "FROM samochod;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 6) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (samochod_id, marka, model, vin, rocznik, cena): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String kol4 = scan.nextLine();
                    String kol5 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + ", " + kol4 +  ", " + kol5 + "FROM samochod;";
                    myStmt.executeQuery(query);
                }
                else {
                    System.out.println("Błędne dane!");
                }
            }
            else if(t == 4) {
                System.out.println("Podaj ilość kolumn, które mają zostać wyświetlone\n" +
                        "1. Wszystkie\n" +
                        "2. Jedna\n" +
                        "3. Dwie\n" +
                        "4. Trzy\n" +
                        "5. Cztery\n" +
                        "6. Pięć\n" +
                        "7. Sześć\n" +
                        "8. Siedem\n" +
                        "9. Osiem\n");
                int t1 = scan.nextInt();
                if (t1 == 1) {
                    String query = "SELECT * FROM zamowienia;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 2) {
                    System.out.println("Podaj nazwę kolumny do wyświetlenia (zamowienie_id, klient_id, pracownik_id, samochod_id, platnosc_id, rok, miesiac, dzien, koszt): ");
                    String kol = scan.nextLine();
                    String query = "SELECT " + kol + "FROM zamowienie;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 3) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia: ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String query = "SELECT " + kol1 + "," + kol2 + "FROM zamowienie;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 4) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (zamowienie_id, klient_id, pracownik_id, samochod_id, platnosc_id, rok, miesiac, dzien, koszt): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + "FROM zamowienie;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 5) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (zamowienie_id, klient_id, pracownik_id, samochod_id, platnosc_id, rok, miesiac, dzien, koszt): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String kol4 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + ", " + kol4 + "FROM zamowienie;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 6) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (zamowienie_id, klient_id, pracownik_id, samochod_id, platnosc_id, rok, miesiac, dzien, koszt): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String kol4 = scan.nextLine();
                    String kol5 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + ", " + kol4 +  ", " + kol5 + "FROM zamowienie;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 7) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (zamowienie_id, klient_id, pracownik_id, samochod_id, platnosc_id, rok, miesiac, dzien, koszt): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String kol4 = scan.nextLine();
                    String kol5 = scan.nextLine();
                    String kol6 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + ", " + kol4 +  ", " + kol5 + ", " + kol6 + "FROM zamowienie;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 8) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (zamowienie_id, klient_id, pracownik_id, samochod_id, platnosc_id, rok, miesiac, dzien, koszt): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String kol4 = scan.nextLine();
                    String kol5 = scan.nextLine();
                    String kol6 = scan.nextLine();
                    String kol7 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + ", " + kol4 +  ", " + kol5 + ", " + kol6 + ", " + kol7 + "FROM zamowienie;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 9) {
                    System.out.println("Podaj nazwy kolumn do wyświetlenia (zamowienie_id, klient_id, pracownik_id, samochod_id, platnosc_id, rok, miesiac, dzien, koszt): ");
                    String kol1 = scan.nextLine();
                    String kol2 = scan.nextLine();
                    String kol3 = scan.nextLine();
                    String kol4 = scan.nextLine();
                    String kol5 = scan.nextLine();
                    String kol6 = scan.nextLine();
                    String kol7 = scan.nextLine();
                    String kol8 = scan.nextLine();
                    String query = "SELECT " + kol1 + ", " + kol2 + ", " + kol3 + ", " + kol4 +  ", " + kol5 + ", " + kol6 + ", " + kol7 + ", " + kol8 + "FROM zamowienie;";
                    myStmt.executeQuery(query);
                }
                else {
                    System.out.println("Błędne dane!");
                }
            }
            else if(t == 5) {
                System.out.println("Podaj ilość kolumn, które mają zostać wyświetlone\n" +
                        "1. Wszystkie\n" +
                        "2. Jedna\n");
                int t1 = scan.nextInt();
                if (t1 == 1) {
                    String query = "SELECT * FROM platnosci;";
                    myStmt.executeQuery(query);
                }
                else if (t1 == 2) {
                    System.out.println("Podaj nazwę kolumny do wyświetlenia (platnosc_id, metoda_platnosci): ");
                    String kol = scan.nextLine();
                    String query = "SELECT " + kol + "FROM platnosci;";
                    myStmt.executeQuery(query);
                }
                else {
                    System.out.println("Błędne dane!");
                }
            }
            else {
                System.out.println("Błędne dane!");
            }
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
