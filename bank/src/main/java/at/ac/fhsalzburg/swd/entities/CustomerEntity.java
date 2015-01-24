package at.ac.fhsalzburg.swd.entities;

import javax.persistence.*;

/**
 * Created by Joey on 24.01.2015.
 */
@Entity
@Table(name = "customer", schema = "", catalog = "bank")
public class CustomerEntity {
    private String customerAddress;
    private String customerName;
    private int customerId;
    private int bankId;
    private String pin;

    @Basic
    @Column(name = "CUSTOMER_ADDRESS")
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Basic
    @Column(name = "CUSTOMER_NAME")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Id
    @Column(name = "CUSTOMER_ID")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "BANK_ID")
    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    @Basic
    @Column(name = "PIN")
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (bankId != that.bankId) return false;
        if (customerId != that.customerId) return false;
        if (customerAddress != null ? !customerAddress.equals(that.customerAddress) : that.customerAddress != null)
            return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (pin != null ? !pin.equals(that.pin) : that.pin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerAddress != null ? customerAddress.hashCode() : 0;
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + customerId;
        result = 31 * result + bankId;
        result = 31 * result + (pin != null ? pin.hashCode() : 0);
        return result;
    }
}
