import React, { useState } from "react";
import "../CSS/Summary.css";
import PronounciationCard from "./PronounciationCard";
import FillerCard from "./FillerCard";
import PaceCard from "./PaceCard";
import GrammarFeedback from "./GrammarFeedback";
import SummaryPageHeader from "./SummaryPageHeader";
import { Animated } from "react-animated-css";
import SentimentCard from "./SentimentCard";


function SummaryPage() {
    const name = "Joshua";
    const score = "55";
    const sentiment = "Calm"
    const fillerCount = 15;
    const pace = 179;

    const [showAllGrammar, setViewAll] = useState(false);
    
    const didTapViewAll = (show) => {
        setViewAll(show)
    }

    return (
        <Animated animationIn="rotateIn" animationOut="rotateOut">  
            <div className="mainContainer">
                <div className="bgCard"> 
                    <SummaryPageHeader name = {name} score = {score}/>
                    <div className="summary-container-child">
                    {(() => {
                            if (!showAllGrammar) {
                                return (
                                    <div className="summary-container-child-col">
                                        <PronounciationCard/>
                                        <div className="summary-container-child-pace-filler-row">
                                            <FillerCard fillerCount={fillerCount}/>
                                            <PaceCard pace = {pace}/>
                                        </div>
                                        <SentimentCard sentiment = {sentiment}/>
                                    </div>
                                );
                            }
                        }
                    )()}
                        <div className="summary-container-child-col">
                            <GrammarFeedback showAllGrammar = {showAllGrammar}  didTapViewAll={didTapViewAll}/>
                        </div>
                    </div>
                </div>
            </div>
        </Animated>
    );
}


export default SummaryPage;