/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ussu.pims.Model.Item;
import ussu.pims.Service.ItemService;
import ussu.pims.Service.TestService;

/**
 *
 * @author danielroy
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/{barcode}/test", method = RequestMethod.PUT)
    public Item testItem(@RequestParam String testOperator, @PathVariable String barcode, @RequestParam String earthResistanceOhms, @RequestParam String insulationResistanceMOhms) {
        Float earthResistanceOhmsLocal = null;
        if (!"null".equals(earthResistanceOhms)) {
            earthResistanceOhmsLocal = Float.parseFloat(earthResistanceOhms);
        }
        Float insulationResistanceMOhmsLocal = null;
        if (!"null".equals(insulationResistanceMOhms)) {
            insulationResistanceMOhmsLocal = Float.parseFloat(insulationResistanceMOhms);
        }
        testService.testItem(itemService.getItemId(barcode), earthResistanceOhmsLocal, insulationResistanceMOhmsLocal, Integer.parseInt(testOperator));
        return itemService.getItem(barcode);
    }

    /*@RequestMapping(value="/item/{barcode}/test", method = RequestMethod.PUT)
    public ResponseEntity<Object> testItem(@RequestParam String testOperator, @PathVariable String barcode) {
        testService.testItem(itemService.getItemId(barcode), Integer.parseInt(testOperator));
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
