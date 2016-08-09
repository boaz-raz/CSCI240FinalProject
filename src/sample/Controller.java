package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    // create new list of invoices
    private List<InvoiceData> invoicesData;

    @FXML
    private ListView<InvoiceData> invoicesView;

    @FXML
    private TextArea invoiceDetailsTextArea;

    @FXML
    private Label dueDataLable;

    // init sample data of customers
    public void initialize(){
        InvoiceData cs1 = new InvoiceData("John Smith", "123 Main St", "317-555-555", "3 rooms carpet cleaing", "100", LocalDate.of(2016, Month.AUGUST, 8));

        invoicesData = new ArrayList<InvoiceData>();
        invoicesData.add(cs1);

        invoicesView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<InvoiceData>() {
            @Override
            public void changed(ObservableValue<? extends InvoiceData> observable, InvoiceData oldValue, InvoiceData newValue) {
                if (newValue != null) {
                    InvoiceData inv = invoicesView.getSelectionModel().getSelectedItem();
                    invoiceDetailsTextArea.setText(inv.getJobDescroption());

                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    dueDataLable.setText(dateFormat.format(inv.getDueDate()));
                }
            }
        });



        invoicesView.getItems().setAll(invoicesData);

        // populate List data
        invoicesView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        invoicesView.getSelectionModel().selectFirst();
    }

    // set what info to show on the TextArea
    @FXML
    public void handleClickListView() {
        InvoiceData inv = invoicesView.getSelectionModel().getSelectedItem();
        invoiceDetailsTextArea.setText(inv.getJobDescroption());
        dueDataLable.setText(inv.getDueDate().toString() );
//        System.out.println("The selected inv is " + inv);
//        StringBuilder sb = new StringBuilder(inv.getJobDescroption());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(inv.getDueDate().toString());
//        sb.append(", Amount: $");
//        sb.append(inv.getCustomerBalance());

    }
} // end Controller class
