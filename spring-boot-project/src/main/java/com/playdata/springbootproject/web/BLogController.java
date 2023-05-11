package com.playdata.springbootproject.web;
import com.playdata.springbootproject.service.BlogsService;
import com.playdata.springbootproject.web.dto.BlogsResponseDto;
import com.playdata.springbootproject.web.dto.BlogsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class BLogController {
    private final BlogsService blogsService;

    @PostMapping("/api/v1/blogs")
    public Long save(@RequestBody BlogsSaveRequestDto requestDto) {
        return blogsService.save(requestDto);
    }

    @PutMapping("/api/v1/blogs/{id}")
    public Long update(@PathVariable Long id, @RequestBody BlogsSaveRequestDto requestDto) {
        return blogsService.update(id,requestDto);
    }

    @GetMapping("/api/v1/blogs/{id}")
    public BlogsResponseDto findById(@PathVariable Long id) {
        return blogsService.findById(id);
    }

    @DeleteMapping("/api/v1/blogs/{id}")
    public Long delete(@PathVariable Long id) {
        blogsService.delete(id);
        return id;
    }



    @GetMapping("/blogs/{id}")
    public String blogUpdate(Model model, @PathVariable Long id) {
        model.addAttribute("blog", blogsService.findById(id));
        return "blog-update";
    }
}