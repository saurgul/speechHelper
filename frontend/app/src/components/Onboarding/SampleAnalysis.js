import React,{useState, useEffect} from 'react';
import FillerCard from "../Dashboard/FillerCard";
import PaceCard from "../Dashboard/PaceCard";
import { Animated } from 'react-animated-css';


function Analysis(props) {
    return (
        <Animated animationIn="bounceInRight" animationOut="bounceOutLeft">  
        <div>
            {/* <p className="analysis-title">Analysis</p> */}
            <div className="summary-container-child-pace-filler-row">
                   <FillerCard className="" fillerCount={props.fillerCount}/>
                   <PaceCard className="" pace = {props.pace}/>
            </div>
        </div> 
        </Animated>
    );

}

function SampleAnalysis(props) {

    return (
        <div>
             {(()=>{
                if (props.showReport) return  <Analysis fillerCount = {props.fillerCount} pace = {props.pace}/>
                else return <div className="analysis-item-empty">Your report will be shown here</div>
                }
            )()}
        </div>
    );
}

export default SampleAnalysis;