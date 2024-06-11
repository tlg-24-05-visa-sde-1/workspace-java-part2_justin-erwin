/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {

    // prevent direct instantiation - this is an all-static factory class
    private EmployeeFactory() {
    }

    /**
     * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
     */
    public static Employee createEmployee(Map<String,String> inputMap) throws IllegalArgumentException {
        // return value
        Employee emp = null;
        //FIRST, extract the 'indicator' from the Map, i.e., "HE" or "SE"
        String inputType = inputMap.get("type");

        if(!"HE".equals(inputType) && !"SE".equals(inputType)) {  //if not "HE" or "SE", throw excpetion
            throw new IllegalArgumentException("Invalid type: " + inputType + "Valid types are HE or SE");
        }

        String name = inputMap.get("name");    //name and hireDate are shared by HE and SE ctors
        Date hireDate = Date.valueOf(inputMap.get("hireDate"));

        if("HE".equals(inputType)){
            Double rate = Double.valueOf(inputMap.get("rate"));    //convert to proper types for ctor
            Double hours = Double.valueOf(inputMap.get("hours"));

            emp = new HourlyEmployee(name, hireDate, rate, hours);  //create SalariedEmployee with ctor
        }
        else if("SE".equals(inputType)){

            Double salary = Double.valueOf(inputMap.get("salary"));   //convert to proper types for ctor

            emp = new SalariedEmployee(name, hireDate, salary);  //create SalariedEmployee with ctor
        }
        return emp;
    }
}