package at.ac.fhsalzburg.swd.services;

import at.ac.fhsalzburg.swd.entities.CustomerEntity;
import at.ac.fhsalzburg.swd.exceptions.CustomerNotFound;

import java.util.List;

/**
 * Created by Joey on 26.01.2015.
 */
public interface CustomerService {
    public CustomerEntity create(CustomerEntity customer);
    public CustomerEntity delete(int id) throws CustomerNotFound;
    public List<CustomerEntity> findAll();
    public CustomerEntity update(CustomerEntity customer) throws CustomerNotFound;
    public CustomerEntity findById(int id);
}
