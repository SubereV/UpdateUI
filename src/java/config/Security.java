/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author kinvo
 */
import Entity.Roles;

public class Security {

    public static final String adminRole = "ADMINSTRATOR";
    public static final String userRole = "USER";

    private static Map<String, List<String>> mapComfig = new HashMap();

    static {
        init();
    }

    private static void init() {
        //Danh sách các trang user có thể truy cập:
        List<String> userAcess = new ArrayList<String>();
        userAcess.add("/home");
        mapComfig.put(userRole, userAcess);

        //Danh sách các trang admin có thể truy cập:
        List<String> adminAcess = new ArrayList<>();
        adminAcess.add("");
        mapComfig.put(adminRole, adminAcess);
    }

    public Set<String> getAllRoles() {
        return mapComfig.keySet();
    }
    
    public List<String> getUrlPatternsForRole(String role){
        return mapComfig.get(role);
    }

}
