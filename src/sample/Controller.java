package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    // create new list of invoices
    private List<InvoiceData> invoicesData;

    @FXML
    private ListView<InvoiceData> invoicesView;

    @FXML
    private TextArea invoiceDetailsTextArea;


    // init sample data of customers
    public void initialize(){
        InvoiceData cs1 = new InvoiceData("John Smith", "123 Main St", "317-555-555", "3 rooms carpet cleaing", 100, LocalDate.of(2016, Month.AUGUST, 8));

        invoicesData = new ArrayList<InvoiceData>();
        invoicesData.add(cs1);


        invoicesView.getItems().setAll(invoicesData);

        invoicesView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handleClickListView() {
        InvoiceData item = invoicesView.getSelectionModel().getSelectedItem();
//        System.out.println("The selected item is " + item);
        StringBuilder sb = new StringBuilder(item.getCustomerName());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDueDate().toString());
        invoiceDetailsTextArea.setText(sb.toString());


    }
} // end Controller class
