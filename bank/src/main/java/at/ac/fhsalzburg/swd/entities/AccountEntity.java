package at.ac.fhsalzburg.swd.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Joey on 24.01.2015.
 */
@Entity
@Table(name = "account", schema = "", catalog = "bank")
public class AccountEntity {
    private String accountDescription;
    private int accountId;
    private int customerId;
    private String accountIban;
    private BigDecimal accountSaldo;
    private BigDecimal accountStatement;
    private Timestamp accountStatementDate;

    @Basic
    @Column(name = "ACCOUNT_DESCRIPTION", nullable = false, insertable = true, updatable = true, length = 128)
    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    @Id
    @Column(name = "ACCOUNT_ID", nullable = false, insertable = true, updatable = true)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "CUSTOMER_ID", nullable = false, insertable = true, updatable = true)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "ACCOUNT_IBAN", nullable = false, insertable = true, updatable = true, length = 34)
    public String getAccountIban() {
        return accountIban;
    }

    public void setAccountIban(String accountIban) {
        this.accountIban = accountIban;
    }

    @Basic
    @Column(name = "ACCOUNT_SALDO", nullable = false, insertable = true, updatable = true, precision = 2)
    public BigDecimal getAccountSaldo() {
        return accountSaldo;
    }

    public void setAccountSaldo(BigDecimal accountSaldo) {
        this.accountSaldo = accountSaldo;
    }

    @Basic
    @Column(name = "ACCOUNT_STATEMENT", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getAccountStatement() {
        return accountStatement;
    }

    public void setAccountStatement(BigDecimal accountStatement) {
        this.accountStatement = accountStatement;
    }

    @Basic
    @Column(name = "ACCOUNT_STATEMENT_DATE", nullable = false, insertable = true, updatable = true)
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

        AccountEntity that = (AccountEntity) o;

        if (accountId != that.accountId) return false;
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
        int result = accountDescription != null ? accountDescription.hashCode() : 0;
        result = 31 * result + accountId;
        result = 31 * result + customerId;
        result = 31 * result + (accountIban != null ? accountIban.hashCode() : 0);
        result = 31 * result + (accountSaldo != null ? accountSaldo.hashCode() : 0);
        result = 31 * result + (accountStatement != null ? accountStatement.hashCode() : 0);
        result = 31 * result + (accountStatementDate != null ? accountStatementDate.hashCode() : 0);
        return result;
    }
}
