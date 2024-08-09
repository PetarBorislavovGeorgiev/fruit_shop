package bg.softuni.fruit_shop.web;

import bg.softuni.fruit_shop.service.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/users/details")
    public String getUserDetails(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                 Model model) {

        return "user-details";
    }
}
