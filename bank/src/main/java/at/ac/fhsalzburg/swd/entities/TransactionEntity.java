package at.ac.fhsalzburg.swd.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Joey on 24.01.2015.
 */
@Entity
@Table(name = "transaction", schema = "", catalog = "bank")
public class TransactionEntity {
    private BigDecimal transactionAmount;
    private Date valutaDate;
    private int transactionType;
    private Timestamp timestamp;
    private int transactionsId;
    private int accountId;
    private Integer conTransactionsId;
    private Integer cusTransactionsId;


    private CustomerEntity customer;
    private AccountEntity account;
    private AccountEntity targetAccount;

    public enum TransactionType {
        DEPOSIT(0), WITHDRAW(1), TRANSFER(2), BUY(3), SELL(4);
        private final Integer id;
        private TransactionType(Integer id) {
            this.id = id;
        }
        public Integer toInteger() {
            return id;
        }
    }

    private Boolean valid = false;

    @Basic
    @Column(name = "TRANSACTION_AMOUNT", nullable = false, insertable = true, updatable = true, precision = 2)
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Basic
    @Column(name = "VALUTA_DATE", nullable = false, insertable = true, updatable = true)
    public Date getValutaDate() {
        return valutaDate;
    }

    public void setValutaDate(Date valutaDate) {
        this.valutaDate = valutaDate;
    }

    @Basic
    @Column(name = "TRANSACTION_TYPE", nullable = false, insertable = true, updatable = true)
    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType.toInteger();
    }

    @Basic
    @Column(name = "TIMESTAMP", nullable = false, insertable = true, updatable = true)
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Id
    @Column(name = "TRANSACTIONS_ID", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(int transactionsId) {
        this.transactionsId = transactionsId;
    }

    @Basic
    @Column(name = "ACCOUNT_ID", nullable = false, insertable = true, updatable = true)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "CON_TRANSACTIONS_ID", nullable = true, insertable = true, updatable = true)
    public Integer getConTransactionsId() {
        return conTransactionsId;
    }

    public void setConTransactionsId(Integer conTransactionsId) {
        this.conTransactionsId = conTransactionsId;
    }

    @Basic
    @Column(name = "CUS_TRANSACTIONS_ID", nullable = true, insertable = true, updatable = true)
    public Integer getCusTransactionsId() {
        return cusTransactionsId;
    }

    public void setCusTransactionsId(Integer cusTransactionsId) {
        this.cusTransactionsId = cusTransactionsId;
    }

    @Transient
    public Boolean isValid() {
        return valid;
    }
    @Transient
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    @Transient
    public AccountEntity getTargetAccount() {
        return targetAccount;
    }
    @Transient
    public void setTargetAccount(AccountEntity targetAccount) {
        this.targetAccount = targetAccount;
    }
    @Transient
    public AccountEntity getAccount() {
        return account;
    }
    @Transient
    public void setAccount(AccountEntity account) {
        this.account = account;
    }
    @Transient
    public CustomerEntity getCustomer() {
        return customer;
    }
    @Transient
    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (accountId != that.accountId) return false;
        if (transactionType != that.transactionType) return false;
        if (transactionsId != that.transactionsId) return false;
        if (conTransactionsId != null ? !conTransactionsId.equals(that.conTransactionsId) : that.conTransactionsId != null)
            return false;
        if (cusTransactionsId != null ? !cusTransactionsId.equals(that.cusTransactionsId) : that.cusTransactionsId != null)
            return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (transactionAmount != null ? !transactionAmount.equals(that.transactionAmount) : that.transactionAmount != null)
            return false;
        if (valutaDate != null ? !valutaDate.equals(that.valutaDate) : that.valutaDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionAmount != null ? transactionAmount.hashCode() : 0;
        result = 31 * result + (valutaDate != null ? valutaDate.hashCode() : 0);
        result = 31 * result + transactionType;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + transactionsId;
        result = 31 * result + accountId;
        result = 31 * result + (conTransactionsId != null ? conTransactionsId.hashCode() : 0);
        result = 31 * result + (cusTransactionsId != null ? cusTransactionsId.hashCode() : 0);
        return result;
    }
}
