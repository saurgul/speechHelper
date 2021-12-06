import React from "react";
import Angry from "../Assets/angry.png";
import Sad from "../Assets/sad.png";
import Calm from "../Assets/calm.png";
import Fear from "../Assets/fear.png";
import Surprised from "../Assets/surprised.png";


function SentimentCard(props) {

    const reactionMessage = {
        "angry" : "You sounded anrgy, this kind of tone would distract your audience’s attention with a negative impact",
        "sad" : "You sounded sad, this kind of tone would distract your audience’s attention",
        "calm" : "You sounded calm, good for you!!!",
        "fearful" : "You sounded scared, this kind of tone would distract your audience’s attention",
        "surprised" : "You sounded surprised, this kind of tone would distract your audience’s attention"
    }

    return (
        <div className="sentiment-card-container">
            <img className="summary-reaction-img" src={(() => {
                switch (props.sentiment) {
                    case "sad": return Sad; break;
                    case "angry": return Angry; break;
                    case "calm": return Calm; break;
                    case "fearful": return Fear; break;
                    case "surprised": return Surprised; break;
                }
            }
            )()}/>
            <div className="summary-text">{reactionMessage[props.sentiment]}</div>
        </div>
    );
}

export default SentimentCard;