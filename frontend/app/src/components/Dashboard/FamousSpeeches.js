import React from "react";
import FamousSpeechImage from "./Assets/famousspeeches.png"
import PlayImage from "./Assets/play.png"

function FamousSpeechItem(props) {
    return (
        <div className="famous-list-item-container">
            <div className="famous-list-item-text">
                <div className="famous-list-item-text-title">{props.speech}</div>
                <div className="famous-list-item-text-subtitle">Description of the speech</div>
            </div>
            <img src={PlayImage} className="famous-speech-item-image"/>
        </div>
    );
}



function FamousSpeeches(props) {

    const speeches = {
        "Winston Churchil" : "",   
        "Barack Obama" : "",   
        "Martin Luther King Jr" : "",
        "Daniel Webster" : "",
    }

    return(
        <div className="famous-speech-container">
            <div className="famous-speech-header">
                <div className="famous-speech-header-text">
                    <div className="famous-speech-header-title">Famous Speeches</div>
                    <div className="famous-speech-header-subtitle">(Hear and practise)</div>
                </div>
                <img src={FamousSpeechImage} className="famous-speech-header-image"/>
            </div> 
            {   
                Object.keys(speeches).map((key, index) => ( 
                    <FamousSpeechItem speech = {key}/>  
                ))
            }
        </div>  
    );
}

export default FamousSpeeches;