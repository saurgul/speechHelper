import React,{useState, useEffect} from 'react';
import PronounciationHeaderImage from "../Assets/pHeader.png"
import WordButton from "./WordButton";

function OverusedWordCard() {

    const words = {"ingenue": "", "isthmus" : "", "worchestershire" : "", "word1" : "","word2" : "", "word3": "", "ingenue1": "", "isthmus3" : "", "worchestershire4" : "", "word14" : "","word24" : "", "word34": ""};
    return (
        <div className="pronounciation-card-container">
            <div className="pronounciation-card-header-container">
                <img src={PronounciationHeaderImage} className="card-header-image"/>
                <div className="pronounciation-card-header-text">You are using these words too many times, try to not overuse :)</div>
            </div>
            <div className="pronounciation-card-item-container"> 
            {   
                Object.keys(words).map((key, index) => ( 
                    <WordButton word = {key}/> 
                ))
            }
            </div>
        </div>
    );

}

export default OverusedWordCard;