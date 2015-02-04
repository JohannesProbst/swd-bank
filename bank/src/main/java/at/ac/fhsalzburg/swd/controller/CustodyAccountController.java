package at.ac.fhsalzburg.swd.controller;

import at.ac.fhsalzburg.swd.entities.CustodyAccountEntity;
import at.ac.fhsalzburg.swd.services.CustodyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

/**
 * Created by WuM on 03.02.2015.
 */
@Controller
@RequestMapping(value = "/custodyaccount")
public class CustodyAccountController {
    @Autowired
    private CustodyAccountService custodyAccountService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView newCustodyAccountPage() {
        ModelAndView mav = new ModelAndView("custodyaccount-new","custodyAccount", new CustodyAccountEntity());
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createNewCustodyAccount(@ModelAttribute CustodyAccountEntity custodyAccount,
                                                final RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();
        String message = "Neues Depot " + custodyAccount.getAccountId() + " erstellt.";

        custodyAccountService.create(custodyAccount);
        mav.setViewName("redirect:/index");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listCustodyAccountPage(){
        ModelAndView mav = new ModelAndView("custodyaccount-list");
        List<CustodyAccountEntity> custodyAccountList = custodyAccountService.findAll();
        mav.addObject("custodyAccountList", custodyAccountList);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCustodyAccountPage(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("custodyaccount-edit");
        CustodyAccountEntity custodyAccount = custodyAccountService.findById(id);
        mav.addObject("custodyAccount", custodyAccount);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editCustodyAccount(@ModelAttribute CustodyAccountEntity custodyAccount, @PathVariable Integer id, final RedirectAttributes redirectAttributes) throws AccountNotFoundException {
        ModelAndView mav = new ModelAndView("redirect:/index");
        custodyAccount.setAccountId(id);
        String message = "Depot " + custodyAccount.getAccountId() + " geändert.";

        custodyAccountService.update(custodyAccount);

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCustodyAccount(@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws AccountNotFoundException {
        ModelAndView mav = new ModelAndView("redirect:/index");

        CustodyAccountEntity custodyAccount = custodyAccountService.delete(id);
        String message = "Depot " + custodyAccount.getAccountId() + " gelöscht.";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }
}
