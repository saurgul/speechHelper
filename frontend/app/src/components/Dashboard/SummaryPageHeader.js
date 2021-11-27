import React from "react";
import BackButton from "./backButton.png"

function SummaryPageHeader(props) {
    return (
        <div className="summary-page-bg-header">
            <div className="summary-page-header-left">
                <img src = {BackButton} className="back-button-img"/>
                <div className="summary-page-header-text-container">
                    <div className="summary-page-header-title">Hello {props.name}</div>
                    <div className="summary-page-header-subtitle">We have the following suggestions for you: </div>
                </div>
            </div>
            <div className="summary-page-header-overall-score">
                <div className="summary-page-header-overall-score-left">Your overall score</div>
                <div className="summary-page-header-overall-score-right">
                    <div className={props.score < 60 ? 'summary-page-header-overall-score-right-score-red' : "summary-page-header-overall-score-right-score-green"} >{props.score}</div>
                    <div className="summary-page-header-overall-score-right-overall">/100</div>
                </div>       
            </div>
        </div>
    );
}

export default SummaryPageHeader;