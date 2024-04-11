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
        System.out.println("2. 教学班查询");
        System.out.println("3. 排名查询");
        System.out.println("4. 返回");
    }

    @Override
    public Menu onInput(String input, Sgms sgms) {
        switch (input) {
            case "1": {
                return new StudentQueryMenu(this);
            }
            case "2": {
                return new TeachingClassQueryMenu(this);
            }
            case "3": {
                return new RankQueryMenu(this);
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
