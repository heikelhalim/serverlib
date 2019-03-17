package com.insider.travel.japan.wabisabi.serverlib.server;

/**
 *
 * Handling class for metadata properties
 */
public final class MetadataProperties {

    //Public DNS
    public static final MetadataProperty<String> PUBLIC_DNS = new MetadataProperty<>(fromSystemProperty("jti.server.metadata.dns.public"), "localhost:8080");

    //Private DNS
    public static final MetadataProperty<String> PRIVATE_DNS = new MetadataProperty<>(fromSystemProperty("jti.server.metadata.dns.private"), "localhost");

    //Availability zone
    public static final MetadataProperty<String> AZ = new MetadataProperty<>(fromSystemProperty("jti.server.metadata.az"), "ap-sisco-local");

    private MetadataProperties() {
    }

    private static String fromSystemProperty(String key) {
        return System.getProperty(key);
    }

}
