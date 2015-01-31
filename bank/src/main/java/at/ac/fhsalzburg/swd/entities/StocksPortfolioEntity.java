package at.ac.fhsalzburg.swd.entities;

import javax.persistence.*;

/**
 * Created by Joey on 24.01.2015.
 */
@Entity
@Table(name = "stocks_portfolio", schema = "", catalog = "bank")
@IdClass(StocksPortfolioEntityPK.class)
public class StocksPortfolioEntity {
    private int accountId;
    private int stockId;
    private int stockAmount;
    private String stockname;

    @Id
    @Column(name = "ACCOUNT_ID", nullable = false, insertable = true, updatable = true)
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Id
    @Column(name = "STOCK_ID", nullable = false, insertable = true, updatable = true)
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Basic
    @Column(name = "STOCK_AMOUNT", nullable = false, insertable = true, updatable = true)
    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    @Basic
    @Column(name = "STOCKNAME", nullable = false, insertable = true, updatable = true, length = 128)
    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StocksPortfolioEntity that = (StocksPortfolioEntity) o;

        if (accountId != that.accountId) return false;
        if (stockAmount != that.stockAmount) return false;
        if (stockId != that.stockId) return false;
        if (stockname != null ? !stockname.equals(that.stockname) : that.stockname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + stockId;
        result = 31 * result + stockAmount;
        result = 31 * result + (stockname != null ? stockname.hashCode() : 0);
        return result;
    }
}
