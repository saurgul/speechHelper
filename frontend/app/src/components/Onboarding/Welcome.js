import React,{useState, useEffect} from 'react';
import './Welcome.css';
import WelcomeHeader from './WelcomeHeader'
import InputForm from '../Dashboard/InputForm';
import SampleAnalysis from './SampleAnalysis';


function Welcome() {

	const [pace, updatePace] = useState(0);
    const [showReport, setShow] = useState(false);
    const [fillerCount, updateCount] = useState(0);

    const changeReport = () => {
        setShow(true);
    }

	const updateFieldFromAnalysis = (p, fC) => {
		updateCount(fC);
		updatePace(p);
	}

	return(
		<div>
		<div> <WelcomeHeader/> </div>
		<div className="mainContainer">
			<div className= "welcome-bg">
				<div className="dashboard-container">
					<div className="dashboard-container-child">
						<InputForm changeReport = {changeReport} update = {updateFieldFromAnalysis}/>
						<SampleAnalysis pace = {pace} showReport = {showReport} fillerCount = {fillerCount} changeReport = {changeReport}/>
					</div>
				</div>
			</div>
		</div>
		</div>
	);
}
	

export default Welcome;