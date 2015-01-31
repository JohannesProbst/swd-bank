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
    @Column(name = "CUSTOMER_ADDRESS", nullable = false, insertable = true, updatable = true, length = 128)
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Basic
    @Column(name = "CUSTOMER_NAME", nullable = false, insertable = true, updatable = true, length = 128)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Id
    @Column(name = "CUSTOMER_ID", nullable = false, insertable = true, updatable = true)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "BANK_ID", nullable = false, insertable = true, updatable = true)
    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    @Basic
    @Column(name = "PIN", nullable = false, insertable = true, updatable = true, length = 128)
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

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        String nl = System.getProperty("line.separator");

        result.append(this.getClass().getName() + " Object {" + nl);
        result.append("  customerName: " + customerName + nl);
        result.append("  customerId: " + customerId + nl);
        result.append("  pin: " + pin + nl);
        result.append("  customerAddress: " + customerAddress + nl);
        result.append("  bankId: " + bankId + nl);
        result.append("}" + nl);

        return result.toString();
    }
}
