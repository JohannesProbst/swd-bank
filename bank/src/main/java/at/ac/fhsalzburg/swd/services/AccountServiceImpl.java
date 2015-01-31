package at.ac.fhsalzburg.swd.services;

import at.ac.fhsalzburg.swd.entities.AccountEntity;
import at.ac.fhsalzburg.swd.exceptions.AccountNotFound;
import at.ac.fhsalzburg.swd.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Joey on 28.01.2015.
 */
@Service
public class AccountServiceImpl implements AccountService{

    @Resource
    AccountRepository accountRepository;

    @Override
    @Transactional
    public AccountEntity create(AccountEntity account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public AccountEntity delete(int id) throws AccountNotFound {
        AccountEntity deletedAccount = accountRepository.findOne(id);
        if (deletedAccount == null)
            throw new AccountNotFound();
        accountRepository.delete(deletedAccount);
        return deletedAccount;
    }

    @Override
    @Transactional
    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public AccountEntity update(AccountEntity account) throws AccountNotFound {
        AccountEntity updatedAccount = accountRepository.findOne(account.getAccountId());
        if (updatedAccount == null)
            throw new AccountNotFound();
        updatedAccount.setAccountDescription(account.getAccountDescription());
        updatedAccount.setAccountIban(account.getAccountIban());
        updatedAccount.setAccountSaldo(account.getAccountSaldo());
        updatedAccount.setAccountStatement(account.getAccountStatement());
        updatedAccount.setAccountStatementDate(account.getAccountStatementDate());

        return updatedAccount;
    }

    @Override
    public AccountEntity updateSaldo(AccountEntity account) throws AccountNotFound{
        AccountEntity accountWithUpdatedSaldo = accountRepository.findOne(account.getAccountId());
        if (accountWithUpdatedSaldo == null)
            throw new AccountNotFound();
        accountWithUpdatedSaldo.setAccountSaldo(account.getAccountSaldo());

        return accountWithUpdatedSaldo;
    }

    @Override
    public AccountEntity updateStatement(AccountEntity account) throws AccountNotFound {
        AccountEntity accountWithUpdatedStatement = accountRepository.findOne(account.getAccountId());
        if (accountWithUpdatedStatement == null)
            throw new AccountNotFound();
        accountWithUpdatedStatement.setAccountStatement(account.getAccountStatement());
        accountWithUpdatedStatement.setAccountStatementDate(account.getAccountStatementDate());

        return accountWithUpdatedStatement;
    }

    @Override
    @Transactional
    public AccountEntity findById(int id) {
        return accountRepository.findOne(id);
    }
}
