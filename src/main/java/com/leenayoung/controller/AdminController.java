package com.leenayoung.controller;

import com.leenayoung.model.Community;
import com.leenayoung.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    @Autowired
    CommunityService communityService;

    @GetMapping("admin")
    public String viewAdmin() {
        System.out.println("어드민페이지요청");
        return "admin/admin";
    }

    @GetMapping("admin/admin_community")
    public String viewAdminCategory(Model model){
        model.addAttribute("communityList", communityService.getCommunityList());
        System.out.println("=============================>" +model.getAttribute("communityList"));
        System.out.println("카테고리관리");
        return "admin/admin_community";
    }

    @GetMapping("/admin/delete_community")
    public String deleteCategory(HttpServletRequest request) {
        String seq = request.getParameter("seq");
        System.out.println("==========> seq"+seq);

        Community community = new Community();
        community.setSeq(Long.parseLong(seq));
        System.out.println("===========> pasredSeq" + community.getSeq());

        communityService.deleteCommunity(community);

        return "redirect:/admin/admin_community";

    }

}
