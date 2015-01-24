package at.ac.fhsalzburg.swd.entities;

import javax.persistence.*;

/**
 * Created by Joey on 24.01.2015.
 */
@Entity
@Table(name = "bank", schema = "", catalog = "bank")
public class BankEntity {
    private String bankBic;
    private String bankAddress;
    private int bankId;
    private String bankName;

    @Basic
    @Column(name = "BANK_BIC")
    public String getBankBic() {
        return bankBic;
    }

    public void setBankBic(String bankBic) {
        this.bankBic = bankBic;
    }

    @Basic
    @Column(name = "BANK_ADDRESS")
    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    @Id
    @Column(name = "BANK_ID")
    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    @Basic
    @Column(name = "BANK_NAME")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankEntity that = (BankEntity) o;

        if (bankId != that.bankId) return false;
        if (bankAddress != null ? !bankAddress.equals(that.bankAddress) : that.bankAddress != null) return false;
        if (bankBic != null ? !bankBic.equals(that.bankBic) : that.bankBic != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bankBic != null ? bankBic.hashCode() : 0;
        result = 31 * result + (bankAddress != null ? bankAddress.hashCode() : 0);
        result = 31 * result + bankId;
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        return result;
    }
}
