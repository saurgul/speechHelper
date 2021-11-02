import React,{useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';

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
    <div className="App">
      <header className="App-header">
       <div> {speeches} </div>
      </header>
    </div>
  );
}

export default App;
