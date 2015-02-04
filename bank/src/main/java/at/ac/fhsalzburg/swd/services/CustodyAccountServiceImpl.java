package at.ac.fhsalzburg.swd.services;

import at.ac.fhsalzburg.swd.entities.CustodyAccountEntity;
import at.ac.fhsalzburg.swd.repositories.CustodyAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by WuM on 01.02.2015.
 */
@Service
public class CustodyAccountServiceImpl implements CustodyAccountService {

    @Resource
    CustodyAccountRepository custodyAccountRepository;

    @Override
    @Transactional
    public CustodyAccountEntity create(CustodyAccountEntity custodyAccount) {
        CustodyAccountEntity createdCustodyAccount = custodyAccount;
        createdCustodyAccount.setAccountStatement(BigDecimal.valueOf(0L));
        createdCustodyAccount.setAccountStatementDate(Timestamp.valueOf(LocalDateTime.now()));
        return custodyAccountRepository.save(createdCustodyAccount);
    }

    @Override
    @Transactional
    public CustodyAccountEntity delete(int id) throws AccountNotFoundException {
        CustodyAccountEntity deletedCustodyAccount = custodyAccountRepository.findOne(id);
        if (deletedCustodyAccount == null) throw new AccountNotFoundException();
        custodyAccountRepository.delete(deletedCustodyAccount);
        return deletedCustodyAccount;
    }

    @Override
    @Transactional
    public List<CustodyAccountEntity> findAll() {
        return custodyAccountRepository.findAll();
    }

    @Override
    @Transactional
    public CustodyAccountEntity update(CustodyAccountEntity custodyAccount) throws AccountNotFoundException {
        CustodyAccountEntity updatedCustodyAccount = custodyAccountRepository.findOne(custodyAccount.getAccountId());
        if (updatedCustodyAccount == null) throw new AccountNotFoundException();
        updatedCustodyAccount.setCheAccountId(custodyAccount.getCheAccountId());
        updatedCustodyAccount.setAccountDescription(custodyAccount.getAccountDescription());
        updatedCustodyAccount.setCustomerId(custodyAccount.getCustomerId());
        updatedCustodyAccount.setAccountIban(custodyAccount.getAccountIban());
        updatedCustodyAccount.setAccountSaldo(custodyAccount.getAccountSaldo());
        //updatedCustodyAccount.setAccountStatement(custodyAccount.getAccountStatement());
        //updatedCustodyAccount.setAccountStatementDate(custodyAccount.getAccountStatementDate());
        return updatedCustodyAccount;
    }

    @Override
    @Transactional
    public CustodyAccountEntity findById(int id) {
        return custodyAccountRepository.findOne(id);
    }
}
