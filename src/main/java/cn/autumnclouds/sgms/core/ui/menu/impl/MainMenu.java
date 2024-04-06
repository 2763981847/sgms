package cn.autumnclouds.sgms.core.ui.menu.impl;

import cn.autumnclouds.sgms.core.Sgms;
import cn.autumnclouds.sgms.core.ui.menu.Menu;

import java.util.Scanner;

/**
 * @author Fu Qiujie
 * @since 2024/4/6
 */
public class MainMenu extends Menu {
    public MainMenu(Menu prevMenu) {
        super(prevMenu);
    }

    @Override
    public void onShow() {
        System.out.println("1. 初始化数据");
        System.out.println("2. 自动选课");
        System.out.println("3. 成绩生成");
        System.out.println("4. 查询");
        System.out.println("5. 清除数据");
        System.out.println("6. 退出");
    }

    @Override
    public Menu onInput(String input, Sgms sgms) {
        Scanner scanner = new Scanner(System.in);
        switch (input) {
            case "1": {
                System.out.println("请输入生成学生数量(不少于100)");
                int studentNum = scanner.nextInt();
                System.out.println("请输入生成教师数量(不少于6)");
                int teacherNum = scanner.nextInt();
                System.out.println("请输入生成课程数量(不少于3)");
                int courseNum = scanner.nextInt();
                try {
                    sgms.generateData(studentNum, teacherNum, courseNum);

                    System.out.println("生成成功");
                } catch (IllegalArgumentException e) {
                    System.out.println("输入数据不合法,生成失败");
                }
                return this;
            }
            case "2": {
                sgms.selectCourse();
                System.out.println("选课成功");
                return this;
            }
            case "3": {
                sgms.generateGradeRandomly();
                System.out.println("成绩生成成功");
                return this;
            }
            case "4": {
                return new QueryMenu(this);
            }
            case "5": {
                sgms.clearData();
                System.out.println("清除成功");
                return this;
            }
            case "6": {
                System.exit(0);
                return this;
            }
            default:
                return this;
        }
    }
}
