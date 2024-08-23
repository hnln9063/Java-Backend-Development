package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.JobPost;
import com.telusko.service.JobService;

@RestController
public class JobRestController {

	@Autowired
	private JobService jobService;
	
	@GetMapping("jobPosts")
	public List<JobPost> getAllPost() {
		return jobService.getAllJobs();
	}
	
	@GetMapping("/jobPost/{postId}")
	public JobPost getJob(@PathVariable int postId) {
		return jobService.getJob(postId);
	}
	
	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> searchByKeyword(@PathVariable String keyword) {
		return jobService.search(keyword);
	}
	
	@PostMapping("jobPost")
	public JobPost addJob(@RequestBody JobPost jobpost) {
		jobService.addJob(jobpost);
		return jobService.getJob(jobpost.getPostId());
	}
	
	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		jobService.updateJob(jobPost);
		return jobService.getJob(jobPost.getPostId());
	}
	
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable int postId) {
		jobService.deleteJob(postId);
		return "Deleted";
	}
	
	@GetMapping("load")
	public String loadData() {
		jobService.load();
		return "success";
	}
	
}
