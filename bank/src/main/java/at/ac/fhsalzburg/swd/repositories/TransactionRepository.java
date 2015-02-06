package at.ac.fhsalzburg.swd.repositories;

import at.ac.fhsalzburg.swd.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Philipp on 05.02.2015.
 */
public interface TransactionRepository extends JpaRepository<TransactionEntity,Integer> {

}
