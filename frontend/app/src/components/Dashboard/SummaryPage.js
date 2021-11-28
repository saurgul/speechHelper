import React from "react";
import "./Summary.css";
import PronounciationCard from "./PronounciationCard";
import FillerCard from "./FillerCard";
import PaceCard from "./PaceCard";
import GrammarFeedback from "./GrammarFeedback";
import SummaryPageHeader from "./SummaryPageHeader";
import { Animated } from "react-animated-css";


function SummaryPage() {
    const name = "Joshua";
    const score = "55";

    const fillerCount = 15;
    const pace = 179;
    return (
        <Animated animationIn="rotateIn" animationOut="rotateOut">  
            <div className="mainContainer">
                <div className="bgCard"> 
                    <SummaryPageHeader name = {name} score = {score}/>
                    <div className="summary-container-child">
                        <div className="summary-container-child-col">
                            <PronounciationCard/>
                            <div className="summary-container-child-pace-filler-row">
                                <FillerCard fillerCount={fillerCount}/>
                                <PaceCard pace = {pace}/>
                            </div>
                        </div>
                        <div className="summary-container-child-col">
                            <GrammarFeedback/>
                        </div>
                    </div>
                </div>
            </div>
        </Animated>
       
    );
}


export default SummaryPage;