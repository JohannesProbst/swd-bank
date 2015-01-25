package at.ac.fhsalzburg.swd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Joey on 25.01.2015.
 */
@Controller
public class IndexController {

    @RequestMapping(value={"/", "index"}, method= RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
