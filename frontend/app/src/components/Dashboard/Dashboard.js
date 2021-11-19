import React,{useState, useEffect} from 'react';
import './Dashboard.css';
import FamousSpeeches from './FamousSpeeches';
import Header from './Header'
import HistoryReport from './HistorySpeech';
import InputForm from './InputForm';
import ReadText from './ReadText';


function Dashboard({onClick}){
	return(
		<div>
		<div> <Header/> </div>
		{/* <div className="rowAlignment">
		<div className = "child"> <InputForm /> </div>
		<div> <Report /> </div>
		</div> */}
			<div className="mainContainer">
				<div className= "bgCard">
					<div className="dashboard-container">
						<div className="dashboard-container-child">
							<ReadText />
							<FamousSpeeches/>
						</div>
						
					</div>
			</div>
			</div>
		</div>
	);
}

export default Dashboard;