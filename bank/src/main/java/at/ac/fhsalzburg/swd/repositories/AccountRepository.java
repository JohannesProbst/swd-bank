package at.ac.fhsalzburg.swd.repositories;

import at.ac.fhsalzburg.swd.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Joey on 28.01.2015.
 */
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    public List<AccountEntity> findAllByCustomerId(int id);
    public AccountEntity findAllByCustomerIdAndAccountId(int customerId, int accountId);
    public AccountEntity findOneByAccountIban(String iban);
}
