package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Application extends Controller {

    public static void index() {
    	//最新的博客
    	Post frontPost = Post.find("order by postedAt desc").first();
    	
    	//过去的博客
    	List<Post> olderPosts = Post.find(
    			"order by postedAt desc").from(1).fetch(10);
        render(frontPost, olderPosts);
    }

}