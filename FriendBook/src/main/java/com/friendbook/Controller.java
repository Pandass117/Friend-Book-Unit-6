package com.friendbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    @FXML
    public ListView<Friend> lstFriend = new ListView<>();
    public Label name;
    public Label phoneNum;
    public Label address;
    public Label birthday;
    public Button btnAddFriend;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtPhoneNumber;
    public TextField txtAddress;
    public TextField txtBirthday;
    private ArrayList<TextField> info = new ArrayList<>(); //ArrayList for friend info
    public Button btnDeleteFriend;


    @FXML


    //Requires: mouse to click a friend in list
    //Modifies: this
    //Effects: shows fields of friend, enables delete button
    public void displayFriend(MouseEvent mouseEvent) {
        Friend temp;
        temp = lstFriend.getSelectionModel().getSelectedItem();
        name.setText(temp.getFirstName()+" "+temp.getLastName());
        phoneNum.setText(temp.getPhoneNumber());
        address.setText(temp.getAddress());
        birthday.setText(temp.getBirthday());
        btnDeleteFriend.setDisable(false);

    }


    //Requires:
    //Modifies: this
    //Effects: adds all of the friend info into the ArrayList, disables delete and add buttons and friend list
    public void initialize(){
        btnAddFriend.setDisable(true);
        btnDeleteFriend.setDisable(true);
        lstFriend.setDisable(true);
        Collections.addAll(info, txtFirstName, txtLastName, txtPhoneNumber, txtAddress, txtBirthday);
    }

    //Requires: delete button to be clicked
    //Modifies: this
    //Effects: removes friend from list, resets display, disables list if no friends
    public void deleteFriend(ActionEvent actionEvent) {
        Friend temp;
        temp = lstFriend.getSelectionModel().getSelectedItem();
        lstFriend.getItems().remove(temp);
        name.setText("");
        phoneNum.setText("");
        address.setText("");
        birthday.setText("");

        btnDeleteFriend.setDisable(true);
        if(lstFriend.getItems().isEmpty()){
            lstFriend.setDisable(true);
        }

    }

    //Requires: add button to be pressed
    //Modifies: this
    //Effects: adds friend to list, disables add button, clears TextFields, enables friend list, if it hasn't already been
    public void addFriend(ActionEvent actionEvent) {
        Friend temp = new Friend(txtFirstName.getText(), txtLastName.getText(), txtBirthday.getText(), txtPhoneNumber.getText(), txtAddress.getText());
        lstFriend.getItems().add(temp);

        //disable add button and clear
        btnAddFriend.setDisable(true);
        for(TextField information : info){
            information.clear();
        }




        if(!lstFriend.getItems().isEmpty()){
            lstFriend.setDisable(false);
        }
    }

    //Requires: any key to be typed in any TextField
    //Modifies: this
    //Effects: enables add button if all TextFields have text, otherwise disables
    public void keyType(KeyEvent keyEvent) {
        boolean filled = true;
        for(TextField information : info){
            if (information.getText().isEmpty()){
                filled = false;

            }
        }
        //if filled, enable, else disable
        btnAddFriend.setDisable(!filled);


    }
}