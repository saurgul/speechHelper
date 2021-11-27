import React from "react";
import Fastpace from "./fastpace.png"
import Slowpace from "./slowPace.png"
import Normalpace from "./normalPace.png"

function PaceCard(props) {
    return (
        <div className="pace-container">
            <div className="pace-info-container">
                <div className="pace-info-child-container">
                    <img src={props.pace > 170 ? Fastpace : (props < 110) ? Slowpace : Normalpace} className={props.pace > 170 ? "pace-info-transform pace-info-image" : "pace-info-image"}/>
                    <div className={(() => {
                        if (props.pace > 170) return "text-red pace-info-text";
                        else if (props.pace < 110 )return "text-red pace-info-text";
                        else return  "text-green pace-info-text";
                        }
                    )()}>{props.pace}</div>
                    <div className="pace-info-child-container1">
                        <div className={props.pace > 170 ? "text-red pace-info-subtext" : "text-green pace-info-subtext"}>wpm</div>
                    </div>
                </div>
                <div className="pace-info-message">
                    {(() => {
                        if (props.pace > 170)return "your pace was too fast";
                        else if (props.pace < 110 )return "your pace was too slow";
                        else return  "your pace was normal";
                        }
                    )()}
                </div>
            </div>
        </div>
    );
}

export default PaceCard;