package edu.pafiast.refractoring.controller;

import edu.pafiast.refractoring.model.RefactoringCodeComparison;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UIController {

    private final TechniquesController techniquesController;

    public UIController(TechniquesController techniquesController) {
        this.techniquesController = techniquesController;
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String q) {
        if (q != null && !q.trim().isEmpty()) {
            model.addAttribute("techniques", techniquesController.search(q));
            model.addAttribute("searchQuery", q);
            model.addAttribute("isSearch", true);
        } else {
            model.addAttribute("categories", techniquesController.getCategories());
            model.addAttribute("searchQuery", "");
            model.addAttribute("isSearch", false);
        }
        return "index";
    }

    @GetMapping("/technique/{slug}")
    public String technique(@PathVariable String slug, Model model) {
        try {
            RefactoringCodeComparison comparison = techniquesController.getComparison(slug);
            model.addAttribute("comparison", comparison);
            return "technique";
        } catch (IllegalArgumentException e) {
            return "redirect:/"; // redirect to home if not found
        }
    }
}
