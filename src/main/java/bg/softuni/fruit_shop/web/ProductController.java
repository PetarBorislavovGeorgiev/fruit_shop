package bg.softuni.fruit_shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("")
    public String product(){
        return "product";
    }

    @GetMapping("fruit")
    public String fruit(){
        return "fruit";
    }

    @GetMapping("vegetable")
    public String vegetable(){
        return "vegetable";
    }
}
