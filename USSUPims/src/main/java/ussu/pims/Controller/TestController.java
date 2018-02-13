/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import java.security.Principal;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danielroy
 */
@RestController
public class TestController {

    @RequestMapping(value="item/{itemID}/test", method = RequestMethod.PUT)
    public ResponseEntity<Object> testItem(@PathVariable String itemID, @RequestParam String barcode, @RequestParam Optional<String> earthResistanceOhms, @RequestParam Optional<String> insulationResistanceMOhms, Principal principal) {
        // Call test function in test service
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
