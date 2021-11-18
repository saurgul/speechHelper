import React,{useState, useEffect} from 'react';
import './Dashboard.css';
import Header from './Header'
import HistoryReport from './HistorySpeech';
import InputForm from './InputForm';


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
							<InputForm />
							<HistoryReport/>
						</div>
						
					</div>
			</div>
			</div>
		</div>
	);
}

export default Dashboard;