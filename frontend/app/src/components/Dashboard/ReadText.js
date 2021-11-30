import React from "react";
import Quote1 from "./Assets/quote1.png";
import Quote2 from "./Assets/quote2.png";

function ReadText(props) {
    return (
        <div className="read-text-container">
            <div className="read-text-header-text">Read out loud</div>
            <div className="read-text-child-frame">
                <img src={Quote1} className="read-text-child-frame-img"/> 
                <div className="read-text-speech-text">
                {props.texts[0].description}
                </div>
                <div className="read-text-child-frame-right-quote"> <img src={Quote2} className="read-text-child-frame-img"/></div>   
            </div>
            <div className="view-all-btn-frame">
                <div className="view-all-btn">View all</div>
            </div>
            
        </div>
    );
}

function didTapViewAll()
{
    document.getElementsByClassName("read-text-container")[0].style.width = "100%";

}

export default ReadText;