package com.John;

import com.John.Entity.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField txtCatname;
    @FXML
    private TableView<Item> tabelList;
    @FXML
    private TableColumn<Item,String> col01;
    @FXML
    private TableColumn<Item,Double> col02;
    @FXML
    private TableColumn<Item,String> col03;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;
    @FXML
    private ComboBox cbCat;
    private ObservableList<Item> items;
    @FXML
    private void pressTable(MouseEvent mouseEvent) {

    }

    @FXML
    private void btnSaveCat(ActionEvent actionEvent) {
    }

    @FXML
    private void btnUpdate(ActionEvent actionEvent) {
    }

    @FXML
    private void btnReset(ActionEvent actionEvent) {
    }

    @FXML
    private void btnSave(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        items= FXCollections.observableArrayList();
        tabelList.setItems(items);
        col01.setCellValueFactory(data->{
            Item i=data.getValue();
            return new SimpleStringProperty(i.getName());
        });
    }
}
