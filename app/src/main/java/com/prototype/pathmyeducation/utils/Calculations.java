package com.prototype.pathmyeducation.utils;

import java.math.BigDecimal;

/**
 * Created by Chris on 28/01/2017.
 */

public class Calculations {

    private static final double[][] CORNERS = {
            {52.939470, -1.496370},
            {52.938808, -1.498100},
            {52.937718, -1.495694},
            {52.938706, -1.494589}
    };

    /**
     *
     * @param longitude
     * @param latitude
     * @return
     */
        public static BigDecimal[] detectOffset(double longitude, double latitude) {
        BigDecimal[] result = new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ZERO};
        double closestLong = 1, closestLat = 1; // Detect distance from closest points
        double closestLong2 = 1, closestLat2 = 2; // Detect second closest point.

        int i = 0;
        for (i = 0; i < 4; i++) {
            if ((longitude - CORNERS[i][0]) < closestLong) closestLong = CORNERS[i][0];
            if ((latitude - CORNERS[i][1]) < closestLat) closestLat = CORNERS[i][1];
        }

        i = 0;
        for (i = 0; i < 4; i++) {
            if (CORNERS[i][0] == closestLong) continue;
            if ((longitude - CORNERS[i][0]) < closestLong2) closestLong2 = CORNERS[i][0];

            if (CORNERS[i][1] == closestLat) continue;
            if ((latitude - CORNERS[i][1]) < closestLat2) closestLat2 = CORNERS[i][1];
        }

        result[0] = BigDecimal.valueOf(closestLong).subtract(BigDecimal.valueOf(closestLong2));
        result[1] = BigDecimal.valueOf(closestLat).subtract(BigDecimal.valueOf(closestLat2));

        return result;
    }
}
