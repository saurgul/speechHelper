import React from "react";
import GrammarImage from "./grammar.png"
import GrammarFeedbackItem from "./GrammarFeedBackItem";

function GrammarFeedback(prps) {

    const incorrect_correct = {
        "It were a rainy day today": "It was a rainy day today",
        "She have a gold retriever": "She has a golden retriever",
        "Everyone needs to bring their pencil.": "Everyone needs to bring his or her pencil."
    }

    return (
        <div className="grammar-feed-container">
            <div className="grammar-feed-flex">
                <div className="grammar-feed-header">
                    <div className="grammar-feed-header-text">The grammar seemed a little bit inaccurate. Here we improved it for you,</div>
                    <img src={GrammarImage} className="card-header-image"/>
                </div>
                <div className="grammar-items-container">
                    {
                        Object.keys(incorrect_correct).map((key, index) => ( 
                            <GrammarFeedbackItem correct = {incorrect_correct[key]} incorrect = {key}/> 
                        ))
                    }
                </div>
                <div className="view-all-btn-frame">
                    <div className="view-all-btn">View all</div>
                </div>
            </div>
        </div>


    );
}

export default GrammarFeedback;