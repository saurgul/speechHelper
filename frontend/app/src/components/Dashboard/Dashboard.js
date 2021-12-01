import React,{useState, useEffect} from 'react';
import './CSS/Dashboard.css';
import FamousSpeeches from './FamousSpeeches';
import Header from './Header'
import HistoryReport from './HistorySpeech';
import InputForm from './InputForm';
import ReadText from './ReadText';
import {Animated} from "react-animated-css";
import ProgressChart from './ProgressChart';


function Dashboard(){
	const [showHelp, setShow] = useState(false);
	const [showProgress, setProgress] = useState(false);
	const [speechText, setSpeech] = useState("I have a dream that one day down in Alabama, with its vicious racists, with its governor having his lips dripping with the words of interposition and nullification – one day right there in Alabama little black boys and black girls will be able to join hands with little white boys and white girls as sisters and brothers. I have a dream today. I have a dream that one day every valley shall be exalted and every hill and mountain shall be made low, the rough places will be made plain, and the crooked places will be made straight, and the glory of the Lord shall be revealed and all flesh shall see it together.") 

	const updateSpeech = (newSpeech) => {
		console.log("Hello")
		setSpeech(newSpeech)
	}

	const data = [
		{ label: "Jan", x: 0, y: 5 },
		{ label: "Feb", x: 1, y: 10 },
		{ label: "Mar", x: 2, y: 46 },
		{ label: "Jun", x: 3, y: 50 },
		{ label: "Jul", x: 4, y: 55 },
		{ label: "Aug", x: 5, y: 40 },
		{ label: "Sep", x: 6, y: 98 }
	];

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
			<div className="mainContainer">
				<div className= "bgCard">
					<div className="dashboard-container">
						{
							!showProgress && !showHelp && 
							<div className="dashboard-container-child">
								<InputForm />	
								<HistoryReport/>
							</div>
						}
						{
							!showProgress && showHelp && 
							<div className="dashboard-container-child">
								<Animated animationIn="fadeOut" animationOut="fadeIn" isVisible={!showHelp}>  
									<ReadText text = {speechText}/>
								</Animated> 
								{/* <Animated animationIn="fadeOut" animationOut="fadeIn" isVisible={!showHelp}>   */}
									<FamousSpeeches updateSpeech = {updateSpeech}/>
								{/* </Animated>  */}
							</div>
						}
						{
						  showProgress &&
							<Animated animationIn="fadeOut" animationOut="fadeIn" isVisible={!showProgress}>  
								<div className="progress-main-container">
									<div className="progress-chart-header">
										<div className="progress-chart-title">Progress Chart</div>
										<div className="progress-chart-subtitle">A little description of what the chart means</div>
									</div>
									<div className="progress-container">
										<ProgressChart data={data} width = {500} height= {300} horizontalGuides={5} precision={0} color="#5744AB"/>
									</div>
								</div>	
							</Animated> 
						}
					</div>
				</div>
			</div>
		</div>
	);
}

export default Dashboard;