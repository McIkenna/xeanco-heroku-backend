package com.xeanco.xeanco.controller;

import com.xeanco.xeanco.model.Intro;
import com.xeanco.xeanco.response.Response;
import com.xeanco.xeanco.service.IntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin
@SpringBootApplication
public class IntroController {

    @Autowired
    IntroService introService;

    @PostMapping("admin/intro")
    public Response save(@Valid @RequestParam MultipartFile file, Intro intro){
        Intro intro1 = introService.saveOrUpdate(file, intro);
        Response response = new Response();
        if(intro1 != null){
            response.setMessage("Intro Save Successfully");
            return response;
        }
        response.setMessage("Intro was not saved");
        return response;
    }

    @GetMapping("api/intro/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        Intro intro2 = introService.findIntroById(id);
        return new ResponseEntity<Intro>(intro2, HttpStatus.OK);
    }

    @PutMapping("admin/intro")
    public Response updateFeature(@Valid @RequestParam MultipartFile file, Intro intro, BindingResult result){
        Intro intro1 = introService.Update(file, intro);
        Response response = new Response();
        if(intro1 != null){
            response.setMessage("Intro Updated Successfully");
            return response;
        }
        response.setMessage("Intro was not updated");
        return response;
    }

    @DeleteMapping("admin/intro/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
         introService.deleteInfoById(id);
        return  new ResponseEntity<String>("User with ID: " + id + " was deleted", HttpStatus.OK);
    }

    @GetMapping("api/intro/all")
    public List<Intro> getAllIntros(){
        return introService.findAllIntro();
    }
}
