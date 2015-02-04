package at.ac.fhsalzburg.swd.controller;

import at.ac.fhsalzburg.swd.entities.AccountEntity;
import at.ac.fhsalzburg.swd.entities.CheckingAccountEntity;
import at.ac.fhsalzburg.swd.repositories.AccountRepository;
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

/**
 * Created by Joey on 04.02.2015.
 */
@Controller
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    //@RequestMapping(value = "/{id}/account/open", method = RequestMethod.GET)
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

}
