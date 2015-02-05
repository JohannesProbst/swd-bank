package at.ac.fhsalzburg.swd.controller;

import at.ac.fhsalzburg.swd.entities.AccountEntity;
import at.ac.fhsalzburg.swd.entities.CheckingAccountEntity;
import at.ac.fhsalzburg.swd.repositories.AccountRepository;
import org.apache.commons.validator.routines.checkdigit.CheckDigitException;
import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Joey on 04.02.2015.
 */
@Controller
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    //@RequestMapping(value = "customer/{id}/account/open", method = RequestMethod.GET)
    //public ModelAndView openAccountPage() {
    //    return new ModelAndView("account-open");
    //}

    @RequestMapping(value = "customer/{id}/account/open/checking", method = RequestMethod.GET)
     public ModelAndView newCheckingAccount(@PathVariable Integer id){
        CheckingAccountEntity account = new CheckingAccountEntity();
        account.setCustomerId(id);
        ModelAndView mav = new ModelAndView("account-open","account", account);
        return mav;
    }

    @RequestMapping(value = "/open/checking", method=RequestMethod.POST)
    public ModelAndView createNewCkeckingAccount(@ModelAttribute CheckingAccountEntity account, final RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView();
        String message = "New " + account.getAccountDescription() + " for Customer "+ account.getCustomerId() +" was successfully created.";
        account.setAccountStatement(account.getAccountSaldo());
        account.setAccountStatementDate(new Timestamp(new Date().getTime()));
        accountRepository.save(account);
        mav.setViewName("redirect:/index");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value = "customer/{id}/account/list", method = RequestMethod.GET)
    public ModelAndView listAccounts(@PathVariable Integer id){
       List<AccountEntity> accountList=accountRepository.findAllByCustomerId(id);
        ModelAndView mav = new ModelAndView("account-list","accountList",accountList);
        return mav;
    }

    @RequestMapping(value = "account/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCustomerPage(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("account-edit");
        AccountEntity account = accountRepository.findOne(id);
        mav.addObject("account", account);
        return mav;
    }

    @RequestMapping(value = "account/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editCustomer(@ModelAttribute AccountEntity account, @PathVariable Integer id, final RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView("redirect:/index");
        String message = "Account was successfully updated.";
        AccountEntity accountOriginal = accountRepository.findOne(id);
        accountOriginal.setCustomerId(account.getCustomerId());
        accountOriginal.setAccountDescription(account.getAccountDescription());
        accountOriginal.setAccountIban(account.getAccountIban());
        accountOriginal.setAccountSaldo(account.getAccountSaldo());
        accountOriginal.setAccountStatement(account.getAccountStatement());
        accountOriginal.setAccountStatementDate(account.getAccountStatementDate());
        accountRepository.save(accountOriginal);

        redirectAttributes.addFlashAttribute("message", message);
        return  mav;
    }

    @RequestMapping(value = "account/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable Integer id, final RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView("redirect:/index");
        String message="";
        accountRepository.delete(id);
        if (accountRepository.exists(id))
            message = "The account was NOT successfully deleted.";
        else {
            message = "The account was successfully deleted.";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    //Ist noch nicht in Verwendung!!!
    public String createIban(){
        Random random = new Random();
        String countryCode="AT";
        String validationNumber="";
        Integer bankcode=00000;
        Integer accNbrFirst5 = random.nextInt(99999);
        Integer accNbrLast6 = random.nextInt(999999);
        String accountNumber =accNbrFirst5.toString()+accNbrLast6.toString();

        IBANCheckDigit ibanCheck = new IBANCheckDigit();
        try {
            validationNumber =ibanCheck.calculate(accountNumber);
        }catch (CheckDigitException e){

        }

        return countryCode+validationNumber+bankcode+accountNumber;
    }

}
