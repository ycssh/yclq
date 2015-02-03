package cn.yc.ssh.cq.base.web.controller;

import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yc.ssh.cq.base.Constants;
import cn.yc.ssh.cq.base.entity.Resources;
import cn.yc.ssh.cq.base.entity.User;
import cn.yc.ssh.cq.base.service.ResourceService;
import cn.yc.ssh.cq.base.service.UserService;

/**
 * <p>User: yc
 */
@Controller
public class IndexController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model) {
    	Session session = SecurityUtils.getSubject().getSession();
    	User user = (User) session.getAttribute(Constants.CURRENT_USER);
        Set<String> permissions = userService.findPermissions(user.getUsername());
        List<Resources> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }


}
