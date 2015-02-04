package at.ac.fhsalzburg.swd.entities;

import javax.persistence.*;

/**
 * Created by Joey on 24.01.2015.
 */
@Entity
@Table(name = "checking_account", schema = "", catalog = "bank")
public class CheckingAccountEntity extends AccountEntity {
    private int accountId;
    private Integer cusAccountId;

    /*@Id
    @Column(name = "ACCOUNT_ID", nullable = false, insertable = true, updatable = true)
    public int getAccountId() {
        return accountId;
    }*/

   /* public void setAccountId(int accountId) {
        this.accountId = accountId;
    }*/

    @Basic
    @Column(name = "CUS_ACCOUNT_ID", nullable = true, insertable = true, updatable = true)
    public Integer getCusAccountId() {
        return cusAccountId;
    }

    public void setCusAccountId(Integer cusAccountId) {
        this.cusAccountId = cusAccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckingAccountEntity that = (CheckingAccountEntity) o;

        if (accountId != that.accountId) return false;
        if (cusAccountId != null ? !cusAccountId.equals(that.cusAccountId) : that.cusAccountId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + (cusAccountId != null ? cusAccountId.hashCode() : 0);
        return result;
    }
}
