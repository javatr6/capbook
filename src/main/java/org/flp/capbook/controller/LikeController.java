package org.flp.capbook.controller;


import org.flp.capbook.model.Likes;
import org.flp.capbook.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LikeController {

	@Autowired
	private ILikeService likeService;
	
	@PostMapping("/likes/{status_id}")
	private ResponseEntity<Boolean> updateLikes(@PathVariable Integer status_id,@RequestBody Likes like){
		//System.out.println("Controller");
		Boolean b=likeService.updateLikes(status_id,like);
		
		if(b.equals(false)) {
			return new ResponseEntity("Sorry ...",HttpStatus.NOT_FOUND);
		}
		System.out.println("liked");
		return new ResponseEntity<Boolean>(b,HttpStatus.OK);
		
		
	}
	@GetMapping("/likes/{status_id}")
	private ResponseEntity<Integer> getLikeCount(@PathVariable Integer status_id){
		//System.out.println("Controller");
		Integer likeCount=likeService.getLikeCount(status_id);
		System.out.println(likeCount);
		/*if(comments.isEmpty()) {
			return new ResponseEntity("Sorry ...",HttpStatus.NOT_FOUND);
		}*/
		return new ResponseEntity<Integer>(likeCount,HttpStatus.OK);
		
		
	}
	@PostMapping("/dislikes/{status_id}")
	private ResponseEntity<Boolean> updateDislikes(@PathVariable Integer status_id,@RequestBody Likes like){
		//System.out.println("Controller");
		Boolean b=likeService.updateDislikes(status_id,like);
		
		if(b.equals(false)) {
			return new ResponseEntity("Sorry ...",HttpStatus.NOT_FOUND);
		}
		System.out.println("disliked");
		return new ResponseEntity<Boolean>(b,HttpStatus.OK);
		
		
	}
	@GetMapping("/dislikes/{status_id}")
	private ResponseEntity<Integer> getDislikeCount(@PathVariable Integer status_id){
		//System.out.println("Controller");
		Integer disLikeCount=likeService.getDislikeCount(status_id);
		System.out.println(disLikeCount);
		/*if(comments.isEmpty()) {
			return new ResponseEntity("Sorry ...",HttpStatus.NOT_FOUND);
		}*/
		return new ResponseEntity<Integer>(disLikeCount,HttpStatus.OK);
		
		
	}
}
