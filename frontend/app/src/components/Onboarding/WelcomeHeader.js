import React from "react";
import { useNavigate } from "react-router-dom";
import './Welcome.css';

function WelcomeHeader() {
	
	const navigate = useNavigate();
	
	  const handleRoute = () =>{
		console.log("hi") 
		navigate('/login')
  }
    return(
        <header>
			<div className = "nav-bar-container">
          <div className="profile-info">
          </div>
          <nav id="navbar">
				    <button className="theme-btn" onClick={handleRoute}>Log In</button>
            <a className="secondary-theme-btn" onClick={handleRoute}>Sign up</a>
          </nav>
			</div>
		</header>
    )
}

export default WelcomeHeader;