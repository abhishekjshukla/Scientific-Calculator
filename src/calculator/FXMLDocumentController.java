/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.lang.Math;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author AbhishekS
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField ans;
    private int decimalClick = 0;
    private String generalOperationObject;
    private double firstDouble;
   
    @FXML
    private void handleDigitAction(ActionEvent event) 
    {
        String digitObject = ((Button) event.getSource()).getText();
        String oldText = ans.getText();
        System.out.println("digit "+oldText);
        String newText = oldText+digitObject;
         System.out.println("n"+newText);
        ans.setText(newText);
    }
       @FXML
    private void handleDelAction(ActionEvent event) 
    {
        String digitObject = ((Button) event.getSource()).getText();
         String oldtext=ans.getText();
         String newstring=oldtext.substring(0,oldtext.length()-1);
         if(newstring==".")
             decimalClick =0;
         ans.setText(newstring);
    }
    @FXML
    private void handleGeneralAction(ActionEvent event) {
        generalOperationObject = ((Button) event.getSource()).getText();
        switch (generalOperationObject) {
            case "CE":
                ans.setText("");
                decimalClick = 0;
                break;
             case "C":
                ans.setText("");
                decimalClick = 0;
                break;
                
            case "+":
            case "-":
            case "*":
            case "/":
            case "mod":
            case "xpowy":
                String currentText = ans.getText();
                firstDouble = Double.parseDouble(currentText);
                ans.setText("");
                decimalClick = 0;
                break;
            default:
        }
    }
    @FXML
    private void handlerDecimalAction(ActionEvent event) {
        if (decimalClick == 0) 
        {
            String decimalObject = ((Button) event.getSource()).getText();
            String oldText = ans.getText();
            if(ans.getText().trim().equals(""))
            {
                System.out.println("sdsds");
                ans.setText("0.");
            }
            else
                ans.setText(oldText+".");
            System.out.println(oldText);
            String newText = oldText + decimalObject;
            System.out.println(newText);
            //ans.setText(newText);
            decimalClick = 1;
        }
    }
    @FXML
    private void handlerEqualAction(ActionEvent event)
    {
        double secondDouble;
        double result=0;
        String secondText = ans.getText();
        secondDouble = Double.parseDouble(secondText);

        switch (generalOperationObject) 
        {
            case "+":
                result = firstDouble + secondDouble;
                break;
            case "-":
                result = firstDouble - secondDouble;
                break;
            case "*":
                result = firstDouble * secondDouble;
                break;
            case "/":
                result = firstDouble / secondDouble;
                break;
            case "mod":
                result = firstDouble % secondDouble;
                break;
            case "xpowy":
                 result=Math.pow(firstDouble,secondDouble);
                 break;
            default:
        }
        String format = String.format("%.1f", result);
        ans.setText(format);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
