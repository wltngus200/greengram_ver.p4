package com.green.greengram.feedcomment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper mapper;
}
