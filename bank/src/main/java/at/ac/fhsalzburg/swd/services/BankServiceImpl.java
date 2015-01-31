package at.ac.fhsalzburg.swd.services;

import at.ac.fhsalzburg.swd.entities.BankEntity;
import at.ac.fhsalzburg.swd.exceptions.BankNotFound;
import at.ac.fhsalzburg.swd.repositories.BankRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Joey on 25.01.2015.
 */
@Service
public class BankServiceImpl implements BankService {

    @Resource
    private BankRepository bankRepository;

    @Override
    @Transactional
    public BankEntity create(BankEntity bank) {
        BankEntity createdBank = bank;
        return bankRepository.save(createdBank);
    }

    @Override
    @Transactional(rollbackFor = BankNotFound.class)
    public BankEntity delete(int id) throws BankNotFound {
        BankEntity deletedBank = bankRepository.findOne(id);
        if(deletedBank == null)
            throw new BankNotFound();
        bankRepository.delete(deletedBank);
        return deletedBank;
    }

    @Override
    @Transactional
    public List<BankEntity> findAll() {
        return bankRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = BankNotFound.class)
    public BankEntity update(BankEntity bank) throws BankNotFound {
        BankEntity updatedBank = bankRepository.findOne(bank.getBankId());
        System.out.printf(bank.toString());
        if (updatedBank == null)
            throw new BankNotFound();
        updatedBank.setBankName(bank.getBankName());
        updatedBank.setBankBic(bank.getBankBic());
        updatedBank.setBankAddress(bank.getBankAddress());
        return updatedBank;
    }

    @Override
    @Transactional
    public BankEntity findById(int id) {
        return bankRepository.findOne(id);
    }
}
