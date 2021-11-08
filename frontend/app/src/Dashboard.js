import React,{useState, useEffect} from 'react';
import './Dashboard.css';

function Dashboard(){
	
	const[fillerWordRatio, setFillerWordRatio] = useState("0");
	const[speechRate, setSpeechRate] = useState("0");
		
function Report(){	
	return(
		<div>
		<h3>Report</h3>
		<br />
		<label>Filler Words Ratio: </label>
		<label>{fillerWordRatio}</label>
		<br />
		<label>Speech Rate: </label>
		<label>{speechRate}</label>
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
       // const response = await fetch(`/createSpeech?textFile=${encodeURIComponent(textFile.file)}&audioFile=${encodeURIComponent(speechFile.file)}`, {method: "GET"});
	   // const response = await fetch(`/createSpeech?textFile=${textFileData}&audioFile=${speechFileData}`, {method: "POST"});
      //  console.log(response);
	//	console.log(response.json);
	//	await setSpeechId(response.json).then(res => {
			getFeedback();
	//	})
    }

	async function getFeedback(){
		const response = await fetch(`/parseText?speechId=${0}`, {method: "GET"});
		console.log(response);
		const json = await response.json();
		console.log(json);
		console.log(json.data)
		console.log(json.WordFrequency);
		console.log(json.FillerFrequency);
		console.log(json.FillerRatio);
		console.log(json.SpeechRate);
	}

	const handleSubmit= async(e) => {
		//upload files to database and call functions to generate report
      console.log(textFile.name);
	  console.log(speechFile.name);
	  await generateReport();
		//set actual values after generating the values
	  setFillerWordRatio("3:100");
	  setSpeechRate("80 words /min")
      e.preventDefault();
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