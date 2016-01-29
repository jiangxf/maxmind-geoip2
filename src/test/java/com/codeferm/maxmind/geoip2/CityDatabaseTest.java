/*
 * Copyright (c) Steven P. Goldsmith. All rights reserved.
 *
 * Created by Steven P. Goldsmith on January 28, 2016
 * sgoldsmith@codeferm.com
 */
package com.codeferm.maxmind.geoip2;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test city database.
 *
 * @author sgoldsmith
 * @version 1.0.0
 * @since 1.0.0
 */
public class CityDatabaseTest {

    /**
     * Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(
            CityDatabaseTest.class);

    /**
     * Test city database.
     */
    @Test
    public final void cityDatabase() throws IOException, GeoIp2Exception {
        log.info("cityDatabase");
        CityDatabase cityDatabase = new CityDatabase(
                "src/test/resources/GeoLite2-City.mmdb");
        CityResponse cityResponse = cityDatabase.getCityResponse(
                "173.194.207.100");
        assertEquals("United States", cityResponse.getCountry().getName());
        log.debug(cityResponse.getCountry().getName());
    }
}
