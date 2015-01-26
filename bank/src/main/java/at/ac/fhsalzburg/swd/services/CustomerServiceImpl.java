package at.ac.fhsalzburg.swd.services;

import at.ac.fhsalzburg.swd.entities.CustomerEntity;
import at.ac.fhsalzburg.swd.exceptions.CustomerNotFound;
import at.ac.fhsalzburg.swd.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Joey on 26.01.2015.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public CustomerEntity create(CustomerEntity customer) {
        CustomerEntity createdCustomer = customer;
        return customerRepository.save(createdCustomer);
    }

    @Override
    @Transactional
    public CustomerEntity delete(int id) throws CustomerNotFound {
        CustomerEntity deletedCustomer = customerRepository.findOne(id);
        if (deletedCustomer == null)
            throw new CustomerNotFound();
        customerRepository.delete(deletedCustomer);
        return deletedCustomer;
    }

    @Override
    @Transactional
    public List<CustomerEntity> findAll() {

        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public CustomerEntity update(CustomerEntity customer) throws CustomerNotFound {
        CustomerEntity updatedCustomer = customerRepository.findOne(customer.getCustomerId());
        if (updatedCustomer == null)
            throw new CustomerNotFound();
        updatedCustomer.setCustomerName(customer.getCustomerName());
        updatedCustomer.setCustomerAddress(customer.getCustomerAddress());
        updatedCustomer.setBankId(customer.getBankId());
        updatedCustomer.setPin(customer.getPin());
        return updatedCustomer;
    }

    @Override
    @Transactional
    public CustomerEntity findById(int id) {
        return customerRepository.findOne(id);
    }
}
