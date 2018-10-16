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
	@GetMapping("permissionPage")
	public String permissionPage() {
		return "/permission/permissionList";
	}

	@RequestMapping("/permissionList")
	@ResponseBody
	public List<PermissionVo> list(@RequestParam Map<String, Object> params) {
		List<PermissionVo> menus = permissionService.listPage(new PageQuery());
		return menus;
	}

	@Log("添加菜单")
	@RequestMapping("/add/{pId}")
	@ResponseBody
	public PermissionVo add(@PathVariable("pId") Long pId) {
		PermissionVo permissionVo = new PermissionVo();
		permissionVo.setParentId(pId);
		if (pId == 0) {
			permissionVo.setPName("根目录");
		} else {
			permissionVo.setPName(permissionService.getById(pId).getName());
		}
		return permissionVo;
	}

	@Log("编辑菜单")
	@RequestMapping("/findPermission/{id}")
    @ResponseBody
	public PermissionVo edit(Model model, @PathVariable("id") Long id) {
		PermissionVo permissionVo = permissionService.getById(id);
		if (permissionVo.getParentId() == 0) {
			permissionVo.setPName("根目录");
		} else {
            permissionVo.setPName(permissionService.getById(permissionVo.getParentId()).getName());
		}
		return permissionVo;
	}

	@Log("保存菜单")
	@RequestMapping("/permissionAddSave")
	@ResponseBody
	public Message save(PermissionVo menu) {
		permissionService.save(menu);
		return Message.success("保存成功");
	}

	@Log("更新菜单")
	@RequestMapping("/permissionUpdateSave")
	@ResponseBody
	public Message update(PermissionVo menu) {
        try{
            permissionService.update(menu);
            return  Message.success("修改成功!");
        }catch (Exception e){
            e.printStackTrace();
            return  Message.fail("修改失败!");
        }
	}

	@Log("删除菜单")
	@RequestMapping("/deletePermission/{id}")
	@ResponseBody
	public Message remove(@PathVariable("id") Long id) {
        try{
            permissionService.removeById(id);
            return Message.success("删除成功!");
        }catch (Exception e){
            e.printStackTrace();
            return Message.fail("删除失败!");
        }
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
