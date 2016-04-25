package rblearning.controllers;

import java.util.Map;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RestController;

import jersey.repackaged.com.google.common.collect.Maps;
import rblearning.models.Lession;
import rblearning.repositories.LessionRepository;
import rblearning.repositories.TopicRepository;

@RestController
@Path("home")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class HomeController {

	private final LessionRepository lessionRepository;
	private final TopicRepository topicRepository;
	
	@Autowired
	public HomeController(LessionRepository lessionRepository, TopicRepository topicRepository){
		this.lessionRepository = lessionRepository;
		this.topicRepository = topicRepository;
	}
	
	@GET
	@Path("lessions/{page}")
	public Response findLessions(@PathParam("page") @DefaultValue("0") int page){
		final PageRequest pageRequest = new PageRequest(page, 10, Direction.DESC, "createdAt");
		final Page<Lession> pages = lessionRepository.findAll(pageRequest);
		final Map<String, Object> body = Maps.newHashMap();
		body.put("page", page);
		body.put("lessions", pages.getContent());
		return Response.ok(body).build();
	}
	
	@GET
	@Path("topics")
	public Response findTopics(){
		final Sort sort = new Sort("name");
		return Response.ok(topicRepository.findAll(sort)).build();
	}
	
}
