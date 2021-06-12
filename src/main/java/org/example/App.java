package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * JavaFX App
 */
public class App extends Application implements EventHandler<ActionEvent> {
    Stage window;
    Scene scene,scene1,scene2,scene3,sceneCar,sceneOrder;

    static Connect connect = null;


    @Override
    public void start(Stage stage) {

        window = stage;


        Button buttonAdd = new Button("Dodaj nowy rekord");
        buttonAdd.setOnAction(e -> changeScene(window,scene1));
        //layout - gdzie sa ukladane elementy w pionowych kolumnach
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(buttonAdd);
        scene = new Scene(layout,800, 800);


        //scena1- wybor nowego rekordu
        VBox nowyLad = new VBox(20);
        nowyLad.setAlignment(Pos.CENTER);
        Label napis = new Label("Co chcesz dodac?");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Klienta");
        choiceBox.getItems().add("Pracownika");
        choiceBox.getItems().add("Samochod");
        choiceBox.getItems().add("Zamowienie");
        choiceBox.setOnAction(e-> {
                    int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
                    Object selectedItem = choiceBox.getSelectionModel().getSelectedItem();
                    System.out.println("zmiana dokonana: ["+selectedIndex+"]"+selectedItem);
                    System.out.println("choiceBox.getValue():"+choiceBox.getValue());
                   // do {
                        try {
                            switch (selectedIndex) {
                                case 0:
                                    changeScene(window, scene2);
                                    break;
                                case 1:
                                    changeScene(window, scene3);
                                    break;
                                case 2:
                                    changeScene(window,sceneCar);
                                    break;
                                case 3:
                                    changeScene(window,sceneOrder);
                                    break;
                                default:
                                    System.out.println("nie dokonano wyboru");
                            }
                        } catch (Exception exc) {
                            exc.printStackTrace();
                        }
                   // }while(choiceBox.isPressed());



        });

        Button backOption = new Button("Powrot");
        backOption.setOnAction(e-> changeScene(window,scene));
        nowyLad.setSpacing(25);
        nowyLad.getChildren().addAll(napis,choiceBox,backOption);
        scene1 = new Scene(nowyLad,800,800);


        //scena2 - wybrana opcja
        VBox klienci = new VBox(15);
        klienci.setAlignment(Pos.CENTER);
        Label imi = new Label("Imie: ");
        TextField imie1 = new TextField();
        imie1.setMaxWidth(100);

        Label nazwisk = new Label("Nazwisko: ");
        TextField nazwisko1 = new TextField();
        nazwisko1.setMaxWidth(100);

        Label pes = new Label("Pesel: ");
        TextField pesel1 = new TextField();
        pesel1.setMaxWidth(100);

        Label miejsc = new Label("Miejscowosc: ");
        TextField miejscowosc1 = new TextField();
        miejscowosc1.setMaxWidth(100);

        Label ulic = new Label("Ulica: ");
        TextField ulica1 = new TextField();
        ulica1.setMaxWidth(100);

        Label nrdom = new Label("Numer domu: ");
        TextField nrdomu1 = new TextField();
        nrdomu1.setMaxWidth(100);


        Button add = new Button("Dodaj rekord");
        Button backOptio = new Button("Powrot");
        backOptio.setOnAction(e->changeScene(window,scene1));

        add.setOnAction(e->{try {
            connect.insertClientsData(nazwisko1.getText(),imie1.getText(), pesel1.getText(),miejscowosc1.getText(),ulica1.getText(),nrdomu1.getText());
            AlertBox.display("Dodawanie klienta","dodano pomyślnie");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } });
        klienci.getChildren().addAll(imi,imie1,nazwisk,nazwisko1,pes,pesel1,miejsc,miejscowosc1,ulic,ulica1,nrdom,nrdomu1,add,backOptio);
        scene2 = new Scene(klienci,800,800);





        //scene3 - odpowiedzialna za utworzenie formularza dodawania nowego pracownika
        VBox pracownik = new VBox(15);
        pracownik.setAlignment(Pos.CENTER);
        Label prImie = new Label("Imie: ");
        TextField prImie1 = new TextField();
        prImie1.setMaxWidth(100);

        Label prNazwisk = new Label("Nazwisko: ");
        TextField prNazwisko1 = new TextField();
        prNazwisko1.setMaxWidth(100);

        Label prZarobki = new Label("Zarobki: ");
        TextField prZarobki1 = new TextField();
        prZarobki1.setMaxWidth(100);

        Label prStanowisko = new Label("Stanowisko: ");
        TextField prStanowisko1 = new TextField();
        prStanowisko1.setMaxWidth(100);

        Button addPr = new Button("Dodaj pracownika");
        Button back = new Button("Powrot");
        pracownik.getChildren().addAll(prImie,prImie1,prNazwisk,prNazwisko1,prZarobki,prZarobki1,prStanowisko,prStanowisko1,
                addPr,back);
        addPr.setOnAction(e->{
            {try {
                     connect.insertWorkersData(prNazwisko1.getText(),prImie1.getText(),prZarobki1.getText(),prStanowisko1.getText());
                     AlertBox.display("Dodawanie pracownika","dodano pomyślnie");
                 } catch (SQLException throwables) {
                       throwables.printStackTrace();
                                                    }
            }                });
        back.setOnAction(e->{
            changeScene(window,scene1);
        });

        scene3 = new Scene(pracownik,800,800);




        //scena4 - wybrana opcja dodania samochodu
        VBox car = new VBox(15);
        car.setAlignment(Pos.CENTER);
        Label carMake = new Label("Marka: ");
        TextField carMake1 = new TextField();
        carMake1.setMaxWidth(100);

        Label carModel = new Label("Model: ");
        TextField carModel1 = new TextField();
        carModel1.setMaxWidth(100);

        Label vinNumber = new Label("Numer VIN: ");
        TextField vinNumber1 = new TextField();
        vinNumber1.setMaxWidth(100);

        Label prodYear = new Label("Rok produkcji auta: ");
        TextField prodYear1 = new TextField();
        prodYear1.setMaxWidth(100);

        Label carPrice = new Label("Cena: ");
        TextField carPrice1 = new TextField();
        carPrice1.setMaxWidth(100);

        Button addd = new Button("Dodaj samochod");
        Button backOpti = new Button("Powrot");
        backOpti.setOnAction(e->changeScene(window,scene1));
        addd.setOnAction(e->{try {
            connect.insertCarData(carMake1.getText(),carModel1.getText(), vinNumber1.getText(),prodYear1.getText(),carPrice1.getText());
            AlertBox.display("Dodawanie auta","dodano pomyślnie");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } });
        car.getChildren().addAll(carMake,carMake1,carModel,carModel1,vinNumber,vinNumber1,prodYear,prodYear1,carPrice,carPrice1,addd,backOpti);
        sceneCar = new Scene(car,800,800);






        //scena5 - wybrana opcja dodania zamowienia
        VBox order = new VBox(15);
        order.setAlignment(Pos.CENTER);
        Label clientID = new Label("Identyfikator klienta: ");
        TextField clientID1 = new TextField();
        clientID1.setMaxWidth(100);

        Label workerID = new Label("Identyfikator pracownika:");
        TextField workerID1 = new TextField();
        workerID1.setMaxWidth(100);

        Label carID = new Label("Identyfikator samochodu: ");
        TextField carID1 = new TextField();
        carID1.setMaxWidth(100);
        AtomicInteger selectedIndexx = new AtomicInteger();
        Label paymentMethod = new Label("Identyfikator platnosci:");
        ComboBox paymentMethod1 = new ComboBox();
        paymentMethod1.getItems().addAll("karta","gotowka","przelew");

        paymentMethod1.setOnAction(e->{
            int selectedIndexxx = paymentMethod1.getSelectionModel().getSelectedIndex();
            System.out.println("pierwszy sop:"+(selectedIndexxx+1));
        });


        Label yearOrder = new Label("Rok zamowienia: ");
        TextField yearOrder1 = new TextField();
        yearOrder1.setMaxWidth(100);
        Label monthOrder = new Label("Miesiac zamowienia: ");
        TextField monthOrder1 = new TextField();
        monthOrder1.setMaxWidth(100);
        Label dayOrder = new Label("Dzien zamowienia: ");
        TextField dayOrder1 = new TextField();
        dayOrder1.setMaxWidth(100);
        Label priceOrder = new Label("Koszt zamowienia: ");
        TextField priceOrder1 = new TextField();
        priceOrder1.setMaxWidth(100);


        Button adddd = new Button("Dodaj zamowienie");
        Button backOpt = new Button("Powrot");
        backOpt.setOnAction(e->changeScene(window,scene1));
        adddd.setOnAction(e->{try {
            connect.insertOrderData(clientID1.getText(),workerID1.getText(), carID1.getText(), (paymentMethod1.getSelectionModel().getSelectedIndex()+1),yearOrder1.getText(),monthOrder1.getText(),dayOrder1.getText(),priceOrder1.getText());
            AlertBox.display("Dodawanie nowego zamowienia","dodano pomyślnie");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } });
        order.getChildren().addAll(clientID,clientID1,workerID,workerID1,carID,carID1,paymentMethod,paymentMethod1,yearOrder,yearOrder1,monthOrder,monthOrder1, dayOrder,dayOrder1,priceOrder,priceOrder1,adddd,backOpt);
        sceneOrder = new Scene(order,800,800);








        changeScene(window,scene);
        window.show();
        window.setTitle("Klient bazy danych");
      /*  window.setOnCloseRequest(e -> {
            e.consume();
            //e.close();
            //do dorobienia zamykanie programu
        });*/

    }



    @Override
    public void handle(ActionEvent event) {

    }
    public void sceneChoice(ChoiceBox<String> choiceBox,Stage window,Scene scena,Scene scena2){

           if(choiceBox.getValue().equals("Klienta")) {
               changeScene(window, scena);
           }
        /*   if(choiceBox.getValue().equals("Pracownika")){
               changeScene(window, scena2);
           }*/

    }





    public void changeScene(Stage window,Scene scena){
        window.setScene(scena);
    }
    public void close(){
       /* if (window.close()){

        }*/

    }
    public void getChoice(ChoiceBox<String> choiceBox){
        String answer = choiceBox.getValue();
        System.out.println(answer);
    }

    public static void main(String[] args) throws SQLException {
        connect = new Connect();
        connect.getDBConnection();
        launch();
        connect.disconnect();


    }

}