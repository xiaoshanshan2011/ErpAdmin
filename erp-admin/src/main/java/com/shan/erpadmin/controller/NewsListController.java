package com.shan.erpadmin.controller;

import com.shan.erpadmin.domain.NewsList;
import com.shan.erpadmin.domain.Result;
import com.shan.erpadmin.repository.NewsListRepository;
import com.shan.erpadmin.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 新闻列表控制器
 */
@RestController
public class NewsListController {
    @Autowired
    private NewsListRepository newsListRepository;

    /**
     * 查询返回新闻列表
     *
     * @return
     */
    @GetMapping(value = "/newslist/getNewsList", produces = {"application/json;charset=UTF-8"})
    public Result getNewList(@RequestParam("pageIndex") Integer pageIndex) {
        //分页处理
        PageRequest request = buildPageRequest(pageIndex);
        Page<NewsList> lsit = newsListRepository.findAll(request);
        List<NewsList> data = lsit.getContent();
        return ResultUtils.success(data);
    }

    /**
     * 添加一条新闻
     *
     * @return
     */
    @PostMapping(value = "/newslist/addNews", produces = {"application/json;charset=UTF-8"})
    public NewsList addNews(@RequestParam("relateId") String relateId,
                            @RequestParam("title") String title,
                            @RequestParam("intro") String intro,
                            @RequestParam("time") String time) {
        NewsList newsList = new NewsList();
        newsList.setRelateId(relateId);
        newsList.setTitle(title);
        newsList.setIntro(intro);
        newsList.setTime(time);
        return newsListRepository.save(newsList);
    }

    /**
     * 添加一条新闻
     *
     * @return
     */
    @PostMapping(value = "/newslist/addNews2", produces = {"application/json;charset=UTF-8"})
    public Result<NewsList> addNews2(@Valid NewsList list, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error(201, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.success(newsListRepository.save(list));
    }

    /**
     * 查询一条新闻
     *
     * @return
     */
    @GetMapping(value = "/newslist/getOneNews", produces = {"application/json;charset=UTF-8"})
    public NewsList getOneNews(@RequestParam("id") Integer id) {
        return newsListRepository.findById(id).get();
    }

    /**
     * 更新一条新闻
     *
     * @param id
     * @param title
     * @return
     */
    @PutMapping(value = "/newslist/updateNews", produces = {"application/json;charset=UTF-8"})
    public NewsList updateNews(@RequestParam("id") Integer id,
                               @RequestParam("title") String title) {
        NewsList newsList = new NewsList();
        newsList.setId(id);
        newsList.setTitle(title);
        return newsListRepository.save(newsList);
    }

    /**
     * 删除一条新闻
     *
     * @param id
     */
    @DeleteMapping(value = "/newslist/deleteNews", produces = {"application/json;charset=UTF-8"})
    public void deleteNews(@RequestParam("id") Integer id) {
        newsListRepository.deleteById(id);
        return;
    }

    //构建PageRequest
    private PageRequest buildPageRequest(int pageNumber) {
        return new PageRequest(pageNumber - 1, 20, null);
    }

}
