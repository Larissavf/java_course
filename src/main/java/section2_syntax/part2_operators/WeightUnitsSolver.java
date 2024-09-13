/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section2_syntax.part2_operators;

public class WeightUnitsSolver {

    /**
     * Returns the number of Pounds, Ounces and Grams represented by this quantity of grams,
     * encapsulated in a BritishWeightUnits object.
     * @param grams the grams quantity
     * @return a BritishWeightUnits instance
     * @throws IllegalArgumentException when the Grams quantity is 
     */
    public BritishWeightUnits convertFromGrams(int grams) {
        //YOUR CODE HERE
        //change this variable to get a correct testing condition
        final int gramsTest = 0;

        if (grams <= gramsTest) {
            throw new IllegalArgumentException("Error: grams should be above 0. Given: grams=" + grams);
        }

        //solve the pounds, ounces and grams, create and return a BritishWeightUnits instance
        //YOUR CODE HERE
        //A pound is 454 grams and an ounce is 28 grams
        if (grams % 454 != grams) {

        }

        int pound = grams / 454;
        if (pound > 0){ grams =- (grams % 454);}
        int ounces = grams / 28;
        if (ounces > 0) {grams =- (grams % 28);}
        return new BritishWeightUnits(pound, ounces, grams);
    }
}
