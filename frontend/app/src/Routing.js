import React, { Component } from "react";
import { Router, Routes, Route } from "react-router-dom";

import Onboarding from "./components/Onboarding/Onboarding";
import Welcome from "./components/Onboarding/Welcome";
import Dashboard from "./components/Dashboard/Dashboard";
import history from './history';

export default class Routing extends Component {
    render() {
        return (
                <Routes>
                    <Route path="/" exact element={<Welcome />} />
                    <Route path="/login" element={<Onboarding />} />
                    <Route path="/dashboard" element={<Dashboard />} />
                </Routes>
        )
    }
}