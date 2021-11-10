import React,{useState, useEffect} from 'react';
import './Dashboard.css';

function Dashboard(){
	
	const[fillerWordRatio, setFillerWordRatio] = useState("");
	const[speechRate, setSpeechRate] = useState("");
	const[fillerWordFrequency, setFillerWordFrequency] = useState("");
		
function Report(){	
	return(
		<div>
		<h3>Report</h3>
		<br />
		<label>Filler Word Breakdown: </label>
		<label>{fillerWordFrequency}</label>
		<br />
		<label>Filler Words Ratio: </label>
		<label>{fillerWordRatio}</label>
		<br />
		<label>Speech Rate: </label>
		<label>{speechRate}</label>
		<label> Words Per Minute </label>
		</div>
	);
}

function InputForm(props){
	const[textFile, setTextFile] = useState();
	const[speechFile, setSpeechFile] = useState();	
	const[speechId, setSpeechId] = useState();
	
	async function generateReport(){
		const textFileData = new FormData();
		textFileData.append("textFile", textFile);
		const speechFileData = new FormData();
		speechFileData.append("speechFile", speechFile);
        const response = await fetch(`/createSpeech?textFile=${encodeURIComponent(textFile.file)}&audioFile=${encodeURIComponent(speechFile.file)}`, {method: "GET"});
		const json = await response.json();
		setFillerWordFrequency(json.FillerFrequency);
		console.log(json.FillerRatio);
		setFillerWordRatio(json.FillerRatio);
		console.log(json.SpeechRate);
		setSpeechRate(json.SpeechRate);
	   // const response = await fetch(`/createSpeech?textFile=${textFileData}&audioFile=${speechFileData}`, {method: "POST"});
      //  console.log(response);
	//	console.log(response.json);
	//	await setSpeechId(response.json).then(res => {
			//getFeedback();
	//	})
    }

	async function getFeedback(){
		const response = await fetch(`/parseText?speechId=${0}`, {method: "GET"});
		console.log(response);
		const json = await response.json();
		console.log(json);
		console.log(json.WordFrequency);
		console.log(json.FillerFrequency);
		setFillerWordFrequency(json.FillerFrequency);
		console.log(json.FillerRatio);
		setFillerWordRatio(json.FillerRatio);
		console.log(json.SpeechRate);
		setSpeechRate(json.SpeechRate);
		
	}

	const handleSubmit= async(e) => {
	
      e.preventDefault();
	  await generateReport();
    }
	
	return(
		<form onSubmit={e => { handleSubmit(e) }}>
			<label>Upload the text file of your speech:</label>
			<br />
			<input type="file" onChange={e=> setTextFile(e.target.files[0])} />
			<br />
			<label>Upload the audio file of your speech:</label>
			<br />
			<input type="file" onChange={e=> setSpeechFile(e.target.files[0])} />
			<br />
			<input type='submit' value='Generate Report' />
		</form>
	);
}
	return(
		<div className="rowAlignment">
		<div> <InputForm /> </div>
		<div> <Report /> </div>
		</div>
	);
}

export default Dashboard;