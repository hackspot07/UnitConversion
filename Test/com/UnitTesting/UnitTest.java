package com.UnitTesting;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnitTest {

        @Test
        public void test1FeetEqualTo12inch(){
            Unit unit1 = new Unit(UnitName.FEET,1.0);
            Unit  unit2 = new Unit(UnitName.INCH,12.0);
            assertTrue(unit1.equals(unit2));
        }
        @Test
        public void test1feetisNotEqualTo13inch(){
            Unit unit1 = new Unit(UnitName.FEET,1.0);
            Unit  unit2 = new Unit(UnitName.INCH,13.0);
            assertFalse(unit1.equals(unit2));
        }

        @Test
        public void test1InchEqualTO1Inch(){
            Unit unit1 = new Unit(UnitName.INCH,1.0);
            Unit  unit2 = new Unit(UnitName.INCH,1.0);
            assertTrue(unit1.equals(unit2));
        }
        @Test
        public void test2InchEqualTO5Centemeter(){
            Unit unit1 = new Unit(UnitName.CENTIMETER,5.0);
            Unit  unit2 = new Unit(UnitName.INCH,2.0);
            assertTrue(unit1.equals(unit2));
        }

        @Test
        public void test1meterEquals100Centimeter(){
            Unit unit1 = new Unit(UnitName.METER,1);
            Unit  unit2 = new Unit(UnitName.CENTIMETER,100);
            assertTrue(unit1.equals(unit2));
        }
        @Test
        public void test1GallonEquals3point78Litre(){
            Unit unit1 = new Unit(UnitName.GALLON,1);
            Unit  unit2 = new Unit(UnitName.LITRE,3.78);
            assertTrue(unit1.equals(unit2));
        }
        @Test
        public  void test1GallonNotEqual3Litre(){
            Unit unit1 = new Unit(UnitName.GALLON,1);
            Unit  unit2 = new Unit(UnitName.LITRE,3.0);
            assertFalse(unit1.equals(unit2));
        }
        @Test
        public  void test1GallonNotEqual3InchThrowException(){
            Unit unit1 = new Unit(UnitName.GALLON,1);
            Unit  unit2 = new Unit(UnitName.INCH,3.0);
            assertFalse(unit1.equals(unit2));
        }
}