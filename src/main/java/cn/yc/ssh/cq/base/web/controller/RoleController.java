package cn.yc.ssh.cq.base.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.yc.ssh.cq.base.entity.Resources;
import cn.yc.ssh.cq.base.entity.Role;
import cn.yc.ssh.cq.base.exception.ServiceException;
import cn.yc.ssh.cq.base.service.ResourceService;
import cn.yc.ssh.cq.base.service.RoleService;

/**
 * <p>
 * User: yc
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private ResourceService resourceService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("roleList", roleService.findAll());
		return "role/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		return "role/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView create(Role role, RedirectAttributes redirectAttributes) {
		try {
			roleService.createRole(role);
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("role", roleService.findOne(id));
		return "role/edit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView update(Role role, RedirectAttributes redirectAttributes) {
		roleService.updateRole(role);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ModelAndView showDeleteForm(@PathVariable("id") Long id, Model model) {
		roleService.deleteRole(id);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/resources/{id}", method = RequestMethod.GET)
	public String showResourcesForm(@PathVariable("id") Long id, Model model) {
//		List<Resources> list = resourceService.findAll();
//		List<Resources> current = roleService.queryResources(id);
//		model.addAttribute("list", list);
//		model.addAttribute("current", current);
		model.addAttribute("roleId", id);
		return "role/resources";
	}
	
	@RequestMapping(value = "/currentres/{id}")
	public @ResponseBody List<Resources> getResourcesData(@PathVariable("id") Long id) {
		return roleService.queryResources(id);
	}
	
	@RequestMapping(value = "/resources/{id}", method = RequestMethod.POST)
	public ModelAndView saveResourcesForm(@PathVariable("id") Long id, Long[] res) {
		roleService.saveRoleRes(res, id);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

}
