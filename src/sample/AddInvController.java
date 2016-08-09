package sample;


import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

/**
 * Created by Boaz Raz
 */

public class AddInvController {

    @FXML
    private TextField customerNameField;

    @FXML
    private TextField customerAddressField;

    @FXML
    private TextField customerPhoneField;

    @FXML
    private TextArea jobDescriptionArea;

    @FXML
    private TextField customerBalanceField;

    @FXML
    private DatePicker dueDatePicker;

    // method to submuit user input info
    public void  submitInvoice () {
        String customerName = customerNameField.getText().trim();
        String customerAddress = customerAddressField.getText().trim();
        String customerPhone = customerPhoneField.getText().trim();
        String jobDescription = jobDescriptionArea.getText().trim();
        String customerBalance = customerBalanceField.getText().trim();
        LocalDate dueDate = dueDatePicker.getValue();

        DataFile.getInstance().addNewInvoice (new InvoiceData(customerName, customerAddress,customerPhone,jobDescription,customerBalance,dueDate));

    }
}
