package ru.javastudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.dao.impl.CommentsDAO;
import ru.javastudy.dao.models.MailUser;
import ru.javastudy.dao.models.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Controller
public class MainController {
    @Autowired
    CommentsDAO dao;

    @RequestMapping("/commentform")
    public String main(Model m){
        m.addAttribute("command", new User());
        return "addComments";
    }



    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user){
        dao.save(user);
        return "redirect:/viewComments";//will redirect to viewemp request mapping
    }



    @RequestMapping("/viewComments")
    public String viewemp(Model m){
        List<User> list = dao.getComments();
        m.addAttribute("list",list);
        m.addAttribute("command", new User());
        return "comments";
    }





    @RequestMapping("/mainPage")
    public String showMainPage(Model m) {
        return "mainPage";
    }

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннотации и настройки пути после деплоя) */


}
