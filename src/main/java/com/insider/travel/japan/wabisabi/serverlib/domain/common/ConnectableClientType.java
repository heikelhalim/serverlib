package com.insider.travel.japan.wabisabi.serverlib.domain.common;

/**
 *
 * Connectable client
 */
public enum ConnectableClientType {

    JTI_BROWSER("jti_browser");

    private final String type;

    private ConnectableClientType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
