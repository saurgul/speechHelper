import React from "react";
import GrammarImage from "../Assets/grammar.png"
import GrammarFeedbackItem from "./GrammarFeedBackItem";
import Correct from "../Assets/correct.png"

function GrammarFeedback(props) {
    return (
        <div className="grammar-feed-container">
            <div className="grammar-feed-flex">
                <div className="grammar-feed-header">
                    <div className="grammar-feed-header-text">
                        {(() => {
                            if (Object.keys(props.incorrect_correct).length === 0) return "There were no grammar or speeling mistakes! Keep it going bestie!";
                            else return "The grammar seemed a little bit inaccurate. Here we improved it for you,";
                        }
                        )()}
                        </div>
                    <img className="card-header-image" src=
                     {(() => {
                        if (Object.keys(props.incorrect_correct).length === 0) return Correct;
                        else return GrammarImage;
                    }
                    )()} alt ="Header Image"/>
                </div>
                <div className="grammar-items-container">
                    {
                        Object.keys(props.incorrect_correct).map((key, index) => ( 
                            <GrammarFeedbackItem correct = {props.incorrect_correct[key]} incorrect = {key}/> 
                        ))
                    }
                </div>
                <div>
                    {(() => {
                        if (Object.keys(props.incorrect_correct).length !== 0) {
                            return (
                            <div className="view-all-btn-frame" onClick={(e) => {props.didTapViewAll(!props.showAllGrammar)}}>
                                <div className="view-all-btn">
                                {(() => {
                                    if (!props.showAllGrammar) return "View All"
                                    else return "View Less"
                                }
                                )()}
                                </div>
                            </div>  
                            );
                        }
                    }
                    )()}
                </div> 
            </div>
        </div>


    );
}

export default GrammarFeedback;