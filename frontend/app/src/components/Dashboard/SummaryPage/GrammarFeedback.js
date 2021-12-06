import React from "react";
import GrammarImage from "../Assets/grammar.png"
import GrammarFeedbackItem from "./GrammarFeedBackItem";

function GrammarFeedback(props) {

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
                <div>
                    <div className="view-all-btn-frame" onClick={(e) => {props.didTapViewAll(!props.showAllGrammar)}}>
                        <div className="view-all-btn">
                        {(() => {
                            if (!props.showAllGrammar) return "View All"
                            else return "View Less"
                        }
                        )()}
                        </div>
                    </div>    
                </div> 
            </div>
        </div>


    );
}

export default GrammarFeedback;