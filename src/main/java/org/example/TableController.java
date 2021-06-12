package org.example;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable,Integer> col_id;
    @FXML
    private TableColumn<ModelTable,String> col_nazwisko;
    @FXML
    private TableColumn<ModelTable,String> col_imie;
    @FXML
    private TableColumn<ModelTable,Integer> col_pesel;
    @FXML
    private TableColumn<ModelTable,String> col_miejscowosc;
    @FXML
    private TableColumn<ModelTable,String> col_ulica;
    @FXML
    private TableColumn<ModelTable,Integer> col_nrdomu;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from klient");
            while (rs.next()){
                oblist.add(new ModelTable(rs.getInt("klient_id"),rs.getString("nazwisko"),rs.getString("imie")
                ,rs.getInt("pesel"),rs.getString("miejscowosc"),rs.getString("ulica"),rs.getInt("numer_domu")
                ));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        col_id.setCellValueFactory(new PropertyValueFactory<>("klient_id"));
        col_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        col_pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        col_miejscowosc.setCellValueFactory(new PropertyValueFactory<>("miejscowosc"));
        col_ulica.setCellValueFactory(new PropertyValueFactory<>("ulica"));
        col_nrdomu.setCellValueFactory(new PropertyValueFactory<>("numerDomu"));

        table.setItems(oblist);

    }
}
