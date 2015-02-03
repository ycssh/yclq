package cn.yc.ssh.cq.base.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.yc.ssh.cq.base.entity.Resources;
import cn.yc.ssh.cq.base.service.ResourceService;

/**
 * <p>User: yc
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {

    @Autowired
    private ResourceService resourceService;

    @ModelAttribute("types")
    public Resources.ResourceType[] resourceTypes() {
        return Resources.ResourceType.values();
    }

    @RequestMapping(value="")
    @RequiresPermissions("admin")
    public String list(Model model) {
        model.addAttribute("resourceList", resourceService.findAll());
        return "resource/list";
    }
    
    @RequestMapping(value="tree", method = RequestMethod.GET)
    public @ResponseBody List<Resources> tree(Model model) {
    	return resourceService.findAll();
    }

    @RequestMapping(value = "/add/{parentId}", method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("parentId") Long parentId, Model model) {
        Resources parent = resourceService.findOne(parentId);
        model.addAttribute("parent", parent);
        Resources child = new Resources();
        child.setParentId(parentId);
        child.setParentIds(parent.makeSelfAsParentIds());
        model.addAttribute("resource", child);
        return "resource/edit";
    }

    @RequestMapping(value = "/add/{parentId}", method = RequestMethod.POST)
    public ModelAndView create(Resources resource, RedirectAttributes redirectAttributes) {
        resourceService.createResource(resource);
        redirectAttributes.addFlashAttribute("msg", "新增子节点成功");
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("resource", resourceService.findOne(id));
        return "resource/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView update(Resources resource, RedirectAttributes redirectAttributes) {
        resourceService.updateResource(resource);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        resourceService.deleteResource(id);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
    }


}
