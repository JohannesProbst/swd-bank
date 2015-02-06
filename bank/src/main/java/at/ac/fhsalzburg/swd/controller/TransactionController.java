package at.ac.fhsalzburg.swd.controller;

import at.ac.fhsalzburg.swd.entities.AccountEntity;
import at.ac.fhsalzburg.swd.entities.ContraAccountEntity;
import at.ac.fhsalzburg.swd.entities.CustomerEntity;
import at.ac.fhsalzburg.swd.entities.TransactionEntity;
import at.ac.fhsalzburg.swd.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transaction;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Philipp on 05.02.2015.
 */
@Controller
public class TransactionController
{
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CheckingAccountRepository checkingAccountRepository;
    @Autowired
    SavingsAccountRepository savingsAccountRepository;
    @Autowired
    CustodyAccountRepository custodyAccountRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ContraAccountRepository contraAccountRepository;
    @Autowired
    BankRepository bankRepository;

    private static final String successMessage = "Congraz: transaction successfully committed (っ˘ڡ˘ς)!";
    private static final String hazard = "Error: authentication failed! Our admins recognized hazardous requests, your account will be closed!";

    @RequestMapping(value = "cash-dispenser", method = RequestMethod.GET)
    public ModelAndView cashDispenser()
    {
        ModelAndView mav = new ModelAndView();
        return mav;
    }

    @RequestMapping(value = "/transaction/start", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView startTransaction(@RequestParam("customerId") Integer customerId, @RequestParam("pin") String pin, final RedirectAttributes redirectAttributes)
    {
        ModelAndView mav = new ModelAndView();

        CustomerEntity c = customerRepository.findByCustomerIdAndPin(customerId, pin);
        if(c != null)
        {
            mav.addObject("customer", c);
            mav.addObject("checkingAccounts", checkingAccountRepository.findAllByCustomerId(c.getCustomerId()));
            mav.addObject("custodyAccounts", custodyAccountRepository.findAllByCustomerId(c.getCustomerId()));
            mav.addObject("savingsAccounts", savingsAccountRepository.findAllByCustomerId(c.getCustomerId()));

            mav.setViewName("transaction-start");
            return mav;
        }
        else {
            mav.setViewName("redirect:/cash-dispenser");
            redirectAttributes.addFlashAttribute("error", "Error: authentication failed (；☉_☉)");
        }

        return mav;
    }

    @RequestMapping(value = "/transaction/deposit", method = RequestMethod.POST)
    public ModelAndView depositTransaction(
            @RequestParam("customerId") Integer customerId,
            @RequestParam("pin") String pin,
            @RequestParam("amount") BigDecimal amount,
            @RequestParam("accountId") Integer accountId,
            final RedirectAttributes redirectAttributes)
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/transaction/start");

        TransactionEntity transaction = createTransaction(customerId, pin, accountId, amount, TransactionEntity.TransactionType.DEPOSIT);
        if(transaction.isValid())
        {
            AccountEntity account = transaction.getAccount();
            account.setAccountSaldo(account.getAccountSaldo().add(amount));
            account.setAccountStatement(account.getAccountSaldo());
            account.setAccountStatementDate(transaction.getTimestamp());

            accountRepository.save(account);
            transactionRepository.save(transaction);

            redirectAttributes.addFlashAttribute("message", successMessage);
            redirectAttributes.addAttribute("customerId", customerId);
            redirectAttributes.addAttribute("pin", pin);
        }
        else {
            redirectAttributes.addFlashAttribute("error", hazard+" no customer found");
            mav.setViewName("redirect:/cash-dispenser");
            return mav;
        }

        return mav;
    }

    @RequestMapping(value = "/transaction/withdraw", method = RequestMethod.POST)
    public ModelAndView withdrawTransaction(
        @RequestParam("customerId") Integer customerId,
        @RequestParam("pin") String pin,
        @RequestParam("amount") BigDecimal amount,
        @RequestParam("accountId") Integer accountId,
        final RedirectAttributes redirectAttributes)
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/transaction/start");

        TransactionEntity transaction = createTransaction(customerId, pin, accountId, amount, TransactionEntity.TransactionType.WITHDRAW);
        if(transaction.isValid())
        {
            AccountEntity account = transaction.getAccount();
            BigDecimal saldo = account.getAccountSaldo().subtract(amount);
            if(saldo.compareTo(BigDecimal.ZERO) >= 0)
            {
                account.setAccountSaldo(saldo);
                account.setAccountStatement(account.getAccountSaldo());
                account.setAccountStatementDate(transaction.getTimestamp());

                accountRepository.save(account);
                transactionRepository.save(transaction);
                redirectAttributes.addFlashAttribute("message", successMessage);
            }
            else {
                redirectAttributes.addFlashAttribute("error", "Error: account saldo does not fulfill transaction requirements (；☉_☉)!");
            }

            redirectAttributes.addAttribute("customerId", customerId);
            redirectAttributes.addAttribute("pin", pin);
        }
        else {
            redirectAttributes.addFlashAttribute("error", hazard);
            mav.setViewName("redirect:/cash-dispenser");
            return mav;
        }

        return mav;
    }

    public TransactionEntity createTransaction(Integer customerId, String pin, Integer accountId, BigDecimal amount, TransactionEntity.TransactionType tt)
    {
        TransactionEntity transaction = new TransactionEntity();
        ContraAccountEntity contraAccountEntity = new ContraAccountEntity();

        transaction.setTransactionAmount(amount);

        CustomerEntity c = customerRepository.findByCustomerIdAndPin(customerId, pin);
        if(c != null)
        {
            transaction.setCustomer(c);
            AccountEntity account = accountRepository.findAllByCustomerIdAndAccountId(customerId, accountId);
            if(account != null)
            {
                transaction.setAccount(account);
                transaction.setAccountId(accountId);
                transaction.setTransactionAmount(amount);
                transaction.setTransactionType(tt);
                transaction.setValutaDate(new java.sql.Date(new Date().getTime()));
                transaction.setTimestamp(new Timestamp(new Date().getTime()));

                contraAccountEntity.setContraBic(bankRepository.findOne(c.getBankId()).getBankBic());
                contraAccountEntity.setContraIban(account.getAccountIban());
                contraAccountRepository.save(contraAccountEntity);

                transaction.setConTransactionsId(contraAccountEntity.getTransactionsId());
                transaction.setValid(true);
            }
        }

        return transaction;
    }
}
