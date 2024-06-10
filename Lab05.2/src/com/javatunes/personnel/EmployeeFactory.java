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
     * TODO: given the input map, create and return the correct object (with its properties set).
     * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
     */
    public static Employee createEmployee(Map<String,String> inputMap) throws IllegalArgumentException {
        // return value
        Employee emp = null;
        String inputType = inputMap.get("type");
        if("HE".equals(inputType)){
            String name = inputMap.get("name");  //convert to proper types
            Date hireDate = Date.valueOf(inputMap.get("hireDate"));
            Double rate = Double.valueOf(inputMap.get("rate"));
            Double hours = Double.valueOf(inputMap.get("hours"));

            emp = new HourlyEmployee(name, hireDate, rate, hours);  //create SalariedEmployee with ctor
        }
        else if("SE".equals(inputType)){
            String name = inputMap.get("name");   //convert to proper types
            Date hireDate = Date.valueOf(inputMap.get("hireDate"));
            Double salary = Double.valueOf(inputMap.get("salary"));

            emp = new SalariedEmployee(name, hireDate, salary);  //create SalariedEmployee with ctor
        }
        else {
            throw new IllegalArgumentException("type must be HE or SE");
        }
        return emp;
    }
}