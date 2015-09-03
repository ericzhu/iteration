package ca.el.ecom.extension.web.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/items")
public class ItemController {
   
   @RequestMapping(method = RequestMethod.GET)
   public String list() {
      return "item/list";
   }
}
