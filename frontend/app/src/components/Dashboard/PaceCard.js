import React from "react";
import Fastpace from "./fastpace.png"

function PaceCard(props) {
    return (
        <div className="pace-container">
            <div className="pace-info-container">
                <div className="pace-info-child-container">
                    <img src={Fastpace} className="pace-info-image"/>
                    <div className="pace-info-text">179</div>
                    <div className="pace-info-child-container1">
                        <div className="pace-info-subtext">wpm</div>
                    </div>
                </div>
                <div className="pace-info-message">your pace was too fast</div>
            </div>
        </div>
    );
}

export default PaceCard;