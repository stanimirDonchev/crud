/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stanimir.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stanimir.domain.Human;
import com.stanimir.domain.HumanRepository;
/**
 *
 * @author Stanimir Donchev
 */
@Controller
@RequestMapping("/users")
public class UserController 
{
    @Autowired
    private HumanRepository repository;
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public String listUsers(Model model) 
    {
        model.addAttribute("users", repository.findAll());
        return "users/list";
    }
    
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newProject() {
        return "users/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("dob") String dob,
                               @RequestParam("phoneNumber") String phoneNumber,
                               @RequestParam("email") String email)
    {
        repository.save(new Human(firstName, lastName, dob, phoneNumber, email));
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("user_id") long id,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("dob") String dob,
                               @RequestParam("phoneNumber") String phoneNumber,
                               @RequestParam("email") String email) {
        Human user = repository.findOne(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDob(dob);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        repository.save(user);
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id,
                       Model model) {
        Human user = repository.findOne(id);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @RequestMapping(value = "{par}/sort", method = RequestMethod.GET)
    public String sortBy(@PathVariable String par, Model model)
    {
        if(par.equalsIgnoreCase("lastName"))
        {
            model.addAttribute("users", repository.sortByLastName());
        } 
        else if(par.equalsIgnoreCase("dob"))
        {
            model.addAttribute("users", repository.sortByDob());
        }
        return "users/list";
    }
    
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(@RequestParam("id") String id, Model model)
    {
        try
        {
            long user_id = Long.parseLong(id);
            Human user = repository.findOne(user_id);
            if(user != null)
            {
                model.addAttribute("user", user);
                return "users/foundUser";
            }
            else
            {
                return "users/userNotFound";
            }
        }
        catch(Exception e)
        {
            return "users/userNotFound";
        }
    }
}
