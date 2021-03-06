package at.ac.fhsalzburg.swd.repositories;

import at.ac.fhsalzburg.swd.entities.CheckingAccountEntity;
import at.ac.fhsalzburg.swd.entities.CustodyAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by WuM on 01.02.2015.
 */
public interface CustodyAccountRepository extends JpaRepository<CustodyAccountEntity, Integer> {
    public List<CheckingAccountEntity> findAllByCustomerId(int id);
}
