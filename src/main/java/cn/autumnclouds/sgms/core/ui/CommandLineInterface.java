package cn.autumnclouds.sgms.core.ui;

import cn.autumnclouds.sgms.core.Sgms;
import cn.autumnclouds.sgms.core.ui.menu.impl.MainMenu;
import cn.autumnclouds.sgms.core.ui.menu.Menu;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Fu Qiujie
 * @since 2024/4/6
 */
@Component
public class CommandLineInterface {

    @Resource
    private Sgms sgms;

    private Menu currentMenu = new MainMenu(null);

    public void start() {
        currentMenu.onShow();
    }

    public void handleInput(String input) {
        currentMenu = currentMenu.onInput(input, sgms);
        currentMenu.onShow();
    }

}
