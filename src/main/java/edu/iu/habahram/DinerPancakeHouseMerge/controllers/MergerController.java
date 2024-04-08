package edu.iu.habahram.DinerPancakeHouseMerge.controllers;




import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVeg(){
        List<MenuItemRecord> items = mergerRepository.getVeg();
        return items;
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfast(){
        List<MenuItemRecord> items = mergerRepository.getBreakfast();
        return items;
    }


    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunch(){
        List<MenuItemRecord> items = mergerRepository.getLunch();
        return items;
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getSupper(){
        List<MenuItemRecord> items = mergerRepository.getSupper();
        return items;
    }

    @GetMapping("/signup")
    public List signup(@RequestBody String username, @RequestBody String password){
        return null;
    }


}