package com.amchis.officewebsite.base.request;

import lombok.Data;

@Data
public class ContentPageQuery extends QueryPageRequest {

    private String type;

    private String firstPage;

    private String secondPage;

}