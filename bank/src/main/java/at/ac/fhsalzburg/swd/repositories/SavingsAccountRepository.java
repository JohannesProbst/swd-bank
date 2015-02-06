package at.ac.fhsalzburg.swd.repositories;

import at.ac.fhsalzburg.swd.entities.CheckingAccountEntity;
import at.ac.fhsalzburg.swd.entities.SavingsAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Philipp on 05.02.2015.
 */
public interface SavingsAccountRepository extends JpaRepository<SavingsAccountEntity,Integer> {
    public List<CheckingAccountEntity> findAllByCustomerId(int id);
}
