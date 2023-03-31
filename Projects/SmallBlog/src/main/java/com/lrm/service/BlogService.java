<<<<<<< HEAD
// finished

=======
>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2
package com.lrm.service;

import com.lrm.po.Blog;
import com.lrm.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

<<<<<<< HEAD
import java.util.List;
import java.util.Map;

/**
 * Created by limi on 2017/10/20.
 */
public interface BlogService {

    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable,BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId,Pageable pageable);

    Page<Blog> listBlog(String query,Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String,List<Blog>> archiveBlog();

    Long countBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);
=======
public interface BlogService {
    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);
>>>>>>> bfc3e850796c355c9d67ec67bd0d5f7b329cf4e2

    void deleteBlog(Long id);
}
