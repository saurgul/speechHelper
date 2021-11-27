import React,{useState, useEffect} from 'react';
import './Dashboard.css';
import FamousSpeeches from './FamousSpeeches';
import Header from './Header'
import HistoryReport from './HistorySpeech';
import InputForm from './InputForm';
import ReadText from './ReadText';

import {Animated} from "react-animated-css";
import EmptyProgress from './EmptyProgress';
import FillerCard from './FillerCard';
import PaceCard from './PaceCard';
import PronounciationCard from './PronounciationCard';

function Dashboard({onClick}){
	const [showHelp, setShow] = useState(false);
	const [showProgress, setProgress] = useState(false);
	const text = {
		id: "1",
		description: "I have a dream that one day down in Alabama, with its vicious racists, with its governor having his lips dripping with the words of interposition and nullification – one day right there in Alabama little black boys and black girls will be able to join hands with little white boys and white girls as sisters and brothers. I have a dream today. I have a dream that one day every valley shall be exalted and every hill and mountain shall be made low, the rough places will be made plain, and the crooked places will be made straight, and the glory of the Lord shall be revealed and all flesh shall see it together."
	}

	const texts = [text];

	const changeHelp = (show) => {
		setShow(show);
		setProgress(!show);
	}

	const reset = (show) => {
		setProgress(show);
		setShow(show);
	}

	const changeProgress = (show) => {
	    setProgress(show);
		setShow(!show);
	}

	return(
		<div>
		<div> <Header changeHelp={changeHelp} showHelp={showHelp} changeProgress = {changeProgress}  showProgress = {showProgress} reset = {reset}/> </div>
		{/* <div className="rowAlignment">
		<div className = "child"> <InputForm /> </div>
		<div> <Report /> </div>
		</div> */}
			<div className="mainContainer">
				<div className= "bgCard">
					<div className="dashboard-container">
						{
							!showProgress && !showHelp && 
							<div className="dashboard-container-child">
							<Animated animationIn="rotateOut" animationOut="rotateIn" isVisible={showHelp}>  
								<InputForm />
							</Animated> 
							<Animated animationIn="rotateOut" animationOut="rotateIn" isVisible={showHelp}>  
								<HistoryReport/>
							</Animated> 
							</div>
						}
						{
							!showProgress && showHelp && 
							<div className="dashboard-container-child">
								<Animated animationIn="fadeOut" animationOut="fadeIn" isVisible={!showHelp}>  
									<ReadText texts = {texts}/>
								</Animated> 
								<Animated animationIn="fadeOut" animationOut="fadeIn" isVisible={!showHelp}>  
									<FamousSpeeches/>
								</Animated> 
							</div>
						}

						{
						  showProgress &&
							<Animated animationIn="fadeOut" animationOut="fadeIn" isVisible={!showProgress}>  
								<HistoryReport/>
							</Animated> 
						}

					</div>
				</div>
			</div>
		</div>
	);
}

export default Dashboard;