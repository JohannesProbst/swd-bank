package at.ac.fhsalzburg.swd.repositories;

import at.ac.fhsalzburg.swd.entities.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Joey on 25.01.2015.
 */
public interface BankRepository extends JpaRepository<BankEntity,Integer> {
}
