import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;



public class GUI extends Application {

    Stage window;
    TableView<FootballClub>table;
    Scene scene1, scene2;
    PremierLeagueManager x = new PremierLeagueManager();


    public static void main (String[] args){
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        table = new TableView<>();

        //Name of club
        TableColumn nameofclub = new TableColumn("Name of club ");
        nameofclub.setMaxWidth(200);
        nameofclub.setCellValueFactory(new PropertyValueFactory<>("Name_of_Club"));

        //Location_of_Club
        TableColumn LocationofClub = new TableColumn("Location_of_Club ");
        LocationofClub.setMaxWidth(200);
        LocationofClub.setCellValueFactory(new PropertyValueFactory<>("Location_of_Club"));

        //sport_clubID
        TableColumn sportclubID = new TableColumn("Club Id ");
        sportclubID.setMaxWidth(200);
        sportclubID.setCellValueFactory(new PropertyValueFactory<>("sport_clubID"));

        //sport_clubID
        TableColumn numwins = new TableColumn("Num of Wins ");
        numwins.setMaxWidth(200);
        numwins.setCellValueFactory(new PropertyValueFactory<>("num_of_wins"));

        //num_of_draws
        TableColumn numdraws = new TableColumn("Num of Draws ");
        numdraws.setMaxWidth(200);
        numdraws.setCellValueFactory(new PropertyValueFactory<>("num_of_draws"));

        table.getColumns().addAll(nameofclub,LocationofClub, sportclubID,numwins,numdraws);

        ObservableList<FootballClub>janith= FXCollections.observableArrayList(x.Premier_league_football_club_list);
        table.setItems(janith);

        Label label1  = new Label("Premier_league_table");
        Button button1 = new Button("Match table");
        button1.setOnAction(event -> window.setScene(scene2));

        //Layout 1
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,button1,table);
        scene1 = new Scene(layout1,800,400);

        //Button2
        Label label2  = new Label("Match table");
        label2.setLayoutX(250);
        label2.setLayoutY(50);
        Button button2 = new Button("Premier league table");
        button2.setOnAction(event -> window.setScene(scene1));

        //Layout
        VBox layout2 = new VBox();
        layout2.getChildren().addAll(button2,label2);
        scene2 = new Scene(layout2,800,400);

        window.setScene(scene1);
        window.setTitle("P");

        window.show();

    }
}
