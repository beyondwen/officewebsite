package com.amchis.officewebsite.base.request;

import lombok.Data;

@Data
public class PageQuery extends QueryPageRequest {

    private String title;

    private String endTime;

    private String startTime;

    private String source;

    private Integer articleCategory;
}
