package org.flp.capbook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.flp.capbook.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;



@RestController
@CrossOrigin("*")
public class UploadController {

	@Value("${upload.path}")
	private String path;


	@Autowired
	StorageService profileService;

	List<String> files1 = new ArrayList<String>();

	@PostMapping("/saveImage/{userId}/{location}")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile[] files,
			@PathVariable("userId")Integer userId,@PathVariable("location")String location){
		String message = "";
		profileService.store(files,location,userId);
		for(MultipartFile file:files) {	
			try {
				
				message = "You successfully uploaded " + file.getOriginalFilename() + "!";
				System.out.println("Success");
			} catch (Exception e) {
				message = "FAIL to upload " + file.getOriginalFilename() + "!";
				System.out.println(e.getMessage());
				System.out.println("Fail");
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(message);

	}

	@GetMapping("/getallfiles/{userId}/{location}")
	public ResponseEntity<List<String>> getListFiles(Model model,@PathVariable("userId")Integer userId,@PathVariable("location")String location) {
		
		files1=profileService.getAllFiles(userId,location);
		System.out.println("files in controller");
		System.out.println(files1);
		List<String> fileNames = files1
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(UploadController.class, "getFile", fileName,userId,location).build().toString())
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(fileNames);
	}

	@GetMapping("/files/{filename:.+}/{userId}/{location}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename,@PathVariable("userId")Integer userId,@PathVariable("location")String location) {
		Resource file = profileService.loadFile(filename,userId,location);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	
}
