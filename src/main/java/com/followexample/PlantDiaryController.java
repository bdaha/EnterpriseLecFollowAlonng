package com.followexample;


import com.followexample.dto.Specimen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * The controller for Plant Diary REST endpoints and web UI
 *
 * <p>
 *     This class handles the CRUD operations for my plant diarys specimens, vis HTTP actions
 * </p>
 * <p>
 *     This class also serves HTML based web pages for UI interactions with plant specimens
 * </p>
 * @author Binod Dahal
 */

@Controller
public class PlantDiaryController {

    /**
     * Handle the root (/) endpoint and return a start page
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {

        return "start";
    }

    @GetMapping("/specimen")
    public ResponseEntity fetchAllSpecimens() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/specimen/{id}/")
    public ResponseEntity fetchSpecimenById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/specimen", consumes = "application/json", produces = "application/json")
    public Specimen createSpecimen(@RequestBody Specimen specimen) {
        return specimen;
    }

    @DeleteMapping("/specimen/{id}/")
    public ResponseEntity deleteSpecimen(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }
}
