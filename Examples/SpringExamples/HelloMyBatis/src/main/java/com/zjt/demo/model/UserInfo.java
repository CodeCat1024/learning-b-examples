package com.zjt.demo.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 *  普通实体类
 */
@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private int state;
    private List<ArticleInfo> articleInfoList;
}
