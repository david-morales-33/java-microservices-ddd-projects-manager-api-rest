package com.dmx.media.post.domain;

import com.dmx.shared.domain.criteria.Criteria;

import java.util.List;

public interface PostQueryRepository {
    List<Post> searchAll();
    List<Post> match(Criteria criteria);
}
