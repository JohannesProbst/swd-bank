package at.ac.fhsalzburg.swd.repositories;

import at.ac.fhsalzburg.swd.entities.CheckingAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Joey on 28.01.2015.
 */
public interface CheckingAccountRepository extends JpaRepository<CheckingAccountEntity, Integer> {
}
