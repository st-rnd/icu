/*****************************************************************************************
 * $Source: /xsrl/Nsvn/icu/icu4j/src/com/ibm/icu/dev/test/format/IntlTestDecimalFormatSymbols.java,v $ 
 * $Date: 2003/05/14 19:03:16 $ 
 * $Revision: 1.5 $
 *
 *****************************************************************************************
 **/

/** 
 * Port From:   JDK 1.4b1 : java.text.Format.IntlTestDecimalFormatSymbols
 * Source File: java/text/format/IntlTestDecimalFormatSymbols.java
 **/
 
/*
    @test 1.4 98/03/06
    @summary test International Decimal Format Symbols
*/
/***************************************************************************
*
*   Copyright (C) 1996-2002, International Business Machines
*   Corporation and others.  All Rights Reserved.
*
************************************************************************/


package com.ibm.icu.dev.test.format;

import com.ibm.icu.text.*;
import java.util.Locale;

public class IntlTestDecimalFormatSymbols extends com.ibm.icu.dev.test.TestFmwk
{
    public static void main(String[] args) throws Exception {
        new IntlTestDecimalFormatSymbols().run(args);
    }

    // Test the API of DecimalFormatSymbols; primarily a simple get/set set.
    public void TestSymbols()
    {
        DecimalFormatSymbols fr = new DecimalFormatSymbols(Locale.FRENCH);

        DecimalFormatSymbols en = new DecimalFormatSymbols(Locale.ENGLISH);

        if(en.equals(fr)) {
            errln("ERROR: English DecimalFormatSymbols equal to French");
        }

        // just do some VERY basic tests to make sure that get/set work

        char zero = en.getZeroDigit();
        fr.setZeroDigit(zero);
        if(fr.getZeroDigit() != en.getZeroDigit()) {
            errln("ERROR: get/set ZeroDigit failed");
        }

        char group = en.getGroupingSeparator();
        fr.setGroupingSeparator(group);
        if(fr.getGroupingSeparator() != en.getGroupingSeparator()) {
            errln("ERROR: get/set GroupingSeparator failed");
        }

        char decimal = en.getDecimalSeparator();
        fr.setDecimalSeparator(decimal);
        if(fr.getDecimalSeparator() != en.getDecimalSeparator()) {
            errln("ERROR: get/set DecimalSeparator failed");
        }

        char perMill = en.getPerMill();
        fr.setPerMill(perMill);
        if(fr.getPerMill() != en.getPerMill()) {
            errln("ERROR: get/set PerMill failed");
        }

        char percent = en.getPercent();
        fr.setPercent(percent);
        if(fr.getPercent() != en.getPercent()) {
            errln("ERROR: get/set Percent failed");
        }

        char digit = en.getDigit();
        fr.setDigit(digit);
        if(fr.getPercent() != en.getPercent()) {
            errln("ERROR: get/set Percent failed");
        }

        char patternSeparator = en.getPatternSeparator();
        fr.setPatternSeparator(patternSeparator);
        if(fr.getPatternSeparator() != en.getPatternSeparator()) {
            errln("ERROR: get/set PatternSeparator failed");
        }

        String infinity = en.getInfinity();
        fr.setInfinity(infinity);
        String infinity2 = fr.getInfinity();
        if(! infinity.equals(infinity2)) {
            errln("ERROR: get/set Infinity failed");
        }

        String nan = en.getNaN();
        fr.setNaN(nan);
        String nan2 = fr.getNaN();
        if(! nan.equals(nan2)) {
            errln("ERROR: get/set NaN failed");
        }

        char minusSign = en.getMinusSign();
        fr.setMinusSign(minusSign);
        if(fr.getMinusSign() != en.getMinusSign()) {
            errln("ERROR: get/set MinusSign failed");
        }

//        char exponential = en.getExponentialSymbol();
//        fr.setExponentialSymbol(exponential);
//        if(fr.getExponentialSymbol() != en.getExponentialSymbol()) {
//            errln("ERROR: get/set Exponential failed");
//        }

        //DecimalFormatSymbols foo = new DecimalFormatSymbols(); //The variable is never used

        en = (DecimalFormatSymbols) fr.clone();

        if(! en.equals(fr)) {
            errln("ERROR: Clone failed");
        }
    }
}
