import React from "react";
import FamousSpeechImage from "./famousspeeches.png"
import PlayImage from "./play.png"

function FamousSpeechItem() {
    return (
        <div className="famous-list-item-container">
            <div className="famous-list-item-text">
                <div className="famous-list-item-text-title">Winston Churchil</div>
                <div className="famous-list-item-text-subtitle">Description of the speech</div>
            </div>
            <img src={PlayImage} className="famous-speech-item-image"/>
        </div>
    );
}



function FamousSpeeches() {

    return(
        <div className="famous-speech-container">
            <div className="famous-speech-header">
                <div className="famous-speech-header-text">
                    <div className="famous-speech-header-title">Famous Speeches</div>
                    <div className="famous-speech-header-subtitle">(Hear and practise)</div>
                </div>
                <img src={FamousSpeechImage} className="famous-speech-header-image"/>
            </div> 

            <FamousSpeechItem/>  
            <FamousSpeechItem/>  
            <FamousSpeechItem/>  
            <FamousSpeechItem/>  
            <FamousSpeechItem/>  
            <FamousSpeechItem/>  
            <FamousSpeechItem/>  
            <FamousSpeechItem/>  
        </div>  
    );
}

export default FamousSpeeches;