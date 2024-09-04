package com.springboot.controller;

import com.springboot.dto.ICategoryDocumentNumber;
import com.springboot.model.Category;
import com.springboot.service.impl.ICategoryService;
import com.springboot.service.impl.IDocumentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Document;
import java.util.List;

@Controller
public class DocumentController {
    private final ICategoryService categoryService;
    private final IDocumentService documentService;

    public DocumentController(ICategoryService categoryService, IDocumentService documentService) {
        this.categoryService = categoryService;
        this.documentService = documentService;
    }

    @ModelAttribute("categoryList")
    public List<Category> categoryList() {
        return categoryService.findALl();
    }

    @ModelAttribute("categoryDocumentNumberList")
    public List<ICategoryDocumentNumber> categoryDocumentNumberList() {
        return categoryService.getCategoryDocumentNumber();
    }

    @GetMapping
    public String index(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam(required = false) String query) {
        Page<Document> documentList = documentService.findByNameContainingIgnoreCase(query, pageable);
        model.addAttribute("query", query);
        model.addAttribute("documentList", documentList);
        return "/index";
    }

    @GetMapping("document/create")
    public String create(Model model) {
        return "/document/create";
    }

    @PostMapping("document/create")
    public String create(@ModelAttribute Document document) {
        documentService.save(document);
        return "redirect:/";
    }

    @GetMapping("document/{id}/delete")
    public String delete(Model model, @PathVariable Long id) {
        Document document = documentService.findById(id);
        model.addAttribute("document", document);
        return "/document/delete";
    }

    @PostMapping("document/delete")
    public String delete(@RequestParam Long id) {
        Document document = documentService.findById(id);
        documentService.delete(document);
        return "redirect:/";
    }

    @GetMapping("document/{id}/update")
    public String update(Model model, @PathVariable Long id) {
        Document document = documentService.findById(id);
        model.addAttribute("document", document);
        return "/document/update";
    }

    @PostMapping("document/update")
    public String update(Model model, @ModelAttribute Document document) {
        documentService.save(document);
        return "redirect:/";
    }

    @GetMapping("category/{id}/delete")
    public String deleteCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "/category/delete";
    }

    @PostMapping("/category/delete")
    public String deleteCategory(@RequestParam Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/";
    }
}
