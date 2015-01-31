package at.ac.fhsalzburg.swd.entities;

import javax.persistence.*;

/**
 * Created by Joey on 24.01.2015.
 */
@Entity
@Table(name = "custody_account", schema = "", catalog = "bank")
public class CustodyAccountEntity {
    private int accountId;
    private int cheAccountId;

    @Id
    @Column(name = "ACCOUNT_ID", nullable = false, insertable = true, updatable = true)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "CHE_ACCOUNT_ID", nullable = false, insertable = true, updatable = true)
    public int getCheAccountId() {
        return cheAccountId;
    }

    public void setCheAccountId(int cheAccountId) {
        this.cheAccountId = cheAccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustodyAccountEntity that = (CustodyAccountEntity) o;

        if (accountId != that.accountId) return false;
        if (cheAccountId != that.cheAccountId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + cheAccountId;
        return result;
    }
}
