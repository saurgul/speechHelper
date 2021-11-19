import React from "react";
import Quote1 from "./quote1.png";
import Quote2 from "./quote2.png";

function ReadText(texts) {
    return (
        <div className="read-text-container">
            <div className="read-text-header-text">Read out loud</div>
            <div className="read-text-child-frame">
                <img src={Quote1} className="read-text-child-frame-img"/> 
                <div className="read-text-speech-text">
                I have a dream that one day down in Alabama, with its vicious racists, with its governor having his lips dripping with 
                the words of interposition and nullification – one day right there in Alabama little black boys and black girls will be
                able to join hands with little white boys and white girls as sisters and brothers.I have a dream today.
                <br/>
                <br/>
                I have a dream that 
                <br/>
                <br/>
                One day every valley shall be exalted and every hill and mountain shall be made low, the rough places will be made plain, 
                and the crooked places will be made straight, and the glory of the Lord shall be revealed and all flesh shall see it together.
                </div>
                <div className="read-text-child-frame-right-quote"> <img src={Quote2} className="read-text-child-frame-img"/></div>   
            </div>
            <div className="read-text-child-view-all-btn-frame" onClick={didTapViewAll}>
                <div className="read-text-child-view-all-btn">View all</div>
            </div>
            
        </div>
    );
}

function didTapViewAll()
{
    document.getElementsByClassName("ead-text-header-text")[0].style.color = "red";
}

export default ReadText;