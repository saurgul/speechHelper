import React from "react";

function HistoryReportItem(props) {
    return (
        <div className="report-item-container">
            <div className="report-item">
                <div className="report-item-child">
                    <div className="report-item-left">
                        <div className="number-overlay">1</div>
                        <div className="history-speech-text-container">
                            <div className="history-speech-title">Speech 1</div>
                            <div className="history-speech-subtitle">Recorded: 11/10/2021</div>
                        </div>
                    </div>
                    <div className="report-item-right">
                        <button className="theme-btn summary-btn">Go to Summary </button>
                    </div>
                </div>
            </div>
            <div className="separator"></div>
        </div>

    );
} 

function HistoryReport(props) {
    return (
        <div className= "report-list-container">
            <p className="report-title">History</p>
             {/* only show when no speeches is empty */}
            {/* <div className="report-item-container-empty">
                <div className="report-item-empty">Looks like you are new here,tap the generate button. All you reports will be shown here.</div>
            </div> */}
            {/* TODO: else show the speeches, iterate over speeches*/}
            <div className="report-items-container">
                <HistoryReportItem/>
                <HistoryReportItem/>
                <HistoryReportItem/>
                <HistoryReportItem/>
                <HistoryReportItem/>
            </div>
        </div>
    );
}

export default HistoryReport;