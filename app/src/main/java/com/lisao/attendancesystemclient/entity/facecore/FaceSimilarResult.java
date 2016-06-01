package com.lisao.attendancesystemclient.entity.facecore;

import java.util.List;

/**
 * Created by lisao on 2016/5/30.
 */
public class FaceSimilarResult {
    private List<SimilarResult> similarpersonface;

    public List<SimilarResult>  getSimilarpersonface() {
        return similarpersonface;
    }

    public void setSimilarpersonface(List<SimilarResult>  similarpersonface) {
        this.similarpersonface = similarpersonface;
    }
}


