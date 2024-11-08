package com.danvega.hello_vaadin.post;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("posts")
class PostsView extends Div{
	
	public PostsView(PostService postService) {
		setHeightFull();
		
		Grid<Post> grid = new Grid<>(Post.class, false);
		grid.addColumn(Post::name).setHeader("Name");
		grid.addColumn(Post::location).setHeader("Location");
		grid.addThemeVariants(GridVariant.LUMO_COMPACT);
		grid.setHeightFull();
		
		List<Post> posts = postService.findAll();
		grid.setItems(posts);
		
		add(grid);
	}
}
