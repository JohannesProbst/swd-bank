package at.ac.fhsalzburg.swd.entities;

import javax.persistence.*;

/**
 * Created by Joey on 24.01.2015.
 */
@Entity
@Table(name = "contra_account", schema = "", catalog = "bank")
public class ContraAccountEntity {
    private int transactionsId;
    private String contraIban;
    private String contraBic;

    @Id
    @Column(name = "TRANSACTIONS_ID", nullable = false, insertable = true, updatable = true)
    public int getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(int transactionsId) {
        this.transactionsId = transactionsId;
    }

    @Basic
    @Column(name = "CONTRA_IBAN", nullable = false, insertable = true, updatable = true, length = 34)
    public String getContraIban() {
        return contraIban;
    }

    public void setContraIban(String contraIban) {
        this.contraIban = contraIban;
    }

    @Basic
    @Column(name = "CONTRA_BIC", nullable = false, insertable = true, updatable = true, length = 11)
    public String getContraBic() {
        return contraBic;
    }

    public void setContraBic(String contraBic) {
        this.contraBic = contraBic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContraAccountEntity that = (ContraAccountEntity) o;

        if (transactionsId != that.transactionsId) return false;
        if (contraBic != null ? !contraBic.equals(that.contraBic) : that.contraBic != null) return false;
        if (contraIban != null ? !contraIban.equals(that.contraIban) : that.contraIban != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionsId;
        result = 31 * result + (contraIban != null ? contraIban.hashCode() : 0);
        result = 31 * result + (contraBic != null ? contraBic.hashCode() : 0);
        return result;
    }
}
