package com.gxb.eduservice.controller;

import com.gxb.commonutils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin  //解决跨域
public class EduLoginController {

    //login
    @PostMapping("login")
    public R login() {
        return R.ok().data("token","admin");
    }
    //info
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://my-images-bed.oss-cn-hangzhou.aliyuncs.com/images/微信图片_20191029192644.jpg");
    }
}
