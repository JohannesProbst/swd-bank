package at.ac.fhsalzburg.swd.services;

import at.ac.fhsalzburg.swd.entities.AccountEntity;
import at.ac.fhsalzburg.swd.exceptions.AccountNotFound;

import java.util.List;

/**
 * Created by Joey on 28.01.2015.
 */
public interface AccountService {
    public AccountEntity create(AccountEntity account);
    public AccountEntity delete(int id) throws AccountNotFound;
    public List<AccountEntity> findAll();
    public AccountEntity update(AccountEntity account) throws AccountNotFound;
    public AccountEntity updateSaldo(AccountEntity account) throws AccountNotFound;
    public AccountEntity updateStatement(AccountEntity account) throws AccountNotFound;
    public AccountEntity findById(int id);
}
