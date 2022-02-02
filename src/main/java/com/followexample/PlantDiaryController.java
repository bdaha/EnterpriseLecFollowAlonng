package com.followexample;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Example java doc
 */

@Controller
public class PlantDiaryController {

    /**
     * Handle the root (/) endpoint and return a start page
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

}
