package vamk.fi.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vamk.fi.demo.model.License;
import vamk.fi.demo.repository.LicenseRepository;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController     //we tell to spring that these are class controller
@RequestMapping("/api/license")     //specify the directory of local host
public class LicenseController {
    private LicenseRepository licenseRepository;        //initialize the repository


    @Autowired      //notation to connect classes by the spring boot system
    public LicenseController(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }


    @GetMapping     //for GET method
    public List<License> getAllLicenses() {
        return licenseRepository.findAll();
    }

    @GetMapping( path = "{id}")     //search by ID method
    public License findById (@PathVariable("id")int id) {       //PathVariable is to tell SpringBoot that path variable must be assigned to the argument ID
        return licenseRepository.findById(id).orElse(null);     //orElse(null) in order not to receive error when ID is not valid
    } 

    @PostMapping    //for POST method
    public License insertLicense(@RequestBody License licenseNew) {         //initialize new object through the request body
        Date newDate = new Date(Calendar.getInstance().getTime().getTime());        //create a current date into Date formart
     
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");     //specify the date format  
        String dati = df.format(newDate);                       //convert Date format into String format
        licenseNew.setQueriedAt(dati);                          //set our date into our object
        return licenseRepository.save(licenseNew);              //return created object into repository
    }

    @PutMapping(path ="{id}")       //for PUT method (for update)
    public int modifyLicense(@RequestBody License license ,@PathVariable("id") int id) {
        return licenseRepository.modifyLicenseById(license.getName(),id);
    }


    @DeleteMapping(path ="{id}")
    public int deleteById (@PathVariable("id") int id ) {   //made as not void in order to get the response
        licenseRepository.deleteById(id);
         return 1;
    }

}
