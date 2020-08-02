package com.gxb.eduservice.service;

import com.gxb.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gxb.eduservice.entity.vo.CourseInfoVo;
import com.gxb.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Geligamesh
 * @since 2020-05-04
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    //删除课程
    void removeCourse(String courseId);
}
