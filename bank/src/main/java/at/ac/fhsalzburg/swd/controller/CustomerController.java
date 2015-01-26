package at.ac.fhsalzburg.swd.controller;

import at.ac.fhsalzburg.swd.entities.CustomerEntity;
import at.ac.fhsalzburg.swd.exceptions.CustomerNotFound;
import at.ac.fhsalzburg.swd.services.CustomerService;
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
 * Created by Joey on 26.01.2015.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView newCustomerPage(){
        ModelAndView mav = new ModelAndView("customer-new","customer", new CustomerEntity());
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createNewCustomer(@ModelAttribute CustomerEntity customer, final RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView();
        String message = "New customer " + customer.getCustomerName() + " was successfully created.";

        customerService.create(customer);
        mav.setViewName("redirect:/index");

        redirectAttributes.addFlashAttribute("message", message);
        return  mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listCustomerPage(){
        ModelAndView mav = new ModelAndView("customer-list");
        List<CustomerEntity> customerList = customerService.findAll();
        mav.addObject("customerList", customerList);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCustomerPage(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("customer-edit");
        CustomerEntity customer = customerService.findById(id);
        mav.addObject("customer", customer);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editCustomer(@ModelAttribute CustomerEntity customer, @PathVariable Integer id, final RedirectAttributes redirectAttributes) throws CustomerNotFound{
        ModelAndView mav = new ModelAndView("redirect:/index");
        String message = "Customer was successfully updated.";

        customerService.update(customer);

        redirectAttributes.addFlashAttribute("message", message);
        return  mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws CustomerNotFound{
        ModelAndView mav = new ModelAndView("redirect:/index");

        CustomerEntity customer = customerService.delete(id);
        String message = "The customer " + customer.getCustomerName() + " was successfully deleted.";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }
}
