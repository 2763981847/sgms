package cn.autumnclouds.sgms.core.ui.menu.impl;

import cn.autumnclouds.sgms.core.Sgms;
import cn.autumnclouds.sgms.core.ui.menu.Menu;

/**
 * @author Fu Qiujie
 * @since 2024/4/6
 */
public class QueryMenu extends Menu {
    public QueryMenu(Menu prevMenu) {
        super(prevMenu);
    }

    @Override
    public void onShow() {
        System.out.println("1. 学生查询");
        System.out.println("2. 教师查询");
        System.out.println("3. 课程查询");
        System.out.println("4. 教学班查询");
        System.out.println("5. 选课情况查询");
        System.out.println("6. 返回");
    }

    @Override
    public Menu onInput(String input, Sgms sgms) {
        switch (input) {
            case "1": {
                return new StudentQueryMenu(this);
            }
            case "2": {

            }
            case "3": {

            }
            case "4": {

            }
            case "5": {

            }
            case "6": {
                return prevMenu;
            }
            default: {
                return this;
            }
        }
    }


}
