/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmariShop.Login;

import AmariShop.Database.ConnectDB;
import AmariShop.Database.UserAccount;
import AmariShop.FXMain;
import AmariShop.Models.User;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginLayoutController implements Initializable {

    private Connection connection;
    
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    

    public void loginBtnClick(ActionEvent event) {
        FXMain fxmain=new FXMain();
        connection=ConnectDB.getConnection();
        UserAccount userAccount=new UserAccount(connection);
//        String email="f1@gmail.com";String pass="123456";

        String email=emailField.getText();String pass=passField.getText();
        User user=userAccount.getUserProfile(email,pass);
        if(user!=null){
            fxmain.openDashboard(event,user,connection);
        }
        else{
            FXMain.showNotification("Verification Failed", "Can't verify the user.", "warning");
        }
    }
    
    
}
