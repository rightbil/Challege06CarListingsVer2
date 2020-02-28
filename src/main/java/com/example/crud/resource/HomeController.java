package com.example.crud.resource;

import com.example.crud.model.Car;
import com.example.crud.model.Category;
import com.example.crud.repository.CategoryRepository;
import com.example.crud.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public CarRepository carRepository;

    // TODO: Home page Car listings by category
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    //TODO: 1.1 Add Category
    @RequestMapping(value = "/addCategory")
    public String addDept(Model model) {
        model.addAttribute("category", new Category());
        return "categoryForm";
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addDept(@ModelAttribute Category dept, Model model) {
        categoryRepository.save(dept);
        return "redirect:/";
    }

    //TODO: 1.2 Add Car
    @RequestMapping(value = "/addCar")
    public String addEmployee(Model model) {
        Object o = categoryRepository.findAll();
        model.addAttribute("catgs", categoryRepository.findAll());
        model.addAttribute("car", new Car());
        return "carForm";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute Car car) {
        carRepository.save(car);
        return "redirect:/";
    }
    //TODO: 2.1 Delete Category

    @RequestMapping("/deleteCategory/{id}")
    public String deleteDepartment(@PathVariable("id") long id) {
        categoryRepository.deleteById(id);
        return "redirect:/";
    }

    //TODO: 2.2 Delete Car
    @RequestMapping("/deleteCar/{id}")
    public String deleteEmployee(@PathVariable("id") long id) {
        carRepository.deleteById(id);
        return "redirect:/";
    }

    //TODO: 3.1 Update Category
    @RequestMapping("/updateCategory/{id}")
    public String upateDepartment(@PathVariable("id") long id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "categoryForm";
    }

    //TODO: 3.2 Update Car
    @RequestMapping("/updateCar/{id}")
    public String upateEmployee(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        return "carForm";
    }


    //TODO: Additional facilities search

    @RequestMapping("/searchCategory")
    public String search(@RequestParam("search") String search, Model model) {
        model.addAttribute("searchResult", categoryRepository.findByName(search));
        return "search";
    }


}
