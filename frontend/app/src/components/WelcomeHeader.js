import React from "react";
import { useNavigate } from "react-router-dom";

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
					<button className="theme-btn" onClick={handleRoute}>Log In or Sign Up</button>
                </nav>
			</div>
		</header>
    )
}

export default WelcomeHeader;