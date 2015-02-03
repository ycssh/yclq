package cn.yc.ssh.cq.base.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.yc.ssh.cq.base.entity.BaseConditionVO;
import cn.yc.ssh.cq.base.entity.Role;
import cn.yc.ssh.cq.base.entity.User;
import cn.yc.ssh.cq.base.exception.ServiceException;
import cn.yc.ssh.cq.base.service.OrganizationService;
import cn.yc.ssh.cq.base.service.RoleService;
import cn.yc.ssh.cq.base.service.UserService;

/**
 * <p>
 * User: yc
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private RoleService roleService;

	@RequestMapping("")
	public String list(BaseConditionVO vo, Model model) throws Exception {
		List<User> userList = userService.searchUser(vo);
		Integer totalCount = userService.searchUserNum(vo);
		model.addAttribute("userList", userList);
		model.addAttribute("pageSize", vo.getPageSize());
		vo.setTotalCount(totalCount);
		model.addAttribute("vo", vo);
		return "/user/list";
	}

	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("user", null);
		return "/user/add";
	}

	@RequestMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") long userId, Model model) {
		User user = userService.findOne(userId);
		model.addAttribute("user", user);
		return "/user/edit";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(User user) {
		try {
			userService.createUser(user);
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(User user) {
		userService.updateUser(user);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/{id}/pwd", method = RequestMethod.GET)
	public String showChangePasswordForm(@PathVariable("id") Long id,
			Model model) {
		model.addAttribute("user", userService.findOne(id));
		return "user/changePassword";
	}

	@RequestMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
		userService.deleteUser(id);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	/**
	 * 跳转到分配角色
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
	public String role(@PathVariable("id") Long id, Model model) {
		List<Role> list = roleService.findAll();
		List<Role> current = roleService.findByUser(id);
		list.removeAll(current);
		model.addAttribute("list", list);
		model.addAttribute("current", current);
		model.addAttribute("userId", id);
		return "user/role";
	}
	
	@RequestMapping(value = "/role/{userId}",  method = RequestMethod.POST)
	public ModelAndView saveRole(@PathVariable("userId") Long userId, Model model, Long[] role) {
		userService.saveUserRole(role, userId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/{id}/pwd", method = RequestMethod.POST)
	public ModelAndView changePassword(@PathVariable("id") Long id,
			String newPassword) {
		try {
			userService.changePassword(id, newPassword);
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
