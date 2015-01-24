package at.ac.fhsalzburg.swd.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Joey on 24.01.2015.
 */
public class StocksPortfolioEntityPK implements Serializable {
    private int accountId;
    private int stockId;

    @Column(name = "ACCOUNT_ID")
    @Id
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Column(name = "STOCK_ID")
    @Id
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StocksPortfolioEntityPK that = (StocksPortfolioEntityPK) o;

        if (accountId != that.accountId) return false;
        if (stockId != that.stockId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + stockId;
        return result;
    }
}
