package com.gxb.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gxb.eduservice.entity.EduSubject;
import com.gxb.eduservice.entity.excel.SubjectData;
import com.gxb.eduservice.service.EduSubjectService;
import com.gxb.servicebase.exceptionhandler.GuliException;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    private EduSubjectService eduSubjectService;

    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    public SubjectExcelListener() {
    }

    /**
     * 读取内容，一行一行进行读取
     * @param subjectData
     * @param analysisContext
     */
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData == null) {
            throw new GuliException(20001,"文件数据为空");
        }
        EduSubject eduOneSubject = this.existOneSubject(eduSubjectService, subjectData.getOneSubjectName());
        if (eduOneSubject == null) {
            eduOneSubject = new EduSubject();
            eduOneSubject.setTitle(subjectData.getOneSubjectName());
            eduOneSubject.setParentId("0");
            eduSubjectService.save(eduOneSubject);
        }
        String pid = eduOneSubject.getId();
        EduSubject eduTwoSubject = this.existTwoSubject(eduSubjectService, subjectData.getTwoSubjectName(), pid);
        if (eduTwoSubject == null) {
            eduTwoSubject = new EduSubject();
            eduTwoSubject.setTitle(subjectData.getTwoSubjectName());
            eduTwoSubject.setParentId(pid);
            eduSubjectService.save(eduTwoSubject);
        }
    }

    /**
     * 判断一级分类不能重复添加
     * @param eduSubjectService
     * @param name
     * @return
     */
    private EduSubject existOneSubject(EduSubjectService eduSubjectService,String name) {
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id","0");
        return eduSubjectService.getOne(queryWrapper);
    }

    private EduSubject existTwoSubject(EduSubjectService eduSubjectService,String name,String pid) {
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id",pid);
        return eduSubjectService.getOne(queryWrapper);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
