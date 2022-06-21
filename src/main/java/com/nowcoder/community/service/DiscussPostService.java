package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPost(int userid,int offet,int limit)
    {
        return discussPostMapper.selectDiscussPosts(userid,offet,limit);
    }
    public int findDiscussPostRows(int userId){

        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
