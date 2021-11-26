import React from "react";

function FillerCard(props) {
    return (
        <div className="filler-info-container">
            <div className="filler-text-container">
                <div className="filler-percent-text-container">
                    <div className="filler-percent-text">67</div>
                    <div className="filler-percent">%</div>
                </div>
                <div className="filler-text-message">
                    speech is 
                    <div className="filler-word-color">filler</div> 
                </div>
            </div>
        </div>
    );
}

export default FillerCard;