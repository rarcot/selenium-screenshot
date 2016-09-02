package com.sapient.com.sapient.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rarcot on 8/31/2016.
 */
public class PageSnapshotAttributes implements Serializable {


    private static final long serialVersionUID = -1678082958770306609L;

    private String url;

    private String size;

    private String ssFileName;

    private String ssDirectoryName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSsFileName() {
        return ssFileName;
    }

    public void setSsFileName(String ssFileName) {
        this.ssFileName = ssFileName;
    }

    public String getSsDirectoryName() {
        return ssDirectoryName;
    }

    public void setSsDirectoryName(String ssDirectoryName) {
        this.ssDirectoryName = ssDirectoryName;
    }
}
