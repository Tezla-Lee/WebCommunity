package com.leenayoung.controller;

import com.leenayoung.model.Community;
import com.leenayoung.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    @Autowired
    CommunityService communityService;

    @GetMapping("admin")
    public String viewAdmin() {
        return "admin/admin";
    }

    @GetMapping("admin/admin_community")
    public String viewAdminCategory(Model model){
        model.addAttribute("communityList", communityService.getCommunityList());
        return "admin/admin_community";
    }

    @GetMapping("/admin/delete_community")
    public String deleteCategory(HttpServletRequest request) {
        String seq = request.getParameter("seq");
        Community community = new Community();
        community.setSeq(Long.parseLong(seq));
        communityService.deleteCommunity(community);
        return "redirect:/admin/admin_community";
    }

    @GetMapping("/admin/update_community")
    public String viewUpdateCommunity(Community community, Model model) {
        Community findCommunity = new Community();
        findCommunity.setSeq(community.getSeq());

        model.addAttribute("community", communityService.getCommunity(findCommunity));
        return "/admin/update_community";
    }

    @PostMapping("/admin/update_community")
    public String updateCommunity(Community community) {
        System.out.println("============>" + community);
        communityService.updateCommunity(community);

        return "redirect:/admin/admin_community";
    }

}
