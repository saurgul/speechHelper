package com.speechhelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.speechhelper.databasemanager.SpeechEntity;
import com.speechhelper.databasemanager.SpeechRepository;
import com.speechhelper.speechtotext.Speech;

@Controller
@RequestMapping(path="/demo")
public class SpeechDatabaseController {
	@Autowired
	private SpeechRepository speechRepository;
	
	@PostMapping(path="/add_speech") // Map ONLY POST Requests
	public String addNewSpeech (@RequestParam Long userId, @RequestParam Speech speech) {
		SpeechEntity n = new SpeechEntity();
		n.setUserId(userId);
//		n.setTranscribedSpeechText(speech.getText());
//		n.setConvertedSpeechText(speech.getInput());
		speechRepository.save(n);
		return "Saved";
	}
	
	@Transactional
	@GetMapping(path="/all/speech")
	public Iterable<SpeechEntity> getAllSpeech() {
	    // This returns a JSON or XML with the users
	    return speechRepository.findAll();
	}
	
	@Transactional
	@GetMapping(path = "/speech_user_id")
	public Iterable<SpeechEntity> findByUserId(@RequestParam Long userId){
		return speechRepository.findByUserId(userId);
	}
	
	
	@Transactional
	@GetMapping(path = "/speech_id")
	public SpeechEntity findBySpeechId(@RequestParam Long speechId){
		return speechRepository.findBySpeechId(speechId);
	}
	
	
}
