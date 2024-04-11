package cn.autumnclouds.sgms.core.ui.menu.impl;

import cn.autumnclouds.sgms.core.Sgms;
import cn.autumnclouds.sgms.core.ui.menu.Menu;
import cn.autumnclouds.sgms.model.entity.Course;
import cn.autumnclouds.sgms.model.entity.TeachingClass;
import cn.autumnclouds.sgms.model.vo.GradeVo;
import cn.autumnclouds.sgms.model.vo.TeachingClassVo;
import cn.autumnclouds.sgms.service.GradeService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Fu Qiujie
 * @since 2024/4/8
 */
public class TeachingClassQueryMenu extends Menu {
    public TeachingClassQueryMenu(Menu prevMenu) {
        super(prevMenu);
    }

    @Override
    public void onShow() {
        System.out.println("1. 查询所有教学班");
        System.out.println("2. 按课程名查询教学班");
        System.out.println("3. 按教学班号查询教学班详细信息");
        System.out.println("4. 返回");
    }

    @Override
    public Menu onInput(String input, Sgms sgms) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case "1": {
                sgms.teachingClassService.list().stream().map(sgms.teachingClassService::packageTeachingClass).forEach(System.out::println);
                return this;
            }
            case "2": {
                System.out.println("请输入课程名");
                String courseName = scanner.nextLine();
                sgms.courseService.lambdaQuery().eq(Course::getName, courseName).list()
                        .forEach(course -> sgms.teachingClassService.lambdaQuery().eq(TeachingClass::getCourseId, course.getId())
                                .list().stream().map(sgms.teachingClassService::packageTeachingClass).forEach(System.out::println));
                return this;
            }
            case "3": {
                System.out.println("请输入教学班号");
                long teachingClassId = scanner.nextLong();
                System.out.println("请选择排序方式：");
                System.out.println("1. 按学号排序");
                System.out.println("2. 按成绩排序");
                int sort = scanner.nextInt();
                TeachingClassVo teachingClassVo = sgms.teachingClassService.packageTeachingClass(sgms.teachingClassService.getById(teachingClassId));
                List<GradeVo> gradeVos = sgms.gradeService.listGradeVoByTeachingClassId(teachingClassId);
                System.out.println(teachingClassVo);
                System.out.println("学生信息：");
                if (sort == 1) {
                    gradeVos.stream().sorted(Comparator.comparing(GradeVo::getStudentId)).forEach(System.out::println);
                } else {
                    gradeVos.stream().sorted(Comparator.comparing(GradeVo::getTotalScore).reversed()).forEach(System.out::println);
                }
                System.out.println(GradeService.tallyingGrades(gradeVos));
                return this;
            }
            case "4": {
                return prevMenu;
            }
            default: {
                return this;
            }
        }
    }
}
