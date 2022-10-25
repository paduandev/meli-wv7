package br.dh.meli.tutoriais.controller;

import br.dh.meli.tutoriais.model.Status;
import br.dh.meli.tutoriais.model.Tutorial;
import br.dh.meli.tutoriais.service.ITutorialService;
import br.dh.meli.tutoriais.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutorial")
public class TutorialController {

    @Autowired
    private ITutorialService service;

    // TODO: tratar exception de title null
    @PostMapping
    public ResponseEntity<Tutorial> insert(@RequestBody Tutorial tutorial) {
        Tutorial newTutorial = service.insert(tutorial);
         return new ResponseEntity<>(newTutorial, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/published")
    public ResponseEntity<Tutorial> updateStatusPublished(@PathVariable Long id) {
        Optional<Tutorial> optionalTutorial = service.getById(id);
        if(optionalTutorial.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Tutorial tutorial = optionalTutorial.get();
        tutorial.setStatus(Status.PUBLISHED);
        tutorial = service.update(tutorial);
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Tutorial>> getByTitle(@PathVariable String title) {
        List<Tutorial> tutoriais = service.getByTitle(title);
        return new ResponseEntity<>(tutoriais, HttpStatus.OK);
    }
}
