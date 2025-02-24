package com.dmx.media.post.domain;


import java.util.List;

import com.dmx.media.shared.domain.criteria.Criteria;

public interface PostQueryRepository {
    List<Post> searchAll();
    List<Post> match(Criteria criteria);
}
