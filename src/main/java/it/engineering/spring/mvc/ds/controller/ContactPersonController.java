package it.engineering.spring.mvc.ds.controller;

import it.engineering.spring.mvc.ds.dto.CityDto;
import it.engineering.spring.mvc.ds.dto.ContactPersonDto;
import it.engineering.spring.mvc.ds.dto.ManufacturerDto;
import it.engineering.spring.mvc.ds.service.ContactPersonService;
import it.engineering.spring.mvc.ds.service.ManufacturerService;
import it.engineering.spring.mvc.ds.validator.ContactPersonValidator;
import it.engineering.spring.mvc.ds.validator.ManufacturerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/contact_person")
public class ContactPersonController {
    private final ContactPersonService contactPersonService;
    private final ManufacturerService manufacturerService;

    @Autowired
    public ContactPersonController(ContactPersonService contactPersonService, ManufacturerService manufacturerService) {
        this.contactPersonService = contactPersonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping(path = { "/add" })
    public ModelAndView add() throws Exception {
        ModelAndView modelAndView = new ModelAndView("contact-person/contact-person-add");
        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(@Valid @ModelAttribute(name = "contactPersonDto") ContactPersonDto contactPersonDto,
                             Errors errors) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contact-person/contact-person-add");

        if (errors.hasErrors()) {
            System.out.println("Ima gresaka kod validacaije...");
        } else {
            System.out.println("Nema gresaka sacuvaj proizvodjaca...");
            contactPersonService.save(contactPersonDto);
        }
        return modelAndView;
    }

    @GetMapping(path = "/list")
    public ModelAndView list() throws Exception {
        List<ContactPersonDto> contactPersons = contactPersonService.getAll();
        ModelAndView modelAndView = new ModelAndView("contact-person/contact-person-list");
        modelAndView.addObject("contactPersons", contactPersons);
        return modelAndView;
    }

    @GetMapping(path = "/details/id/{id}")
    public ModelAndView details(@PathVariable(name = "id") Long id) throws Exception {
        System.out.println("================================ DETAILS ==============================");

        ContactPersonDto contactPersonDto = contactPersonService.findById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contact-person/contact-person-details");
        modelAndView.addObject("contactPersonDto", contactPersonDto);

        return modelAndView;
    }

    @GetMapping(path = "/edit/id/{id}")
    public ModelAndView edit(@PathVariable(name = "id") Long id) throws Exception {
        System.out.println("================================ EDIT ==============================");
        System.out.println("ID: " + id);

        ContactPersonDto contactPersonDto = contactPersonService.findById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contact-person/contact-person-edit");
        modelAndView.addObject("contactPersonDto", contactPersonDto);

        return modelAndView;
    }

    @PostMapping(path = "/confirm")
    public ModelAndView confirm(@Valid @ModelAttribute(name = "contactPersonDto")
                                            ContactPersonDto contactPersonDto,
                                Errors errors) throws Exception {
        System.out.println("================================ CONFIRM ==============================");

        String view = "contact-person/contact-person-add";

        ModelAndView modelAndView = new ModelAndView();
        if (errors.hasErrors()) {
            System.out.println("Ima gresaka kod validacaije...");
            if (contactPersonDto.getId() != null)
                view = "contact-person/contact-person-edit";
        } else {
            System.out.println("Nema gresaka azuriraj kontakt osobe...");
            view = "contact-person/contact-person-confirm";
        }

        modelAndView.setViewName(view);
        return modelAndView;
    }

    @PostMapping(path = "/saveOrUpdate")
    public ModelAndView saveOrUpdate(@Valid @ModelAttribute(name = "contactPersonDto")
                                                 ContactPersonDto contactPersonDto,
                                     Errors errors) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String view = "contact-person/contact-person-add";

        if (errors.hasErrors()) {
            System.out.println("Ima gresaka kod validacaije...");
            if (contactPersonDto.getId() != null)
                view = "contact-person/contact-person-edit";
        } else {
            // save or update
            if (contactPersonDto.getId() == null) {
                contactPersonService.save(contactPersonDto);
                view = "redirect:/contact_person/add";
            } else {
                contactPersonService.update(contactPersonDto);
                view = "redirect:/contact_person/details/id/" + contactPersonDto.getId();
            }
        }

        modelAndView.setViewName(view);
        return modelAndView;
    }

    @PostMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable(name = "id") Long id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("redirect:/contact_person/list");

        contactPersonService.delete(id);

        return modelAndView;
    }

    @ModelAttribute(name = "contactPersonDto")
    private ContactPersonDto contactPersonDto() {
        System.out.println("*****************************************************");
        System.out.println("kreiran je: @ModelAttribute(name = \"contactPersonDto\")");

        ContactPersonDto contactPersonDto = new ContactPersonDto();
        contactPersonDto.setFirstname("n/a");
        contactPersonDto.setLastname("n/a");
        return contactPersonDto;
    }

    @ModelAttribute(name = "manufacturers")
    private List<ManufacturerDto> getManufacturers() throws Exception {
        return manufacturerService.getAll();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("====================== @InitBinder ====================");
        System.out.println("public void initBinder(WebDataBinder binder)");
        binder.addValidators(new ContactPersonValidator());
    }

}
