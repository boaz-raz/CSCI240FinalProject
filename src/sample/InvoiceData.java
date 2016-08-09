package sample;

import java.time.LocalDate;

/**
 * Created by Boaz Raz
 */
public class InvoiceData {

    // define the fields for the costumer info will hold

    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String jobDescription;
    private String customerBalance;
    private LocalDate dueDate;


    public InvoiceData(String customerName, String customerAddress, String customerPhone, String jobDescription, String customerBalance, LocalDate dueDate) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.jobDescription = jobDescription;
        this.customerBalance = customerBalance;
        this.dueDate = dueDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(String customerBalance) {
        this.customerBalance = customerBalance;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return customerName;
    }
}
