package com.ada.feed.dto;

import java.io.Serializable;

import com.ada.feed.entity.Feed;
import com.ada.feed.page.FeedCommentPage;

public class FeedDto implements Serializable{
	
	private Feed feed;
	
	private FeedCommentPage commentPage;

	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	public FeedCommentPage getCommentPage() {
		return commentPage;
	}

	public void setCommentPage(FeedCommentPage commentPage) {
		this.commentPage = commentPage;
	}
	
	

}
