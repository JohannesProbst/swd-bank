package at.ac.fhsalzburg.swd.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Joey on 24.01.2015.
 */
@Entity
@Table(name = "custody_transaction", schema = "", catalog = "bank")
public class CustodyTransactionEntity {
    private int transactionsId;
    private int stockQuantity;
    private BigDecimal stockExchangeRate;
    private String stockName;

    @Id
    @Column(name = "TRANSACTIONS_ID")
    public int getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(int transactionsId) {
        this.transactionsId = transactionsId;
    }

    @Basic
    @Column(name = "STOCK_QUANTITY")
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Basic
    @Column(name = "STOCK_EXCHANGE_RATE")
    public BigDecimal getStockExchangeRate() {
        return stockExchangeRate;
    }

    public void setStockExchangeRate(BigDecimal stockExchangeRate) {
        this.stockExchangeRate = stockExchangeRate;
    }

    @Basic
    @Column(name = "STOCK_NAME")
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustodyTransactionEntity that = (CustodyTransactionEntity) o;

        if (stockQuantity != that.stockQuantity) return false;
        if (transactionsId != that.transactionsId) return false;
        if (stockExchangeRate != null ? !stockExchangeRate.equals(that.stockExchangeRate) : that.stockExchangeRate != null)
            return false;
        if (stockName != null ? !stockName.equals(that.stockName) : that.stockName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionsId;
        result = 31 * result + stockQuantity;
        result = 31 * result + (stockExchangeRate != null ? stockExchangeRate.hashCode() : 0);
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        return result;
    }
}
