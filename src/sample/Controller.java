package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Controller {

    // create new list of invoices
    private List<InvoiceData> invoicesData;

    @FXML
    private ListView<InvoiceData> invoicesView;

    @FXML
    private TextArea invoiceDetailsTextArea;


    // init sample data of customers
    public void init(){
        InvoiceData cs1 = new InvoiceData("John Smith", "123 Main St", "317-555-555", "3 rooms carpet cleaing", 100, LocalDate.of(2016, Month.AUGUST, 8));
    }
}
