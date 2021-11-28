import React from "react";
import Angry from "../Assets/angry.png";
import Sad from "../Assets/sad.png";
import Calm from "../Assets/calm.png";
import Fear from "../Assets/fear.png";
import Surprised from "../Assets/surprised.png";


function SentimentCard(props) {

    const reactionMessage = {
        "Angry" : "You sounded anrgy, this kind of tone would distract your audience’s attention with a negative impact",
        "Sad" : "You sounded sad, this kind of tone would distract your audience’s attention",
        "Calm" : "You sounded calm, good for you!!!",
        "Fear" : "You sounded scared, this kind of tone would distract your audience’s attention",
        "Surprised" : "You sounded surprised, this kind of tone would distract your audience’s attention"
    }

    return (
        <div className="sentiment-card-container">
            <img className="summary-reaction-img" src={(() => {
                switch (props.sentiment) {
                    case "Sad": return Sad; break;
                    case "Angry": return Angry; break;
                    case "Calm": return Calm; break;
                    case "Fear": return Fear; break;
                    case "Surprised": return Surprised; break;
                }
            }
            )()}/>
            <div className="summary-text">{reactionMessage[props.sentiment]}</div>
        </div>
    );
}

export default SentimentCard;