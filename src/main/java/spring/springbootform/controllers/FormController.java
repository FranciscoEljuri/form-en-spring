package spring.springbootform.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springbootform.models.domain.Usuario;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();

        model.addAttribute("titulo", "Resultado Usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model){

        model.addAttribute("titulo", "Resultado Form ");

        if (result.hasErrors()){
            return "form";
        }

        model.addAttribute("usuario", usuario);

        return "resultado";
    }
}
