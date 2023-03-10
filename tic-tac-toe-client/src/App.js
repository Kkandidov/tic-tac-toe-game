import React, {lazy, Suspense} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import Navigator from "./components/navigatorbar/Navigator";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";

const Home = lazy(() => import('./components/home/Home'));
const Game = lazy(() => import('./components/game/Game'));
const Chat = lazy(() => import('./components/chat/Chat'));

const App = () => {
	return (
			<>
				<Router>
					<Navigator/>
					<Suspense fallback={<div>Loading...</div>}>
						<Routes>
							<Route path="/" element={<Home/>}/>
							<Route path='/game' element={<Game/>}/>
							<Route path='/chat' element={<Chat/>}/>
						</Routes>
					</Suspense>
				</Router>
			</>
	);
}

export default App;