import React from "react";
import { useNavigate } from "react-router-dom";

function HistoryReportItem(props) {

    const navigate = useNavigate();
	
    const handleRoute = () => {
      navigate('/summary');
    }

    return (
        <div className="report-item-container">
            <div className="report-item">
                <div className="report-item-child">
                    <div className="report-item-left">
                        <div className="number-overlay">{props.num}</div>
                        <div className="history-speech-text-container">
                            <div className="history-speech-title">{props.speechTitle}</div>
                            <div className="history-speech-subtitle">Recorded: {props.speechDate}</div>
                        </div>
                    </div>
                    <button className="theme-btn summary-btn" onClick={handleRoute}>Go to Summary</button>
                </div>
                {/* <div className="separator"></div> */}
            </div>
        </div>

    );
} 

function HistoryReport(props) {

    return (
        <div className= "report-list-container">
            <p className="report-title">History</p>
            {(() => {

                if (Object.keys(props.historySpeeches).length == 0) {
                    return (
                        <div className="report-item-container-empty">
                          <div className="report-item-empty">Looks like you are new here,tap the generate button. All your reports will be shown here.</div>
                        </div> 
                    );
                }
                else {
                    return (
                        <div className="report-items-container">
                        {   
                            Object.keys(props.historySpeeches).map((key, index) => ( 
                                <HistoryReportItem num = {index+1} speechTitle = {key} speechDate = {props.historySpeeches[key]}/>  
                            ))
                        }
                        </div>
                    );
                }
            }
            )()}   
        </div>
    );
}

export default HistoryReport;