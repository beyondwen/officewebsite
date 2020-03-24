package com.amchis.officewebsite.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.*;

/**
 * @author beyond
 * Create at 2020-03-23 10:13
 */
@Entity
@Table(name = "image_upload")
@Data
@ApiModel
public class ImageUpload {


    /**
     * id
     */
    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     *图片途径
     */
    @ApiModelProperty("图片途径")
    @Column(name = "image_url")
    private String imageUrl;
}