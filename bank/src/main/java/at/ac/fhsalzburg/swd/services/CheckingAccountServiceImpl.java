package at.ac.fhsalzburg.swd.services;

import at.ac.fhsalzburg.swd.entities.CheckingAccountEntity;
import at.ac.fhsalzburg.swd.exceptions.CheckingAccountNotFound;
import at.ac.fhsalzburg.swd.repositories.CheckingAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Joey on 28.01.2015.
 */
@Service
public class CheckingAccountServiceImpl implements CheckingAccountService {

    @Resource
    CheckingAccountRepository checkingAccountRepository;

    @Override
    @Transactional
    public CheckingAccountEntity create(CheckingAccountEntity checkingAccount) {
        return null;
    }

    @Override
    @Transactional
    public CheckingAccountEntity delete(int id) throws CheckingAccountNotFound {
        return null;
    }

    @Override
    @Transactional
    public List<CheckingAccountEntity> findAll() {
        return null;
    }

    @Override
    @Transactional
    public CheckingAccountEntity update(CheckingAccountEntity checkingAccount) throws CheckingAccountNotFound {
        return null;
    }

    @Override
    @Transactional
    public CheckingAccountEntity findById(int id) {
        return null;
    }
}
