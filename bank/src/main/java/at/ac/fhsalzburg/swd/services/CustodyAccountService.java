package at.ac.fhsalzburg.swd.services;

import at.ac.fhsalzburg.swd.entities.CustodyAccountEntity;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

/**
 * Created by WuM on 01.02.2015.
 */
public interface CustodyAccountService {
    public CustodyAccountEntity create(CustodyAccountEntity custodyAccount2Entity);
    public CustodyAccountEntity delete(int id) throws AccountNotFoundException;
    public List<CustodyAccountEntity> findAll();
    public CustodyAccountEntity update(CustodyAccountEntity custodyAccount2Entity) throws AccountNotFoundException;
    public CustodyAccountEntity findById(int id);
}
