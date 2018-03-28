/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ussu.pims.Model.Event;
import ussu.pims.Model.TestEvent;
import ussu.pims.Service.ItemEventService;
import ussu.pims.Service.ItemService;

/**
 *
 * @author danielroy
 */
@RestController
public class ItemEventController {
    
    @Autowired
    private ItemEventService itemEventService;
    
    @Autowired
    private ItemService itemService;
    
    @RequestMapping(value="/item/{itemBarcode}/event/test", method=RequestMethod.GET)
    public List<TestEvent> getTestEvents (@PathVariable String itemBarcode) {
        return itemEventService.getTestEvents(itemService.getItemId(itemBarcode));
    }
    
    @RequestMapping(value="/item/{itemBarcode}/event/maintenance", method=RequestMethod.GET)
    public List<Event> getMaintenanceEvents (@PathVariable String itemBarcode) {
        return null;
    }
    
}
