import React,{useState, useEffect} from 'react';
import './Welcome.css';
import WelcomeHeader from './WelcomeHeader'
import InputForm from '../Dashboard/InputForm';
import SampleAnalysis from './SampleAnalysis';

function Welcome() {
	
	return(
		<div>
		<div> <WelcomeHeader/> </div>
		<div className="mainContainer">
			<div className= "welcome-bg">
				<div className="dashboard-container">
					<div className="dashboard-container-child">
						<InputForm />
						<SampleAnalysis/>
					</div>
				</div>
			</div>
		</div>
		</div>
	);
}
	

export default Welcome;