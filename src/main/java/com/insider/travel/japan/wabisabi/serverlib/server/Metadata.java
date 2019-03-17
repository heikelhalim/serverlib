package com.insider.travel.japan.wabisabi.serverlib.server;

import javax.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Get metadata of the server (instances) and preserve it
 *
 * @see
 * <a href="http://docs.aws.amazon.com/ja_jp/AWSEC2/latest/UserGuide/AESDG-chapter-instancedata.html">インスタンスメタデータとユーザーデータ
 * - Amazon Elastic Compute Cloud</a>
 */
@ApplicationScoped
public class Metadata {

    private static final Logger LOG = LoggerFactory.getLogger(Metadata.class);

    private final String publicDns = MetadataProperties.PUBLIC_DNS.get();
    private final String privateDns = MetadataProperties.PRIVATE_DNS.get();
    private final String availabilityZone = MetadataProperties.AZ.get();

    private static final Metadata INSTANCE = new Metadata();

    //Constructor
    public Metadata() {
        LOG.info("The server's metadata has been initialized, publicDNS:[{}], privateDNS:[{}], availability-zone:[{}]", publicDns, privateDns, availabilityZone);
    }

    public static Metadata getInstance() {
        return INSTANCE;
    }

    public String getPublicDns() {
        return publicDns;
    }

    public String getPrivateDns() {
        return privateDns;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

}
