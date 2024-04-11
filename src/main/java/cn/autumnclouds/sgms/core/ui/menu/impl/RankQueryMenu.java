package cn.autumnclouds.sgms.core.ui.menu.impl;

import cn.autumnclouds.sgms.core.Sgms;
import cn.autumnclouds.sgms.core.ui.menu.Menu;
import cn.autumnclouds.sgms.model.entity.Grade;
import cn.autumnclouds.sgms.model.entity.Student;
import cn.autumnclouds.sgms.model.entity.TeachingClass;
import cn.autumnclouds.sgms.service.GradeService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Fu Qiujie
 * @since 2024/4/8
 */
public class RankQueryMenu extends Menu {
    public RankQueryMenu(QueryMenu queryMenu) {
        super(queryMenu);
    }

    @Override
    public void onShow() {
        System.out.println("1. 查询所有学生排名");
        System.out.println("2. 查询某课程所有学生排名");
        System.out.println("3. 返回");
    }

    @Override
    public Menu onInput(String input, Sgms sgms) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case "1": {
                List<Map.Entry<Long, Double>> list = new ArrayList<>(sgms.gradeService.list().stream().collect(Collectors.groupingBy(Grade::getStudentId, Collectors.averagingDouble(GradeService::calculateTotalScore))).
                        entrySet().stream().toList());
                list.sort((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(STR."\{i + 1}  \{sgms.studentService.getById(list.get(i).getKey()).getName()} \{list.get(i).getValue()}");
                }
                return this;
            }
            case "2": {
                System.out.println("请输入课程号");
                long courseId = scanner.nextLong();
                List<Long> teachingClassIds = sgms.teachingClassService.lambdaQuery().eq(TeachingClass::getCourseId, courseId).list().stream().map(TeachingClass::getId).toList();
                List<Grade> gradeList = sgms.gradeService.lambdaQuery().in(Grade::getTeachingClassId, teachingClassIds).list();
                gradeList.sort(Comparator.comparing(GradeService::calculateTotalScore).reversed());
                for (int i = 0; i < gradeList.size(); i++) {
                    System.out.println(STR."\{i + 1}  \{sgms.studentService.getById(gradeList.get(i).getStudentId()).getName()} \{GradeService.calculateTotalScore(gradeList.get(i))}");
                }
            }
            case "3": {
                return prevMenu;
            }
            default: {
                return this;
            }
        }
    }
}
