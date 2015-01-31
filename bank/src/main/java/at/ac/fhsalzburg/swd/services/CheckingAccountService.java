package at.ac.fhsalzburg.swd.services;

import at.ac.fhsalzburg.swd.entities.CheckingAccountEntity;
import at.ac.fhsalzburg.swd.exceptions.CheckingAccountNotFound;

import java.util.List;

/**
 * Created by Joey on 28.01.2015.
 */
public interface CheckingAccountService {
    public CheckingAccountEntity create(CheckingAccountEntity checkingAccount);
    public CheckingAccountEntity delete(int id) throws CheckingAccountNotFound;
    public List<CheckingAccountEntity> findAll();
    public CheckingAccountEntity update(CheckingAccountEntity checkingAccount) throws CheckingAccountNotFound;
    public CheckingAccountEntity findById(int id);
}
