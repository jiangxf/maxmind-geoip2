/*
 * Copyright (c) Steven P. Goldsmith. All rights reserved.
 *
 * Created by Steven P. Goldsmith on January 28, 2016
 * sgoldsmith@codeferm.com
 */
package com.codeferm.maxmind.geoip2;

import com.maxmind.db.CHMCache;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple DTO.
 *
 * @author sgoldsmith
 * @version 1.0.0
 * @since 1.0.0
 */
public class CityDatabase {

    /**
     * Logger.
     */
    private static final Logger log = LoggerFactory.
            getLogger(CityDatabase.class);
    /**
     * Maxmind database reader.
     */
    private DatabaseReader databaseReader;

    /**
     * Maxmind city database name.
     */
    private String fileName;

    /**
     * Default constructor.
     */
    public CityDatabase() {
        super();
    }

    /**
     * Default constructor.
     */
    public CityDatabase(final String fileName) throws IOException {
        log.debug(String.format("Opening city database %s", fileName));
        this.fileName = fileName;
        // Use built in caching implementation
        databaseReader = new DatabaseReader.Builder(new File(fileName)).
                withCache(new CHMCache()).build();
    }

    public final CityResponse getCityResponse(final String ipAddr) throws
            IOException, GeoIp2Exception {
        log.debug(String.format("City response for %s", ipAddr));
        final InetAddress inetAddress = InetAddress.getByName("ipAddr");
        return databaseReader.city(inetAddress);
    }
}
