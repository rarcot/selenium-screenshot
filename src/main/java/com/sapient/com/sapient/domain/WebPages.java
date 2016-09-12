package com.sapient.com.sapient.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rarcot on 8/31/2016.
 */
public class WebPages implements Serializable {

    private static final long serialVersionUID = -1659862226674106370L;

    private String driver;

    private List<PageSnapshotAttributes> pages;

    public List<PageSnapshotAttributes> getPages() {
        return pages;
    }

    public void setPages(List<PageSnapshotAttributes> pages) {
        this.pages = pages;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
