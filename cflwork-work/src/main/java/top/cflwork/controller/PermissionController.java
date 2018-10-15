package top.cflwork.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.cflwork.common.Message;
import top.cflwork.query.PageQuery;
import top.cflwork.service.PermissionService;
import top.cflwork.util.Log;
import top.cflwork.vo.PermissionVo;
import top.cflwork.vo.TreeVo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("permission")
@Controller
public class PermissionController {
	@Resource
	private PermissionService permissionService;

	public String prefix = "permission";
	@RequiresPermissions("sys:menu:menu")
	@GetMapping("permissionPage")
	public String permissionPage() {
		return "/permission/permissionList";
	}

	@RequiresPermissions("sys:menu:menu")
	@RequestMapping("/list")
	@ResponseBody
	public List<PermissionVo> list(@RequestParam Map<String, Object> params) {
		List<PermissionVo> menus = permissionService.listPage(new PageQuery());
		return menus;
	}

	@Log("添加菜单")
	@RequiresPermissions("sys:menu:add")
	@GetMapping("/add/{pId}")
	public String add(Model model, @PathVariable("pId") Long pId) {
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "根目录");
		} else {
			model.addAttribute("pName", permissionService.getById(pId).getName());
		}
		return prefix + "/add";
	}

	@Log("编辑菜单")
	@RequiresPermissions("sys:menu:edit")
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		PermissionVo mdo = permissionService.getById(id);
		Long pId = mdo.getParentId();
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "根目录");
		} else {
			model.addAttribute("pName", permissionService.getById(pId).getName());
		}
		model.addAttribute("menu", mdo);
		return prefix+"/edit";
	}

	@Log("保存菜单")
	@RequiresPermissions("sys:menu:add")
	@PostMapping("/save")
	@ResponseBody
	public Message save(PermissionVo menu) {
		permissionService.save(menu);
		return Message.success("保存成功");
	}

	@Log("更新菜单")
	@RequiresPermissions("sys:menu:edit")
	@PostMapping("/update")
	@ResponseBody
	public Message update(PermissionVo menu) {
		permissionService.update(menu);
		return Message.fail( "更新失败");
	}

	@Log("删除菜单")
	@RequiresPermissions("sys:menu:remove")
	@PostMapping("/remove")
	@ResponseBody
	public Message remove(Long id) {
		permissionService.removeById(id);
		return Message.success("删除失败");
	}

	@GetMapping("/tree")
	@ResponseBody
    public TreeVo<PermissionVo> tree() {
        TreeVo<PermissionVo>  tree = permissionService.getTree();
		return tree;
	}

	@GetMapping("/tree/{roleId}")
	@ResponseBody
    public TreeVo<PermissionVo> tree(@PathVariable("roleId") Long roleId) {
        TreeVo<PermissionVo> tree = permissionService.getTree(roleId);
		return tree;
	}
}
