import React,{useState, useEffect} from 'react';
import PronounciationHeaderImage from "../Assets/pHeader.png"
import WordButton from "./WordButton";
import heart from "../Assets/heart.png"

function OverusedWordCard(props) {

    return (
        <div className="pronounciation-card-container">
            <div className="pronounciation-card-header-container">
                <img className="card-header-image" src={(() => {
                    if (Object.keys(props.overused).length != 0) return PronounciationHeaderImage;
                    else return heart;
                }
                )()}/>
                <div className="pronounciation-card-header-text">
                {(() => {
                        if (Object.keys(props.overused).length == 0) return "You have a way with words!";
                        else return "You are using these words too many times, try to not overuse :)";
                    }
                )()}
                </div>
            </div>
            <div className="pronounciation-card-item-container"> 
            {   
                Object.keys(props.overused).map((key, index) => ( 
                    <WordButton word = {key}/> 
                ))
            }
            </div>
        </div>
    );

}

export default OverusedWordCard;