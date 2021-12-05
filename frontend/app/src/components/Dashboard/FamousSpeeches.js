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
            <img src={PlayImage} className="famous-speech-item-image" onClick={(e) => {props.updateSpeech(props.text)}}/>
        </div>
    );
}



function FamousSpeeches(props) {

    const speeches = {
        "Winston Churchil" : "The British Empire and the French Republic, linked together in their cause and in their need, will defend to the death their native soil, aiding each other like good comrades to the utmost of their strength. \n\n Even though large tracts of Europe and many old and famous states have fallen or may fall into the grip of the Gestapo and all the odious apparatus of Nazi rule, we shall not flag or fail. \n We shall go on to the end, we shall fight in France, we shall fight on the seas and oceans, we shall fight with growing confidence and growing strength in the air, we shall defend our island, whatever the cost may be. \n We shall fight on the beaches, we shall fight on the landing grounds, we shall fight in the fields and in the streets, we shall fight in the hills; we shall never surrender, and even if, which I do not for a moment believe, this island or a large part of it were subjugated and starving, then our Empire beyond the seas, armed and guarded by the British fleet, would carry on the struggle, until, in God's good time, the new world, with all its power and might, steps forth to the rescue and the liberation of the old.",   
        "Barack Obama" : "Don’t tell me words don’t matter. I have a dream – just words words. We hold these truths to be self evident that all men are created equal – just words. We have nothing to fear but fear itself – just words, just speeches. It’s true that speeches don’t solve all problems, but what is also true is that if we can’t inspire our country to believe again, then it doesn’t matter how many policies and plans we have, and that is why I’m running for president of the United States of America, and that’s why we just won 8 elections straight because the American people want to believe in change again. Don’t tell me words don’t matter!",   
        "Martin Luther King Jr" : `...and so even though we face the difficulties of today and tomorrow, I still have a dream. It is a dream deeply rooted in the American dream. I have a dream that one day this nation will rise up and live out the true meaning of its creed: We hold these truths to be self-evident, that all men are created equal. I have a dream that one day on the red hills of Georgia, the sons of former slaves and the sons of former slave owners will be able to sit down together at the table of brotherhood. I have a dream that one day even the state of Mississippi, a state sweltering with the heat of injustice, sweltering with the heat of oppression, will be transformed into an oasis of freedom and justice. I have a dream that my four little children will one day live in a nation where they will not be judged by the color of their skin but by the content of their character. I have a dream today! I have a dream that one day, down in Alabama, with its vicious racists, with its governor having his lips dripping with the words of interposition and nullification -- one day right there in Alabama little black boys and black girls will be able to join hands with little white boys and white girls as sisters and brothers. I have a dream today! I have a dream that one day every valley shall be exalted, and every hill and mountain shall be made low, the rough places will be made plain, and the crooked places will be made straight.
        and the glory of the Lord shall be revealed and all flesh shall see it together. \
        ...and so let freedom ring from the prodigious hilltops of New Hampshire. Let freedom ring from the mighty mountains of New York. \
        Let freedom ring from the heightening Alleghenies of Pennsylvania. \
        Let freedom ring from the snow-capped Rockies of Colorado. \
        Let freedom ring from the curvaceous slopes of California. But not only that: \
        Let freedom ring from Stone Mountain of Georgia. \
        Let freedom ring from Lookout Mountain of Tennessee. Let freedom ring from every hill and molehill of Mississippi. From every mountainside, let freedom ring. \
        And when this happens, when we allow freedom ring, when we let it ring from every village and every hamlet, from every state and every city, we will be able to speed up that day when all of God's children, black men and white men, Jews and Gentiles, Protestants and Catholics, will be able to join hands and sing in the words of the old Negro spiritual: \
        Free at last! Free at last! \
        Thank God Almighty, we are free at last! ` ,
        "Daniel Webster" : `Mr. President, - I wish to speak to-day, not as a Massachusetts man, nor as a Northern man, but as an American, and a member of the Senate of the United States. It is fortunate that there is a Senate of the United States; a body not yet moved from its propriety, not lost to a just sense of its own dignity and its own high responsibilities, and a body to which the country looks, with confidence, for wise, moderate, patriotic, and healing counsels. It is not to be denied that we live in the midst of strong agitations, and are surrounded by very considerable dangers to our institutions and our government. The imprisoned winds are let loose. The East, the North, and the stormy South combine to throw the whole sea into commotion, to toss its billows to the skies, and disclose its profoundest depths. I do not affect to regard myself, Mr. President, as holding, or as fit to hold, the helm in this combat with the political elements; but I have a duty to perform, and I mean to perform it with fidelity, not without a sense of existing dangers, but not without hope. I have a part to act, not for my own security or safety, for I am looking out for no fragment upon which to float away from the wreck, if wreck there must be, but for the good of the whole, and the preservation of all; and there is that which will keep me to my duty during this struggle, whether the sun and the stars shall appear, or shall not appear for many days. I speak to-day for the preservation of the Union. "Hear me for my cause." I speak to-day, out of a solicitous and anxious heart for the restoration to the country of that quiet and harmonious harmony which make the blessings of this Union so rich, and so dear to us all. These are the topics I propose to myself to discuss; these are the motives, and the sole motives, that influence me in the wish to communicate my opinions to the Senate and the country; and if I can do any thing, however little, for the promotion of thse ends, I shall have accomplished all that I expect...`,
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
                    <FamousSpeechItem speech = {key} text = {speeches[key]} updateSpeech = {props.updateSpeech}/>  
                ))
            }
        </div>  
    );
}

export default FamousSpeeches;