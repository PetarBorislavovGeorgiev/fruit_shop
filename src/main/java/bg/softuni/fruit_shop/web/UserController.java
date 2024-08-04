package bg.softuni.fruit_shop.web;


import bg.softuni.fruit_shop.model.dto.UserLoginDTO;
import bg.softuni.fruit_shop.model.dto.UserRegisterDTO;
import bg.softuni.fruit_shop.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {



    @GetMapping("/about")
    public String about() {
        return "about";
    }


    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
