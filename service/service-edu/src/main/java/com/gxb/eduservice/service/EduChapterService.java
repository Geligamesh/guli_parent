package com.gxb.eduservice.service;

import com.gxb.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gxb.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Geligamesh
 * @since 2020-05-04
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    boolean deleteChapter(String chapterId);
}
