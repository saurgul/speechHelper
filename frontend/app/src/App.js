import React,{useState, useEffect} from 'react';
import './App.css';
import Dashboard from './components/Dashboard/Dashboard';
import Onboarding from './components/Onboarding/Onboarding';

function App() {
  const[speeches, setSpeeches] = useState();

  useEffect(()=>{
    async function getSpeeches(){
        const response = await fetch('/test');
        console.log(response);
    }

    getSpeeches();
  },[])

  return (
    <div className="App bg-body">
      <link href='https://fonts.googleapis.com/css?family=Sen' rel='stylesheet'/>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css"/> 
      <header className="App-header">
	   <div> <Onboarding /> </div>
       <div> {speeches} </div>
      </header>
    </div>
  );
}

export default App;