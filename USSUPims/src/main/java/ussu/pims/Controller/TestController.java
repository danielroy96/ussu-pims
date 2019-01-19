/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ussu.pims.Service.ItemService;
import ussu.pims.Service.TestService;

import java.util.HashMap;

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
    public HashMap<String, String> testItem(@RequestParam String testOperator, @PathVariable String barcode, @RequestParam String earthResistanceOhms, @RequestParam String insulationResistanceMOhms) {
        Float earthResistanceOhmsLocal = null;
        if (!"null".equals(earthResistanceOhms)) {
            earthResistanceOhmsLocal = Float.parseFloat(earthResistanceOhms);
        }
        Float insulationResistanceMOhmsLocal = null;
        if (!"null".equals(insulationResistanceMOhms)) {
            insulationResistanceMOhmsLocal = Float.parseFloat(insulationResistanceMOhms);
        }
        int testId = testService.testItem(itemService.getItemId(barcode), earthResistanceOhmsLocal, insulationResistanceMOhmsLocal, Integer.parseInt(testOperator));
        HashMap<String, String> returnStrings = new HashMap<>();
        returnStrings.put("itemTypeName", itemService.getItem(barcode).getItemTypeName());
        returnStrings.put("testId", String.valueOf(testId));
        return returnStrings;
    }

    @RequestMapping(value = "/test/{id}/undo", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void undoTest(@PathVariable String id) {
        testService.undoTest(Integer.parseInt(id));
    }

}
