/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussu.pims.Controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ussu.pims.Model.ChartDataPoint;
import ussu.pims.Service.DashboardService;
import ussu.pims.Service.UserService;

/**
 *
 * @author danielroy
 */
@RestController
public class DashboardRestController {
    
    @Autowired
    private DashboardService dashboardService;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="dashboard/chart/test7days", method=RequestMethod.GET)
    public List<ChartDataPoint> getAllTests7Days(Principal principal) {
        return dashboardService.getAllTests7Days(userService.getUserID(principal));
    }
    
    @RequestMapping(value="dashboard/chart/test14days", method = RequestMethod.GET)
    public List<ChartDataPoint> getAllTests14Days(Principal principal) {
        return dashboardService.getAllTests14Days(userService.getUserID(principal));
    }
    
    @RequestMapping(value="dashboard/chart/test1year", method = RequestMethod.GET)
    public List<ChartDataPoint> getAllTests1Year(Principal principal) {
        return dashboardService.getAllTests1Year(userService.getUserID(principal));
    }
    
}
