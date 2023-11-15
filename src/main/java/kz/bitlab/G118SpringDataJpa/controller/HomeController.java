package kz.bitlab.G118SpringDataJpa.controller;

import java.util.List;
import kz.bitlab.G118SpringDataJpa.model.Developer;
import kz.bitlab.G118SpringDataJpa.repository.DeveloperRepository;
import kz.bitlab.G118SpringDataJpa.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
  @Autowired
  private DeveloperRepository developerRepository;
  @Autowired
  private DeveloperService developerService;

  @GetMapping("/")
  public String homePage(Model model) {
    List<Developer> developers = developerRepository.findAll();
    model.addAttribute("razraby", developers);
    return "home";
  }

  @GetMapping("/developer/{id}")
  public String getDeveloper(@PathVariable Long id, Model model) {
    Developer developer = developerRepository.findById(id).orElse(null);
    model.addAttribute("razrab", developer);
    return "developer-details";
  }

  @GetMapping("/developer/details/{email}")
  public String getDeveloper(@PathVariable String email, Model model) {
    Developer developer = developerRepository.findByEmail(email);
    model.addAttribute("razrab", developer);
    return "developer-details";
  }

  @GetMapping("/developer/search")
  public String getDevelopers(@RequestParam String search, Model model) {
    List<Developer> developers = developerService.search(search);
    model.addAttribute("razraby", developers);
    return "home";
  }


  @PostMapping("/developer/add")
  public String addDeveloper(Developer developer) {
    developerRepository.save(developer);
    return "redirect:/";
  }

  @PostMapping("/developer/update")
  public String updateDeveloper(Developer developer) {
    developerRepository.save(developer);
    return "redirect:/";
  }
}
