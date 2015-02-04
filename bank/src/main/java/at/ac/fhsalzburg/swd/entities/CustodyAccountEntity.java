package at.ac.fhsalzburg.swd.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by WuM on 03.02.2015.
 */
@Entity
@Table(name = "custody_account", schema = "", catalog = "bank")
public class CustodyAccountEntity {
    private int accountId;
    private int customerId;
    private int cheAccountId;
    private String accountDescription;
    private String accountIban;
    private BigDecimal accountSaldo;
    private BigDecimal accountStatement;
    private Timestamp accountStatementDate;

    @Id
    @Column(name = "ACCOUNT_ID")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "CUSTOMER_ID")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "CHE_ACCOUNT_ID")
    public int getCheAccountId() {
        return cheAccountId;
    }

    public void setCheAccountId(int cheAccountId) {
        this.cheAccountId = cheAccountId;
    }

    @Basic
    @Column(name = "ACCOUNT_DESCRIPTION")
    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    @Basic
    @Column(name = "ACCOUNT_IBAN")
    public String getAccountIban() {
        return accountIban;
    }

    public void setAccountIban(String accountIban) {
        this.accountIban = accountIban;
    }

    @Basic
    @Column(name = "ACCOUNT_SALDO")
    public BigDecimal getAccountSaldo() {
        return accountSaldo;
    }

    public void setAccountSaldo(BigDecimal accountSaldo) {
        this.accountSaldo = accountSaldo;
    }

    @Basic
    @Column(name = "ACCOUNT_STATEMENT")
    public BigDecimal getAccountStatement() {
        return accountStatement;
    }

    public void setAccountStatement(BigDecimal accountStatement) {
        this.accountStatement = accountStatement;
    }

    @Basic
    @Column(name = "ACCOUNT_STATEMENT_DATE")
    public Timestamp getAccountStatementDate() {
        return accountStatementDate;
    }

    public void setAccountStatementDate(Timestamp accountStatementDate) {
        this.accountStatementDate = accountStatementDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustodyAccountEntity that = (CustodyAccountEntity) o;

        if (accountId != that.accountId) return false;
        if (cheAccountId != that.cheAccountId) return false;
        if (customerId != that.customerId) return false;
        if (accountDescription != null ? !accountDescription.equals(that.accountDescription) : that.accountDescription != null)
            return false;
        if (accountIban != null ? !accountIban.equals(that.accountIban) : that.accountIban != null) return false;
        if (accountSaldo != null ? !accountSaldo.equals(that.accountSaldo) : that.accountSaldo != null) return false;
        if (accountStatement != null ? !accountStatement.equals(that.accountStatement) : that.accountStatement != null)
            return false;
        if (accountStatementDate != null ? !accountStatementDate.equals(that.accountStatementDate) : that.accountStatementDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + customerId;
        result = 31 * result + cheAccountId;
        result = 31 * result + (accountDescription != null ? accountDescription.hashCode() : 0);
        result = 31 * result + (accountIban != null ? accountIban.hashCode() : 0);
        result = 31 * result + (accountSaldo != null ? accountSaldo.hashCode() : 0);
        result = 31 * result + (accountStatement != null ? accountStatement.hashCode() : 0);
        result = 31 * result + (accountStatementDate != null ? accountStatementDate.hashCode() : 0);
        return result;
    }
}
