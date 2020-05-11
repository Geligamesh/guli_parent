package com.gxb.eduservice.entity.chapter;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ChapterVo {

    private String id;
    private String title;
    private List<VideoVo> children = new ArrayList<>();
}
