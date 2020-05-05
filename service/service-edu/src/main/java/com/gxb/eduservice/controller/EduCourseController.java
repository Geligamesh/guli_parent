package com.gxb.eduservice.controller;


import com.gxb.commonutils.R;
import com.gxb.eduservice.entity.vo.CourseInfoVo;
import com.gxb.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author Geligamesh
 * @since 2020-05-04
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        String courseId = eduCourseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId",courseId);
    }
}

