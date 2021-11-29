import React,{useState, useEffect} from 'react';
import PronounciationHeaderImage from "./pHeader.png"
import PronounciationButton from "./PronounciationButton";
import DownArrow from "./downarrow.png";

function PronounciationCard() {

    const [show, setShow] = useState(true); 
    const words = {"ingenue": "", "isthmus" : "", "worchestershire" : ""};

    const changeArrow = (show) => {
        if (show) {
            document.getElementsByClassName("pronounciation-card-container")[0].style.height = "672px";
            document.getElementsByClassName("pace-container")[0].style.display = "None";
            document.getElementsByClassName("filler-info-container")[0].style.display = "None";
        } 
        else {
            document.getElementsByClassName("pronounciation-card-container")[0].style.height = "280px";
            document.getElementsByClassName("pace-container")[0].style.display = "flex";
            document.getElementsByClassName("filler-info-container")[0].style.display = "flex";
        }
        setShow(!show);
    }

    return (
        <div className="pronounciation-card-container">
            <div className="pronounciation-card-header-container">
                <img src={PronounciationHeaderImage} className="card-header-image"/>
                <div className="pronounciation-card-header-text">Try working on these words, tap the play icon to see how they are correctly pronounced</div>
            </div>
            <div className="pronounciation-card-item-container"> 
            {   
                Object.keys(words).map((key, index) => ( 
                    <PronounciationButton word = {key}/> 
                ))
            }
            </div>
            <div className="arrow-btn">
                <img src={DownArrow} onClick={changeArrow}/>
            </div>
        </div>
    );

}

export default PronounciationCard;