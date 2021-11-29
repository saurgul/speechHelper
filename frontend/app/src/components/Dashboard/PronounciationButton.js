import React from "react";
import Play from "./playWhite.png";

function PronounciationButton(props) {

    return (
        <div className="pronounciation-button-container">
            <div className="pronounciation-button-info-container">
                <div className="pronounciation-button-text">{props.word}</div>
                <img src={Play} className="pronounciation-button-img"/>
            </div>
        </div>
        
    );
}

export default PronounciationButton;