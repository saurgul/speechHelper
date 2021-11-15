import React from "react";
import temp from "./temp.png"

function Header({onClick}) {
    return(
        <header>
			<div className = "nav-bar-container">
                <div className="profile-info">
                    <div className = "header-image">
                        <img src={temp} alt="header-image" class="avatar"/>
                    </div>
                    <div className="profile">
                        <p class="name">Joshua</p>
                        <p class="occupation">Student</p>
                    </div>
                </div>
                <nav id="navbar">
					<button className="theme-btn" onClick={onClick}>Logout</button>
                </nav>
			</div>
		</header>
    )
}

export default Header;