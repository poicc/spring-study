package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Forum;
import com.soft1851.spring.ioc.entity.Post;

import java.util.List;

/**
 * @author CRQ
 */
public interface PostDAO {
    /**
     * 新增Post
     * @param post
     * @return int
     */
    int insert(Post post);

    /**
     * 批量新增Post
     * @param  posts
     * @return int[]
     */
    int[] batchInsert(List<Post> posts);

    /**
     * 根据id删除Post
     * @param postId
     * @return int
     */
    int delete(int postId);

    /**
     * 修改Post
     * @param  post
     * @return
     */
    int update(Post post);

    /**
     * 根据id查询Post
     * @param  postId
     * @return Post
     */
    Forum get(int postId);

    /**
     * 查询所有帖子消息
     * @return List<Post>
     */
    List<Forum> selectAll();
}
