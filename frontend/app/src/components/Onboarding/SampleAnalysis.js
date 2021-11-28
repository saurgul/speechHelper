import React,{useState, useEffect} from 'react';
import FillerCard from "../Dashboard/FillerCard";
import PaceCard from "../Dashboard/PaceCard";


function Analysis(props) {
    return (
        <div>
            {/* <p className="analysis-title">Analysis</p> */}
            <div className="summary-container-child-pace-filler-row">
                   <FillerCard className="" fillerCount={props.fillerCount}/>
                   <PaceCard className="" pace = {props.pace}/>
            </div>
        </div> 
    );

}

function SampleAnalysis(props) {
    const pace = 112;
    const [showReport, setShow] = useState(false);
    const fillerCount = 13;

    const changeReport = () => {
        setShow(true);
    }

    return (
        <div>
             {(()=>{
                if (showReport) return  <Analysis fillerCount = {fillerCount} pace = {pace}/>
                else return <div className="analysis-item-empty">Your report will be shown here</div>
                }
            )()}
        </div>
    );
}

export default SampleAnalysis;