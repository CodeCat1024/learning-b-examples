<<<<<<< HEAD
// finished

=======
>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
package com.lrm.web.admin;

import com.lrm.po.Tag;
import com.lrm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

<<<<<<< HEAD
/**
 * Created by limi on 2017/10/16.
 */

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    // 将标签渲染到页面上
=======
@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    private TagService tagService;

>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC)
                               Pageable pageable, Model model) {
        model.addAttribute("page",tagService.listTag(pageable));
        return "admin/tags";
    }

<<<<<<< HEAD
    // 去到标签新增页面
=======
>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
    @GetMapping("/tags/input")
    public String input(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }

<<<<<<< HEAD
    // 去到标签编辑页面
=======
>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tags-input";
    }

<<<<<<< HEAD
    // 提交新增标签
=======

>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
    @PostMapping("/tags")
    public String post(@Valid Tag tag,BindingResult result, RedirectAttributes attributes) {
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/tags-input";
        }
        Tag t = tagService.saveTag(tag);
        if (t == null ) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/tags";
    }


<<<<<<< HEAD
    // 提交编辑过的标签
=======
>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
    @PostMapping("/tags/{id}")
    public String editPost(@Valid Tag tag, BindingResult result,@PathVariable Long id, RedirectAttributes attributes) {
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/tags-input";
        }
        Tag t = tagService.updateTag(id,tag);
        if (t == null ) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/tags";
    }
<<<<<<< HEAD


}
=======
}
>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
