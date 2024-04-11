package cn.autumnclouds.sgms.core.ui.menu.impl;

import cn.autumnclouds.sgms.core.Sgms;
import cn.autumnclouds.sgms.core.ui.menu.Menu;
import cn.autumnclouds.sgms.model.entity.Student;
import cn.autumnclouds.sgms.model.vo.StudentVo;

import java.util.List;
import java.util.Scanner;

/**
 * @author Fu Qiujie
 * @since 2024/4/6
 */
public class StudentQueryMenu extends Menu {
    public StudentQueryMenu(Menu prevMenu) {
        super(prevMenu);
    }

    @Override
    public void onShow() {
        System.out.println("1. 查询所有学生");
        System.out.println("2. 按姓名模糊查询学生");
        System.out.println("3. 按学号查询学生详细信息");
        System.out.println("4. 返回");
    }

    @Override
    public Menu onInput(String input, Sgms sgms) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case "1": {
                List<Student> students = sgms.studentService.list();
                for (Student student : students) {
                    System.out.println(student);
                }
                return this;
            }
            case "2": {
                System.out.println("请输入姓名");
                String studentName = scanner.nextLine();
                List<Student> students = sgms.studentService.lambdaQuery().like(Student::getName, studentName).list();
                for (Student student : students) {
                    System.out.println(student);
                }
                return this;
            }
            case "3": {
                System.out.println("请输入学号");
                long studentId = scanner.nextLong();
                StudentVo studentVo = sgms.studentService.getStudentVo(studentId);
                System.out.println(studentVo);
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
