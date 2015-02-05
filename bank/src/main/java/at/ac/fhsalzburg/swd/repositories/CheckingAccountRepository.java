package at.ac.fhsalzburg.swd.repositories;

import at.ac.fhsalzburg.swd.entities.AccountEntity;
import at.ac.fhsalzburg.swd.entities.CheckingAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Joey on 28.01.2015.
 */
public interface CheckingAccountRepository extends JpaRepository<CheckingAccountEntity, Integer> {
    public List<CheckingAccountEntity> findAllByCustomerId(int id);
}
