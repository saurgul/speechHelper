import React,{useState, useEffect} from 'react';

function InputForm(props){
    const[textFile, setTextFile] = useState();
    const[speechFile, setSpeechFile] = useState();	
    const[speechId, setSpeechId] = useState();

    const[fillerWordRatio, setFillerWordRatio] = useState("");
	const[speechRate, setSpeechRate] = useState("");
	const[fillerWordFrequency, setFillerWordFrequency] = useState("");
	const API = "https://speech-helper-backend.herokuapp.com";
    
    async function generateReport(){
        const formData = new FormData();
        formData.append("files", textFile);
        //formData.append("files", speechFile);
        
        console.log(textFile.file)
        // console.log(speechFile.file)
        // console.log(textFile)
        // console.log(speechFile)
        const response = await fetch(API + `/createSpeech`, {method: "post",body: formData, headers: {
            'Access-Control-Allow-Origin':'*'
                }	
            }
        );
        //const response = await fetch(`/createSpeech?textFile=${encodeURIComponent(textFile)}&audioFile=${encodeURIComponent(speechFile)}`, {method: "GET"});
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
        const response = await fetch(API + `/parseText?speechId=${0}`, {method: "GET"});
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
        <form className="input-form" onSubmit={e => { handleSubmit(e) }}>
            <textarea id="story" name="story" rows="5" cols="33" > Type your text ... </textarea>
            <div>
            {(() => {
                if (speechFile == null) {
                    return (
                        <div>
                            <p>or</p>
                            <input type="file" name="file" id="file" className="inputfile" onChange={e=> setTextFile(e.target.files[0])} />
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
                if (textFile == null) {
                    return (
                        <div>
                            <p>or</p>
                            <input type="file" name="file1" id="file1" className="inputfile" onChange={e=> setSpeechFile(e.target.files[0])} />
                            <label for="file1" className="uploadButton">
                            {(() => {
                                if (speechFile != null) return "Uploaded";
                                else return "Upload an audio file";
                                }
                            )()}</label>
                        </div>
                    );
                }
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
            <input className="theme-btn generate-btn" type='submit' value='Generate'/>
    </form>
    );
}

export default InputForm;