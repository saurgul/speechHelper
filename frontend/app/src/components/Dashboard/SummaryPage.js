import React from "react";
import "./Summary.css";
import PronounciationCard from "./PronounciationCard";
import FillerCard from "./FillerCard";
import PaceCard from "./PaceCard";
import GrammarFeedback from "./GrammarFeedback";
import SummaryPageHeader from "./SummaryPageHeader";


function SummaryPage(props) {
    const name = "Joshua";
    const score = "55";

    const fillerCount = 10;
    const pace = 123;
    return (
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
       
    );
}


export default SummaryPage;