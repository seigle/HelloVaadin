package com.danvega.hello_vaadin.post;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
class PostService {

	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	private final List<Post> posts = new ArrayList<>();
	
	public PostService(ObjectMapper objectMapper) {
		log.info("About to read the posts from the objectMapper....");
		try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/posts.json")) {
			Posts allPosts = objectMapper.readValue(inputStream, Posts.class);
			log.info("Reading {} posts from JSON data", allPosts.posts().size());
			posts.addAll(allPosts.posts());
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new RuntimeException("Failed to read JSON data", e);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	List<Post> findAll() {
		return posts;
	}
}
