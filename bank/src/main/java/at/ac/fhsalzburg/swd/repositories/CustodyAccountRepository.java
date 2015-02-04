package at.ac.fhsalzburg.swd.repositories;

import at.ac.fhsalzburg.swd.entities.CustodyAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by WuM on 01.02.2015.
 */
public interface CustodyAccountRepository extends JpaRepository<CustodyAccountEntity, Integer> {
}
