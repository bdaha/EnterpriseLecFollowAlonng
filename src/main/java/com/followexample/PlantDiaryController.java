package com.followexample;


import com.followexample.dto.Specimen;
import com.followexample.service.ISpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

/**
 * Example java doc
 */

@Controller
public class PlantDiaryController {

    @Autowired
    ISpecimenService specimenService;

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
    @ResponseBody
    public List<Specimen> fetchAllSpecimens() {
        return specimenService.fetchAll();
    }

    @GetMapping("/specimen/{id}/")
    public ResponseEntity fetchSpecimenById(@PathVariable("id") String id) {
        Specimen foundSpecimen = specimenService.fetchById(Integer.parseInt(id));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundSpecimen, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/specimen", consumes = "application/json", produces = "application/json")
    public Specimen createSpecimen(@RequestBody Specimen specimen) throws Exception {
        Specimen newSpecimen = null;
        try {
            specimenService.save(specimen);
        }catch (Exception e) {
            //TODO add logging
        }
            return newSpecimen;
    }

    @DeleteMapping("/specimen/{id}/")
    public ResponseEntity deleteSpecimen(@PathVariable("id") String id){
        try {
            specimenService.delete(Integer.parseInt(id));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
