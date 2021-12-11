import React,{useState, useEffect} from 'react';

function InputForm(props){
    const[textFile, setTextFile] = useState();
	const[textArea, setTextArea] = useState();
    const[speechFile, setSpeechFile] = useState();	
    const[speechId, setSpeechId] = useState();

    const[fillerWordRatio, setFillerWordRatio] = useState("");
	const[speechRate, setSpeechRate] = useState("");
	const[fillerWordFrequency, setFillerWordFrequency] = useState("");
	/*const API = "https://speech-helper-backend.herokuapp.com"; */
    const API = "http://localhost:8080/"

    function handleErrors(response) {
		if (!response.ok) {
			throw Error(response.statusText);
		}
		return response;
	}
	
	const generateReport = async() => {
        const formData = new FormData();
        formData.append("files",speechFile);
        formData.append("files",textFile);

		fetch(`/createSpeech`, {
            method: "POST",
            body: formData, 
            headers: {
            'Access-Control-Allow-Origin':'*',
            'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS'
                }	
            }
        )
		.then(handleErrors)
		.then(async response => {
            const data = await response.json();
            setFillerWordFrequency(data.FillerFrequency);
            console.log(data.FillerRatio);
            setFillerWordRatio(data.FillerRatio);
            console.log(data.SpeechRate);
            setSpeechRate(data.SpeechRate);
		})
		.catch(error => console.log(error) );
	}
    
    const getFeedback = async() => {
        fetch(API + `/parseText?speechId=${0}`, {
            method: "GET"
        })
        .then(handleErrors)
        .then(async response => {
            const data = await response.json();
            console.log(data);
            console.log(data.WordFrequency);
            console.log(data.FillerFrequency);
            setFillerWordFrequency(data.FillerFrequency);
            console.log(data.FillerRatio);
            setFillerWordRatio(data.FillerRatio);
            console.log(data.SpeechRate);
            setSpeechRate(data.SpeechRate);
		})
		.catch(error => console.log(error) );
    }

    const handleSubmit = async(e) => {
        e.preventDefault();
        if (!props.userLoggedIn) {
            const formData = new FormData();
            formData.append("files",textFile);
            formData.append("files",speechFile);
            const response = await fetch(`/createSpeechWelcomePage`, {method: "post",body: formData, headers: {'Access-Control-Allow-Origin':'*'}});
            const json = await response.json();
            props.changeReport();
            props.update(json.FillerRatio,json.SpeechRate, json.Sentiment);
        }
        if (props.userLoggedIn){
            await generateReport();
            //pass all the values to the dashboard
        }
    }
    
    return(
        <form className="input-form" onSubmit={e => { handleSubmit(e) }}>
			<div>
			{(() => {
                    if (textFile == null){
                        return (
                            <div>
                                <textarea id="story" name="story" rows="5" cols="33" onChange={e => setTextArea(e.target.value)}> Type your text ... </textarea>
                            </div> 
                        );
                    }
			    }
            )()}
			</div>
			<div>
			{(() => {
                    if(textFile == null && textArea == null){
                        return(
                            <p>or</p>
                        );
                    }
			    }
			)()}
			</div>
            <div>
            {(() => {
                if (textArea == null) {
                    return (
                        <div>
                            <input type="file" name="file" id="file" className="inputfile" onChange={e=> setTextFile(e.target.files[0])} required/>
                            <label for="file" className="uploadButton">
                            {(() => {
                                if (textFile != null) return "Uploaded";
                                else return "Upload a text file";
                                }
                            )()}
                            </label>
                        </div>
                    );
                }
            }
            )()}
            </div>
            <br/>
            <div>
            {(() => {
                    return (
                        <div>
                            <input type="file" name="file1" id="file1" className="inputfile" onChange={e=> setSpeechFile(e.target.files[0])} required/>
                            <label for="file1" className="uploadButton">
                            {(() => {
                                if (speechFile != null) return "Uploaded";
                                else return "Upload an audio file";
                                }
                            )()}</label>
                            {(() => {
                                if (speechFile == null && props.userLoggedIn) return (
                                    <div>
                                        <p>or</p>
                                         <label className="uploadButton" onClick={(e) => props.showRecordAudioModal(true)}>Record Live Audio</label>
                                    </div>
                                ) 
                                }
                            )()}
                        </div>
                    );
            }
            )()}
            </div>
            {/* <input type="file" onChange={e=> setTextFile(e.target.files[0])} /> */}
            <br />
            <br />
            {/* <label>Upload the audio file of your speech:</label>
            <br />
            <input type="file" onChange={e=> setSpeechFile(e.target.files[0])} />
            <br /> */}
            <input className="theme-btn generate-btn"  type='submit' value='Generate'/>
    </form>
    );
}

export default InputForm;