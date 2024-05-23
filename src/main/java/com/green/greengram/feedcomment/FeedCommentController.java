package com.green.greengram.feedcomment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/feed/comment")
public class FeedCommentController {
    private final FeedCommentService service;


}
