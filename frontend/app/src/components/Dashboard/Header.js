import React from "react";
import temp from "./temp.png"
import { useNavigate } from "react-router-dom";

function Header() {

  const navigate = useNavigate();
	
	  const handleRoute = () =>{
		console.log("This needs to actually check login info before routing. Otherwise display an error message");
		navigate('/login')
      }

    return(
        <header>
			<div className = "nav-bar-container">
                <div className="profile-info">
                    <div className = "header-image">
                        <img src={temp} alt="header-image" class="avatar"/>
                    </div>
                    <div className="profile">
                        <p class="name">Christian</p>
                        <p class="occupation">Student</p>
                    </div>
                </div>
                <nav id="navbar">
					<button className="theme-btn" onClick={handleRoute} >Logout</button>
                </nav>
			</div>
		</header>
    )
}

export default Header;