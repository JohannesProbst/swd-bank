package at.ac.fhsalzburg.swd.services;

import at.ac.fhsalzburg.swd.entities.BankEntity;
import at.ac.fhsalzburg.swd.exceptions.BankNotFound;

import java.util.List;

/**
 * Created by Joey on 25.01.2015.
 */
public interface BankService {

    public BankEntity create(BankEntity bank);
    public BankEntity delete(int id) throws BankNotFound;
    public List<BankEntity> findAll();
    public BankEntity update(BankEntity bank) throws BankNotFound;
    public BankEntity findById(int id);
}
