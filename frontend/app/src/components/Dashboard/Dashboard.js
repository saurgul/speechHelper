import React,{useEffect, useState} from 'react';
import './CSS/Dashboard.css';
import FamousSpeeches from './FamousSpeeches';
import Header from './Header'
import HistoryReport from './HistorySpeech';
import InputForm from './InputForm';
import ReadText from './ReadText';
import {Animated} from "react-animated-css";
import ProgressChart from './ProgressChart';
import LiveAudioRecord from './LiveAudioRecord';
import { useLocation } from 'react-router-dom';
import LoadingIndicator from './LoadingIndicatory';


function Dashboard(){
	const location = useLocation();
	const { userID, name } = location.state;
	const [showHelp, setShow] = useState(false);
	const [showProgress, setProgress] = useState(false);
	const [speechText, setSpeech] = useState("I have a dream that one day down in Alabama, with its vicious racists, with its governor having his lips dripping with the words of interposition and nullification – one day right there in Alabama little black boys and black girls will be able to join hands with little white boys and white girls as sisters and brothers. I have a dream today. I have a dream that one day every valley shall be exalted and every hill and mountain shall be made low, the rough places will be made plain, and the crooked places will be made straight, and the glory of the Lord shall be revealed and all flesh shall see it together.") 
	const [showRecordLiveModal, setRecordLiveModal] = useState(false);
	const [isloading, setLoading] = useState(false);
	const [historySpeeches, setHistorySpeeches] = useState({});
	const [progressData, setProgressData] = useState([])
	const months = ["Jan", "Feb", "Mar", "Jun", "Jul", "Aug", "Sep", "Aug", "Sep", "Oct", "Nov", "Dec"]

	const updateSpeech = (newSpeech) => {
		setSpeech(newSpeech)
	}

	const updateLoading = (show) => {
		setLoading(show)
	}
	
	const reloadHistory = () => {
		getHistoryReport()
	} 

	useEffect(() => {
		getHistoryReport()
	})

	const showRecordAudioModal = (show) => {
		setRecordLiveModal(show);
	}

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

	function handleErrors(response) {
		if (!response.ok) {
			throw Error(response.statusText);
		}
		return response;
	}
	
	const getHistoryReport = async() => {
		fetch(`/speech_user_id?userId=${userID}`, {
			method: 'GET'
		})
		.then(handleErrors)
		.then(async response => {
			const speeches = await response.json();
			setHistorySpeeches(speeches)
			getProgressData()
		})
		.catch(error => console.log(error) );
	}

	const getProgressData = () => {
		// get this Y from backend
		const y = [5, 10, 46, 50, 55, 40, 98, 75]
		y.forEach((score, index) => {
			progressData.push({label: months[index], x: index, y: score})
		});
		setProgressData(progressData)
	}

	return(
		<div> 
			{ showRecordLiveModal && <LiveAudioRecord showRecordAudioModal = {showRecordAudioModal}/> }
			{ isloading && <LoadingIndicator/> }
			<Header name = {name} changeHelp={changeHelp} showHelp={showHelp} changeProgress = {changeProgress}  showProgress = {showProgress} reset = {reset}/> 
			<div className="mainContainer">
				
				<div className= "bgCard">
					<div className="dashboard-container">
						{
							!showProgress && !showHelp && 
							<div className="dashboard-container-child">
								<InputForm userId = {userID} reloadHistory = {reloadHistory} showRecordLiveModal = {showRecordLiveModal} showRecordAudioModal = {showRecordAudioModal} userLoggedIn = {true} updateLoading = {updateLoading}/>	
								<HistoryReport name = {name} userId ={userID} historySpeeches = {historySpeeches}/>
								
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
										<div className="progress-chart-title">Progress Chart (Overall Score vs Time)</div>
										<div className="progress-chart-subtitle">This chart shows your progress overtime. With this you can keep track of how well are you doing each month</div>
									</div>
									<div className="progress-container">
										<ProgressChart data={progressData} width = {500} height= {300} horizontalGuides={5} precision={0} color="#5744AB"/>
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