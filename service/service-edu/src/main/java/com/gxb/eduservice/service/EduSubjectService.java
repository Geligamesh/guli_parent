package com.gxb.eduservice.service;

import com.gxb.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gxb.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author Geligamesh
 * @since 2020-05-04
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);

    List<OneSubject> getAllOneTwoSubject();
}
