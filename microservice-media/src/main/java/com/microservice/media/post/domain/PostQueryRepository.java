package com.microservice.media.post.domain;


import java.util.List;

import com.microservice.media.shared.domain.criteria.Criteria;

public interface PostQueryRepository {
    List<Post> searchAll();
    List<Post> match(Criteria criteria);
}
