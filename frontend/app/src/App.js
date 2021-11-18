import React,{useState, useEffect} from 'react';
import './App.css';
import Welcome from './components/Onboarding/Welcome';
import Onboarding from './components/Onboarding/Onboarding';
import Routing from './Routing';


import {
    BrowserRouter as Router,
    Route,
    Link,
    Switch
} from 'react-router-dom';


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
	<Router>
    <div className="App bg-body">
      <link href='https://fonts.googleapis.com/css?family=Sen' rel='stylesheet'/>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css"/> 
      <header className="App-header">
		<Routing />
      </header>
    </div>
</Router>
  );
}

export default App;