package at.ac.fhsalzburg.swd.repositories;

import at.ac.fhsalzburg.swd.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Joey on 26.01.2015.
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    CustomerEntity findByCustomerIdAndPin(Integer customerId, String pin);
}
