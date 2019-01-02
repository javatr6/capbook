package org.flp.capbook.controller;


import java.util.List;

import org.flp.capbook.model.Comments;
import org.flp.capbook.model.Status;
import org.flp.capbook.service.ICommentService;
import org.flp.capbook.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin("*")
public class CommentController {

	@Autowired
	private IStatusService statusService;

	@Autowired
	private  ICommentService CommentService;
	@PostMapping("/comments")
	private ResponseEntity<List<Comments>> saveComment(@RequestBody Comments comment){
		//System.out.println("Controller");
		List<Comments> comments=CommentService.saveComment(comment);
		if(comments.isEmpty()) {
			return new ResponseEntity("Sorry ...",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Comments>>(comments,HttpStatus.OK);
	}

	@GetMapping("/comments")
	private ResponseEntity<List<Comments>> getAllComments(){
		List<Comments> comments=CommentService.getAllComments();
		if(comments.isEmpty()) {
			return new ResponseEntity("No product available",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Comments>>(comments,HttpStatus.OK);
	}

	@PostMapping("/status")
	public String  saveStatus(@RequestBody Status status){

		boolean status1 = statusService.saveStatus(status);
		if(status1 == false) 
			return "failed";
		return "success";	
	}
	@GetMapping("/status")
	public ResponseEntity<List<Status>>getAllStatus(){

		List<Status> products=statusService.getAllStatus();

		if(products.isEmpty())
			return new ResponseEntity("Sorry! Product not available",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Status>>(products, HttpStatus.OK);

	}


	@PutMapping("/comments/{status_id}/{commentId}")
	public ResponseEntity<Integer> updateCommentLikeCount(
			@PathVariable Integer status_id,
			@PathVariable Integer commentId){
		System.out.println("fdsf");
		Integer likecount= CommentService.updateCommentLikeCount(status_id,commentId);
		System.out.println("fsdfgfdgfdg"+likecount);
		return new ResponseEntity<Integer>(likecount, HttpStatus.OK);
	} 
	

	@PutMapping("/comment/{status_id}/{commentId}")
	public ResponseEntity<Integer> updateCommentDislikeCount(
			@PathVariable Integer status_id,
			@PathVariable Integer commentId){
		System.out.println("fdsf");
		Integer dislikecount= CommentService.updateCommentDislikeCount(status_id,commentId);
		System.out.println("fsdfgfdgfdg"+dislikecount);
		return new ResponseEntity<Integer>(dislikecount, HttpStatus.OK);
	} 






	@GetMapping("/comments/{status_id}")
	private ResponseEntity<List<Comments>> getAllCommentsByStatusId(@PathVariable("status_id") Integer status_id){
		List<Comments> comments=CommentService.getAllCommentsByStatusId(status_id);
		if(comments.isEmpty()) {
			System.out.println("fds");
			return new ResponseEntity("No product available",HttpStatus.NOT_FOUND);
		}
		System.out.println("fksdj");
		for(Comments c1:comments) {
			System.out.println(c1.getDateOfPosting().getMinute());
		}
		Comments c=new Comments();
		System.out.println(c.getDateOfPosting());
		System.out.println(c.getDateOfPosting().getHour());
		System.out.println(c.getDateOfPosting().getMinute());
		return new ResponseEntity<List<Comments>>(comments,HttpStatus.OK);
	}
	@PostMapping("/comments/{status_id}")
	private ResponseEntity<List<Comments>> saveCommentByStatusId(@PathVariable Integer status_id,@RequestBody Comments comment){
		//System.out.println("Controller");
		List<Comments> comments=CommentService.saveCommentByStatusId(status_id,comment);
		if(comments.isEmpty()) {
			return new ResponseEntity("Sorry ...",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Comments>>(comments,HttpStatus.OK);
	}

} 



