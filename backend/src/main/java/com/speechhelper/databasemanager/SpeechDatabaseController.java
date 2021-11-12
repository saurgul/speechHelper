package com.speechhelper.databasemanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class SpeechDatabaseController {
	@Autowired
	private SpeechRepository speechRepository;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(path="/add_speech") // Map ONLY POST Requests
	public String addNewSpeech (@RequestParam Long userId, @RequestParam String transcribedSpeechText, @RequestParam String convertedSpeechText) {
		SpeechEntity n = new SpeechEntity();
		n.setUserId(userId);
		n.setTranscribedSpeechText(transcribedSpeechText);
		n.setConvertedSpeechText(convertedSpeechText);
		speechRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all/speech")
	public Iterable<SpeechEntity> getAllSpeech() {
	    // This returns a JSON or XML with the users
	    return speechRepository.findAll();
	}
	
	@GetMapping(path = "/user_id/{:userId}")
	public Iterable<SpeechEntity> findByUserId(@Param("userId") Long userId){
		return speechRepository.findByUserId(userId);
	}
	
	@GetMapping(path = "/speech_id/{:speechId}")
	public SpeechEntity findBySpeechId(@Param("speechId") Long speechId){
		return speechRepository.findBySpeechId(speechId);
	}
	
	
}
