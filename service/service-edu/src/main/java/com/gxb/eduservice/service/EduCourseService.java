package com.gxb.eduservice.service;

import com.gxb.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gxb.eduservice.entity.vo.CourseInfoVo;

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
}
