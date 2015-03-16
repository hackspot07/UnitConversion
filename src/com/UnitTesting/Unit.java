package com.UnitTesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


interface Convertable<E>{
    public double convert(E element);
}


public class Unit{
    private static final Map<UnitName, Double> unitTable = new HashMap<UnitName, Double>();
    private static final List<UnitName> length = new ArrayList<UnitName>();
    private static final List<UnitName> density = new ArrayList<UnitName>();
    private UnitName unit;
    private  double value;
    private static double PRECISION = 0.01;

    public Unit(UnitName unit, double value) {
        this.unit = unit;
        this.value = value;
    }
    static {
        unitTable.put(UnitName.FEET,12.0);
        unitTable.put(UnitName.INCH,1.0);
        unitTable.put(UnitName.METER,40.00);
        unitTable.put(UnitName.CENTIMETER,0.4);
        unitTable.put(UnitName.LITRE , 1.0);
        unitTable.put(UnitName.GALLON , 3.78);
        length.add(UnitName.FEET);
        length.add(UnitName.INCH);
        length.add(UnitName.METER);
        length.add(UnitName.CENTIMETER);
        density.add(UnitName.GALLON);
        density.add(UnitName.LITRE);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Unit)) return false;

        Unit type = (Unit) o;
        double result = 0;
        try {
            result = convert(type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        if ( result < PRECISION) return true;
        return false;
    }

    private double convertUnit(Unit type){
        double value1 = unitTable.get(type.unit)*type.value;
        double value2 = unitTable.get(unit)*value;
        return Math.abs(value1 - value2);
    }
    private double convert(Unit type) throws Exception {
        boolean isLengthElement = length.contains(type.unit) && length.contains(unit);
        boolean isDensityElement = density.contains(type.unit)&& density.contains(unit);
        double result = 1.0;
        if(isDensityElement || isLengthElement){
           result = convertUnit(type);
        }else{
            throw new Exception("Units Are Differnt type");
        }
        return result;
    }
}
