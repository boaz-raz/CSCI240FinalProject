package sample;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Boaz Raz
 */
public class DataFile {
    private static DataFile instance = new DataFile();
    private static String flieName = "InvoiceLists.txt";

    private List<InvoiceData> invociesData;
    private DateTimeFormatter formatter;

    public static DataFile getInstance() {
        return instance;
    }


    // create private formatter
    private DataFile() {
        formatter = DateTimeFormatter.ofPattern("dd-MM=yyyy");

    }


    // set getter and setters
    public List<InvoiceData> getInvociesData() {
        return invociesData;
    }

    // add method to add the invoice
    public void addNewInvoice(InvoiceData inv){
        invociesData.add(inv);
    }


    public void loadData() throws IOException {
        invociesData = FXCollections.observableArrayList();
        Path path = Paths.get(flieName);

        BufferedReader bufferedReader = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = bufferedReader.readLine()) != null){
                String[] items = input.split("\t");
                String customerName  = items[0];
                String customerAddress = items[1];
                String customerPhone = items[2];
                String jobDescroption = items[3];
                String customerBalance = items[4];
                String dateString = items[5];


                LocalDate date = LocalDate.parse(dateString, formatter);
                InvoiceData invoicesData = new InvoiceData(customerName,customerAddress,customerPhone,jobDescroption,customerBalance,date);
                invociesData.add(invoicesData);
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

    }

    public void storeData() throws IOException {
        Path path = Paths.get(flieName);
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
        try {
            // loop of the list of invoices
            Iterator<InvoiceData> itr = invociesData.iterator();
            while (itr.hasNext()) {
                InvoiceData inv = itr.next();
                bufferedWriter.write(String.format("%s\t%s\t%s\t%s\t%s\t%s",
                        inv.getCustomerName(),inv.getCustomerAddress(),inv.getCustomerPhone(),
                        inv.getJobDescription(),inv.getCustomerBalance(),inv.getDueDate().format(formatter)));
                bufferedWriter.newLine();
            }

        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }

    }



} // end class
