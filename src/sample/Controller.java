package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Controller {

    // create new list of invoices
    private List<InvoiceData> invoicesData;

    @FXML
    private ListView<InvoiceData> invoicesView;

    @FXML
    private TextArea invoiceDetailsTextArea;

    @FXML
    private Label dueDataLable;

    @FXML
    private BorderPane mainPane;

    // init sample data of customers
    public void initialize(){
        invoicesView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<InvoiceData>() {
            @Override
            public void changed(ObservableValue<? extends InvoiceData> observable, InvoiceData oldValue, InvoiceData newValue) {
                if (newValue != null) {
                    InvoiceData inv = invoicesView.getSelectionModel().getSelectedItem();
                    invoiceDetailsTextArea.setText(inv.getJobDescription());
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    dueDataLable.setText(dateFormat.format(inv.getDueDate()));
                }
            }
        });

        // get info from the invoiceLIsts.txt file
        invoicesView.getItems().setAll(DataFile.getInstance().getInvociesData());

        // populate List data
        invoicesView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        invoicesView.getSelectionModel().selectFirst();
    }
    @FXML
    public void addNewInvoice(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addInvoice.fxml"));
        try {
            Parent main = FXMLLoader.load(getClass().getResource("addInvoice.fxml"));
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("error lunching dialog");
            e.printStackTrace();
            return;
        }

        // add buttons to the dialog
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType>  result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){

            // add input from the fileds
            AddInvController controller = fxmlLoader.getController();
            controller.submitInvoice();

            // updating the list menu
            invoicesView.getItems().setAll(DataFile.getInstance().getInvociesData());
            System.out.println("OK Button was pressed");
        } else {
            System.out.println("Cancel");
        }
    }

    // set what info to show on the TextArea
    @FXML
    public void handleClickListView() {
        InvoiceData inv = invoicesView.getSelectionModel().getSelectedItem();
        invoiceDetailsTextArea.setText(inv.getJobDescription());
        dueDataLable.setText(inv.getDueDate().toString() );

    }
} // end Controller class
