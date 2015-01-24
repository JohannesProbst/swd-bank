package at.ac.fhsalzburg.swd.entities;

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

    @Basic
    @Column(name = "TRANSACTION_AMOUNT")
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Basic
    @Column(name = "VALUTA_DATE")
    public Date getValutaDate() {
        return valutaDate;
    }

    public void setValutaDate(Date valutaDate) {
        this.valutaDate = valutaDate;
    }

    @Basic
    @Column(name = "TRANSACTION_TYPE")
    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    @Basic
    @Column(name = "TIMESTAMP")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Id
    @Column(name = "TRANSACTIONS_ID")
    public int getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(int transactionsId) {
        this.transactionsId = transactionsId;
    }

    @Basic
    @Column(name = "ACCOUNT_ID")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "CON_TRANSACTIONS_ID")
    public Integer getConTransactionsId() {
        return conTransactionsId;
    }

    public void setConTransactionsId(Integer conTransactionsId) {
        this.conTransactionsId = conTransactionsId;
    }

    @Basic
    @Column(name = "CUS_TRANSACTIONS_ID")
    public Integer getCusTransactionsId() {
        return cusTransactionsId;
    }

    public void setCusTransactionsId(Integer cusTransactionsId) {
        this.cusTransactionsId = cusTransactionsId;
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
