package sample;

import java.time.LocalDate;

/**
 * Created by Boazraz
 */
public class InvoiceData {

    // define the fields for the costumer info will hold

    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String jobDescroption;
    private String customerBalance;
    private LocalDate dueDate;


    public InvoiceData(String customerName, String customerAddress, String customerPhone, String jobDescroption, String customerBalance, LocalDate dueDate) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.jobDescroption = jobDescroption;
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

    public String getJobDescroption() {
        return jobDescroption;
    }

    public void setJobDescroption(String jobDescroption) {
        this.jobDescroption = jobDescroption;
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
