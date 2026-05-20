import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CampusController {

    @Autowired StudentRepo studentRepo;
    @Autowired EventRepo eventRepo;

    // 1. Show Login Page
    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    // 2. Handle Login & Session
    @PostMapping("/login")
    public String doLogin(String email, String password, HttpSession session, Model model) {
        Student user = studentRepo.findByEmailAndPassword(email, password);
        if (user != null) {
            session.setAttribute("activeUser", user);
            return "redirect:/dashboard";
        }
        model.addAttribute("error", "Invalid credentials!");
        return "login";
    }

    // 3. Show Dashboard (Requires Session)
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("activeUser") == null) return "redirect:/";
        model.addAttribute("events", eventRepo.findAll());
        return "dashboard";
    }

    // 4. Save Event with Validation
    @PostMapping("/save-event")
    public String saveEvent(@Valid Event event, BindingResult result, HttpSession session) {
        if (session.getAttribute("activeUser") == null) return "redirect:/";
        if (result.hasErrors()) return "add-event"; // Reload form if date is in the past

        eventRepo.save(event);
        return "redirect:/dashboard";
    }
}
