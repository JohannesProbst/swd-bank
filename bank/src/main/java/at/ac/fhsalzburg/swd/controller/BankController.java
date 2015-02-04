package at.ac.fhsalzburg.swd.controller;

import at.ac.fhsalzburg.swd.entities.BankEntity;
import at.ac.fhsalzburg.swd.exceptions.BankNotFound;
import at.ac.fhsalzburg.swd.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by Joey on 25.01.2015.
 */
@Controller
@RequestMapping(value = "/bank")
public class BankController {
    @Autowired
    private BankService bankService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView newBankPage(){
        ModelAndView mav = new ModelAndView("bank-new","bank", new BankEntity());
        return  mav;
    }

    @RequestMapping(value = "/create", method=RequestMethod.POST)
    public ModelAndView createNewBank(@ModelAttribute BankEntity bank, final RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView();
        String message = "New Bank " + bank.getBankName() + " was successfully created.";

        bankService.create(bank);
        mav.setViewName("redirect:/index");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listBankPage(){
        ModelAndView mav = new ModelAndView("bank-list");
        List<BankEntity> bankList = bankService.findAll();
        mav.addObject("bankList", bankList);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editBankPage(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("bank-edit");
        BankEntity bank = bankService.findById(id);
        mav.addObject("bank", bank);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editBank(@ModelAttribute BankEntity bank, @PathVariable Integer id, final RedirectAttributes redirectAttributes) throws BankNotFound{
        ModelAndView mav = new ModelAndView("redirect:/index");
        System.out.printf(bank.toString());
        bank.setBankId(id);//Weil die id in der jsp seite nicht per input gesetzt wird, kommt sie auf null gesetzt zurück. Daher muss ich sie wieder korrigieren!
        String message = "Bank " + bank.getBankId() + " was successfully updated.";

        bankService.update(bank);

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBank(@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws BankNotFound {
        ModelAndView mav = new ModelAndView("redirect:/index");

        BankEntity bank = bankService.delete(id);
        String message = "The bank " + bank.getBankName() + " was successfully deleted.";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }
}
