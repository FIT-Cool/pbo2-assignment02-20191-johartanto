package com.John;
/**
 * author: Johnson Hartanto
 * NRP: 1772017
 */

import com.John.Entity.Category;
import com.John.Entity.Item;
import com.sun.istack.internal.localization.NullLocalizable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button saveBtn;
    public Button updateBtn;
    @FXML
    private TextField txtCatname;
    @FXML
    private TableView<Item> tabelList;
    @FXML
    private TableColumn<Item,String> col01;
    @FXML
    private TableColumn<Item,String> col02;
    @FXML
    private TableColumn<Item,String> col03;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;
    @FXML
    private ComboBox<Category> cbCat;
    private ObservableList<Item> items;
    private ObservableList<Category> categories;
    Alert alert=new Alert(Alert.AlertType.ERROR);
    @FXML
    private void pressTable(MouseEvent mouseEvent) {
        Item i=tabelList.getSelectionModel().getSelectedItem();
        txtName.setText(i.getName());
        txtPrice.setText(String.valueOf(i.getPrice()));
        cbCat.setValue(i.getCategory());
        updateBtn.setDisable(false);
        saveBtn.setDisable(true);
    }

    @FXML
    private void btnSaveCat(ActionEvent actionEvent) {
        Category c=new Category();
        c.setName(txtCatname.getText().trim());
        if (c.getName().equals("")){
            alert.setContentText("Please fill category name");
            alert.show();
        }
        else{
            boolean found=false;
            for (Category cat:categories){
                if (cat.getName().equals(c.getName())){
                    found=true;
                    alert.setContentText("Duplicate Category Name");
                    alert.show();
                    break;
                }
            }
            if (!found){
                categories.add(c);
            }
        }
    }

    @FXML
    private void btnUpdate(ActionEvent actionEvent) {
        Item i=tabelList.getSelectionModel().getSelectedItem();
        i.setName(txtName.getText());
        i.setPrice(Double.valueOf(txtPrice.getText()));
        i.setCategory(cbCat.getValue());
        tabelList.refresh();
        saveBtn.setDisable(false);
        updateBtn.setDisable(true);
    }

    @FXML
    private void btnReset(ActionEvent actionEvent) {
        txtName.setText("");
        txtPrice.setText("");
        txtCatname.setText("");
        cbCat.setValue(null);
        saveBtn.setDisable(false);
        updateBtn.setDisable(true);
    }

    @FXML
    private void btnSave(ActionEvent actionEvent) {
        Item i=new Item();
        boolean ketemu=false;
        if (txtName.getText().isEmpty() || txtPrice.getText().isEmpty() || cbCat.getValue()==null){
            alert.setContentText("Please fill name/price/category");
            alert.show();
        }
        else{
            i.setName(txtName.getText());
            for (Item item:items){
                if (i.getName().equals(item.getName())){
                    ketemu=true;
                    alert.setContentText("Duplicate item found");
                    alert.show();
                    break;
                }
            }
            if (!ketemu){
                i.setPrice(Double.valueOf(txtPrice.getText()));
                i.setCategory(cbCat.getValue());
                items.add(i);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateBtn.setDisable(true);
        items= FXCollections.observableArrayList();
        categories=FXCollections.observableArrayList();
        cbCat.setItems(categories);
        tabelList.setItems(items);
        col01.setCellValueFactory(data->{
            Item i=data.getValue();
            return new SimpleStringProperty(i.getName());
        });
        col02.setCellValueFactory(data->{
            Item i=data.getValue();
            return new SimpleStringProperty(String.valueOf(i.getPrice()));
        });
        col03.setCellValueFactory(data->{
            Item i=data.getValue();
            return new SimpleObjectProperty<>(i.getCategory().getName());
        });
    }
}
