package com.amchis.officewebsite.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author beyond
 * Create at 2020-04-21 14:08
 */
@Entity
@Table(name = "banner")
@Data
@ApiModel
public class Banner {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 一级页面
     */
    @ApiModelProperty("一级页面")
    @Column(name = "first_page", nullable = false)
    private String firstPage;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    @Column(name = "create_username")
    private String createUsername;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @Column(name = "update_time")
    private String updateTime;
}