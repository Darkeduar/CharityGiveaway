package pl.coderslab.charity.user;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping()public class UserController {

    private Logger LOG = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/register")
    public String createUserForm(Model model){
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String createUser(UserDto userDto){
        userService.createUser(userDto);
        return "redirect:/";
    }

    @GetMapping("/{uuid}/enable")
    @ResponseBody
    public String enableUser(@PathVariable String uuid) {
        userService.enableUser(uuid);
        return "Konto aktywowane!";
    }

}
