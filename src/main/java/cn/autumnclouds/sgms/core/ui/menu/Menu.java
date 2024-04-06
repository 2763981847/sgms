package cn.autumnclouds.sgms.core.ui.menu;

import cn.autumnclouds.sgms.core.Sgms;

/**
 * @author Fu Qiujie
 * @since 2024/4/6
 */
public abstract class Menu {
    protected final Menu prevMenu;


    public Menu(Menu prevMenu) {
        this.prevMenu = prevMenu;
    }

    public abstract void onShow();

    public abstract Menu onInput(String input, Sgms sgms);

}
