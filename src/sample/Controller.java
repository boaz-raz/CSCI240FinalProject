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
        //this was for creating the txt file data example
//        InvoiceData cs1 = new InvoiceData("John Smith", "123 Main St", "317-555-555", "3 rooms carpet cleaning", "100", LocalDate.of(2016, Month.AUGUST, 8));
//        InvoiceData cs2 = new InvoiceData("Jewell Sesco", "541 Park St", "317-555-555", "4 rooms and hall carpet cleaning", "200", LocalDate.of(2016, Month.JANUARY, 20));
//        InvoiceData cs3 = new InvoiceData("Roosevelt Carlsen", "123 Main St", "317-555-555", "2 rooms carpet cleaning", "150", LocalDate.of(2016, Month.FEBRUARY, 12));
//        InvoiceData cs4 = new InvoiceData("Alana Trull", "555 Main Ave", "317-555-555", "5 rooms carpet cleaning", "99", LocalDate.of(2016, Month.JULY, 4));
//
//        invoicesData = new ArrayList<InvoiceData>();
//        invoicesData.add(cs1);
//        invoicesData.add(cs2);
//        invoicesData.add(cs3);
//        invoicesData.add(cs4);
//
//        DataFile.getInstance().setInvociesData(invoicesData);

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



        // get info from the invoiceLIsts.txt file
        invoicesView.getItems().setAll(DataFile.getInstance().getInvociesData());

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
